package mff.betse.nswi145.payment_gateway;

import javax.jws.WebService;

@WebService(endpointInterface = "mff.betse.nswi145.payment_gateway.IPaymentResponseService")
public class PaymentResponseServiceImpl implements IPaymentResponseService {
    
    public PaymentResponse sendPaymentResponse(String transactionId, String orderId, String status) {
        // Mock implementation: Simulate Payment Gateway response
        System.out.println("Payment Response Generated:");
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Order ID: " + orderId);
        System.out.println("Status: " + status);

        // Mock logic: Return a response based on status
        String message = status.equals("SUCCESS") ? "Payment processed successfully" : "Payment failed";
        return new PaymentResponse(transactionId, orderId, status, message);
    }

}
