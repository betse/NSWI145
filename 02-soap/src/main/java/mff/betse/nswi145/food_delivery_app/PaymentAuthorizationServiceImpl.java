package mff.betse.nswi145.food_delivery_app;

import javax.jws.WebService;

@WebService(endpointInterface = "mff.betse.nswi145.food_delivery_app.IPaymentAuthorizationService")
public class PaymentAuthorizationServiceImpl implements IPaymentAuthorizationService {

    public String requestPaymentAuthorization(PaymentRequest paymentRequest) {
        // Mock implementation: Simulate sending a request to Payment Gateway
        System.out.println("Payment Authorization Request Received:");
        System.out.println("Order ID: " + paymentRequest.getOrderId());
        System.out.println("Card Number: " + paymentRequest.getCardNumber());
        System.out.println("Expiry Date: " + paymentRequest.getCardExpiration());
        System.out.println("CVV: " + paymentRequest.getCardCvc());
        System.out.println("Amount: " + paymentRequest.getAmount());

        // Simulate a successful authorization (mocked response)
        String transactionId = "TXN_" + System.currentTimeMillis();
        return "Payment Authorized - Transaction ID: " + transactionId;
    }

}
