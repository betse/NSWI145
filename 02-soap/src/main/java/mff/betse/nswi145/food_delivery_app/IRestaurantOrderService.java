package mff.betse.nswi145.food_delivery_app;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IRestaurantOrderService {

    @WebMethod
    String sendOrderRequest(
            @WebParam(name = "orderRequest") OrderRequest orderRequest
    );
    @WebMethod
    String checkOrderStatus(
            @WebParam(name = "orderId") String orderId);

}
