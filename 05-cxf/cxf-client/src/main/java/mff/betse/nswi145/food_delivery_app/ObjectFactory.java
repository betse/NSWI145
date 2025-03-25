
package mff.betse.nswi145.food_delivery_app;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mff.betse.nswi145.food_delivery_app package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CheckOrderStatus_QNAME = new QName("http://food_delivery_app.nswi145.betse.mff/", "checkOrderStatus");
    private final static QName _CheckOrderStatusResponse_QNAME = new QName("http://food_delivery_app.nswi145.betse.mff/", "checkOrderStatusResponse");
    private final static QName _SendOrderRequest_QNAME = new QName("http://food_delivery_app.nswi145.betse.mff/", "sendOrderRequest");
    private final static QName _SendOrderRequestResponse_QNAME = new QName("http://food_delivery_app.nswi145.betse.mff/", "sendOrderRequestResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mff.betse.nswi145.food_delivery_app
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckOrderStatus }
     * 
     */
    public CheckOrderStatus createCheckOrderStatus() {
        return new CheckOrderStatus();
    }

    /**
     * Create an instance of {@link CheckOrderStatusResponse }
     * 
     */
    public CheckOrderStatusResponse createCheckOrderStatusResponse() {
        return new CheckOrderStatusResponse();
    }

    /**
     * Create an instance of {@link SendOrderRequest }
     * 
     */
    public SendOrderRequest createSendOrderRequest() {
        return new SendOrderRequest();
    }

    /**
     * Create an instance of {@link SendOrderRequestResponse }
     * 
     */
    public SendOrderRequestResponse createSendOrderRequestResponse() {
        return new SendOrderRequestResponse();
    }

    /**
     * Create an instance of {@link OrderRequest }
     * 
     */
    public OrderRequest createOrderRequest() {
        return new OrderRequest();
    }

    /**
     * Create an instance of {@link FoodItem }
     * 
     */
    public FoodItem createFoodItem() {
        return new FoodItem();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckOrderStatus }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckOrderStatus }{@code >}
     */
    @XmlElementDecl(namespace = "http://food_delivery_app.nswi145.betse.mff/", name = "checkOrderStatus")
    public JAXBElement<CheckOrderStatus> createCheckOrderStatus(CheckOrderStatus value) {
        return new JAXBElement<CheckOrderStatus>(_CheckOrderStatus_QNAME, CheckOrderStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckOrderStatusResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckOrderStatusResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://food_delivery_app.nswi145.betse.mff/", name = "checkOrderStatusResponse")
    public JAXBElement<CheckOrderStatusResponse> createCheckOrderStatusResponse(CheckOrderStatusResponse value) {
        return new JAXBElement<CheckOrderStatusResponse>(_CheckOrderStatusResponse_QNAME, CheckOrderStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendOrderRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SendOrderRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://food_delivery_app.nswi145.betse.mff/", name = "sendOrderRequest")
    public JAXBElement<SendOrderRequest> createSendOrderRequest(SendOrderRequest value) {
        return new JAXBElement<SendOrderRequest>(_SendOrderRequest_QNAME, SendOrderRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendOrderRequestResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SendOrderRequestResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://food_delivery_app.nswi145.betse.mff/", name = "sendOrderRequestResponse")
    public JAXBElement<SendOrderRequestResponse> createSendOrderRequestResponse(SendOrderRequestResponse value) {
        return new JAXBElement<SendOrderRequestResponse>(_SendOrderRequestResponse_QNAME, SendOrderRequestResponse.class, null, value);
    }

}
