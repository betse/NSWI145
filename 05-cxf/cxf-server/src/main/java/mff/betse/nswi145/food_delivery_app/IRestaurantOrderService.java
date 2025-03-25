package mff.betse.nswi145.food_delivery_app;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "IRestaurantOrderService", targetNamespace = "http://food_delivery_app.nswi145.betse.mff/")
public interface IRestaurantOrderService {
	
	@WebMethod(operationName = "sendOrderRequest", action = "urn:SendOrderRequest")
	String sendOrderRequest(@WebParam(name = "arg0") OrderRequest orderRequest);
    @WebMethod(operationName = "checkOrderStatus", action = "urn:CheckOrderStatus")
	String checkOrderStatus(@WebParam(name = "arg0") String orderId);

}
