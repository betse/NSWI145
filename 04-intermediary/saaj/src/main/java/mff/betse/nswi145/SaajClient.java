package mff.betse.nswi145;

import javax.xml.soap.*;

public class SaajClient {

    public static void main(String[] args) {
        try {
            // Create a SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Endpoint URL
            String orderUrl = "http://localhost:8080/restaurantOrder";

            // Create the SOAP Request message
            SOAPMessage soapRequest = createSOAPRequest();

            // Optionally, print the SOAP Request message to the console
            System.out.println("Request SOAP Message:");
            soapRequest.writeTo(System.out);
            System.out.println("\n");

            // Send the SOAP Request and receive the SOAP Response
            SOAPMessage soapResponse = soapConnection.call(soapRequest, orderUrl);

            // Print the SOAP Response message to the console
            System.out.println("Response SOAP Message:");
            soapResponse.writeTo(System.out);
            System.out.println();

            // Close the connection
            soapConnection.close();
        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server:");
            e.printStackTrace();
        }
    }

    private static SOAPMessage createSOAPRequest() throws Exception {
        // Create a message factory and a new SOAP message
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        // Add SOAPAction header (set to empty string as defined in WSDL binding)
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", "");

        // Get the SOAP part and envelope
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();

        // Define the namespace URI and prefix as in your WSDL/schema
        String namespaceURI = "http://food_delivery_app.nswi145.betse.mff/";
        String prefix = "food";
        envelope.addNamespaceDeclaration(prefix, namespaceURI);

        /*Build the SOAP Body according to the schema:
        <tns:sendOrderRequest>
          <orderRequest>
            <customerName>John Doe</customerName>
            <foodItem>
              <name>Pizza</name>
              <quantity>2</quantity>
            </foodItem>
            <foodItem>
              <name>Pasta</name>
              <quantity>1</quantity>
            </foodItem>
            <orderId>ORDER12345</orderId>
          </orderRequest>
        </tns:sendOrderRequest> */
        
        SOAPBody soapBody = envelope.getBody();

        // Create the sendOrderRequest element
        SOAPElement sendOrderRequestElem = soapBody.addChildElement("sendOrderRequest", prefix);

        // Create the orderRequest element
        SOAPElement orderRequestElem = sendOrderRequestElem.addChildElement("orderRequest");

        // 1. Add customerName element
        SOAPElement customerNameElem = orderRequestElem.addChildElement("customerName");
        customerNameElem.addTextNode("John Doe");

        // 2. Add first foodItem element
        SOAPElement foodItemElem1 = orderRequestElem.addChildElement("foodItem");
        SOAPElement foodNameElem1 = foodItemElem1.addChildElement("name");
        foodNameElem1.addTextNode("Pizza");
        SOAPElement foodQuantityElem1 = foodItemElem1.addChildElement("quantity");
        foodQuantityElem1.addTextNode("2");

        // 3. Add second foodItem element
        SOAPElement foodItemElem2 = orderRequestElem.addChildElement("foodItem");
        SOAPElement foodNameElem2 = foodItemElem2.addChildElement("name");
        foodNameElem2.addTextNode("Pasta");
        SOAPElement foodQuantityElem2 = foodItemElem2.addChildElement("quantity");
        foodQuantityElem2.addTextNode("1");

        // 4. Add orderId element
        SOAPElement orderIdElem = orderRequestElem.addChildElement("orderId");
        orderIdElem.addTextNode("ORDER12345");

        // Save changes to the SOAP message
        soapMessage.saveChanges();

        return soapMessage;
    }
}
