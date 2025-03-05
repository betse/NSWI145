package mff.betse.nswi145.payment_gateway;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.WebParam;

@WebService
public interface IPaymentResponseService {

    @WebMethod
    PaymentResponse sendPaymentResponse(
            @WebParam(name = "transactionId") String transactionId,
            @WebParam(name = "orderId") String orderId,
            @WebParam(name = "status") String status
    );
}