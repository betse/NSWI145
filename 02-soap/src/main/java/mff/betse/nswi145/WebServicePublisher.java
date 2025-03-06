package mff.betse.nswi145;

import mff.betse.nswi145.food_delivery_app.RestaurantOrderServiceImpl;
import mff.betse.nswi145.food_delivery_app.PaymentAuthorizationServiceImpl;
import mff.betse.nswi145.payment_gateway.PaymentResponseServiceImpl;

import javax.xml.ws.Endpoint;

public class WebServicePublisher {
    public static void main(String[] args) {

        // Publish PaymentAuthorizationService
        String authUrl = "http://localhost:8080/paymentAuthorization";
        Endpoint.publish(authUrl, new PaymentAuthorizationServiceImpl());
        System.out.println("Payment Authorization Service running at " + authUrl);

        // Publish PaymentResponseService
        String responseUrl = "http://localhost:8080/paymentResponse";
        Endpoint.publish(responseUrl, new PaymentResponseServiceImpl());
        System.out.println("Payment Response Service running at " + responseUrl);

        // Publish RestaurantOrderService
        String orderUrl = "http://localhost:8080/restaurantOrder";
        Endpoint.publish(orderUrl, new RestaurantOrderServiceImpl());
        System.out.println("Restaurant Order Service running at " + orderUrl);
    }
}