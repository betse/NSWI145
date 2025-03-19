package mff.betse.nswi145;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.*;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.Iterator;

@WebServlet("/RestaurantOrderIntermediary")
public class RestaurantOrderIntermediary extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String TARGET_ENDPOINT = "http://localhost:8080/restaurantOrder"; // restaurantOrder service endpoint

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Create SOAP message from the incoming request
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage(null, request.getInputStream());

            // Extract discount header (if present)
            SOAPHeader header = soapMessage.getSOAPHeader();
            String discountPercentage = "0"; // Default: no discount
            if (header != null) {
                Iterator<?> headers = header.getChildElements(new QName("http://discounts.com/", "discount"));
                if (headers.hasNext()) {
                    SOAPElement discountElement = (SOAPElement) headers.next();
                    discountPercentage = discountElement.getAttribute("percentage");
                }
            }

            // Forward the request to the actual service
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            SOAPMessage soapResponse = soapConnection.call(soapMessage, TARGET_ENDPOINT);

            // Modify the response: Add discount info to the header
            SOAPEnvelope responseEnvelope = soapResponse.getSOAPPart().getEnvelope();
            SOAPHeader responseHeader = responseEnvelope.getHeader();
            if (responseHeader == null) {
                responseHeader = responseEnvelope.addHeader();
            }
            SOAPElement tweakedHeader = responseHeader.addChildElement("discounted", "", "http://discounts.com/");
            tweakedHeader.addTextNode("Discount applied: " + discountPercentage + "%");

            // Modify the response body (append discount note to the return string)
            SOAPBody responseBody = soapResponse.getSOAPBody();
            if (!responseBody.hasFault()) {
                // Get the sendOrderRequestResponse element
                Iterator<?> responseElements = responseBody.getChildElements(
                    new QName("http://food_delivery_app.nswi145.betse.mff/", "sendOrderRequestResponse")
                );
                if (responseElements.hasNext()) {
                    SOAPElement responseElement = (SOAPElement) responseElements.next();
                    // Get the return element
                    Iterator<?> returnElements = responseElement.getChildElements(new QName("return"));
                    if (returnElements.hasNext()) {
                        SOAPElement returnElement = (SOAPElement) returnElements.next();
                        String originalResponse = returnElement.getValue();
                        returnElement.setValue(originalResponse + " (Discount of " + discountPercentage + "% applied)");
                    }
                }
            }

            // Save changes and write the response back to the client
            soapResponse.saveChanges();
            response.setContentType("text/xml");
            soapResponse.writeTo(response.getOutputStream());

            // Close the connection
            soapConnection.close();

        } catch (SOAPException e) {
            throw new ServletException("Error processing SOAP message", e);
        }
    }
}