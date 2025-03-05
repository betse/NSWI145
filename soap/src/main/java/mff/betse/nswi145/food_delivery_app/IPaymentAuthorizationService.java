package mff.betse.nswi145.food_delivery_app;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IPaymentAuthorizationService {

    @WebMethod
    String requestPaymentAuthorization(
        @WebParam(name = "paymentRequest") PaymentRequest paymentRequest
    );
}
