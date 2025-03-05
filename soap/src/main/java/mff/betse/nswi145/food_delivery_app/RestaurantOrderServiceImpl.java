package mff.betse.nswi145.food_delivery_app;

import javax.jws.WebService;

@WebService(endpointInterface = "mff.betse.nswi145.food_delivery_app.IRestaurantOrderService")
public class RestaurantOrderServiceImpl implements IRestaurantOrderService {

    public String sendOrderRequest(OrderRequest orderRequest) {
        // Mock implementation: Simulate receiving an order request
        System.out.println("Restaurant Order Request Received:");
        System.out.println("Order ID: " + orderRequest.getOrderId());
        System.out.println("Customer Name: " + orderRequest.getCustomerName());
        System.out.println("Food Items:");
        for (FoodItem item : orderRequest.getFoodItems()) {
            System.out.println(" - " + item.getName() + " (Qty: " + item.getQuantity() + ")");
        }

        // Simulate restaurant acceptance (mocked response)
        String confirmationId = "REST_" + System.currentTimeMillis();
        return "Order Accepted by Restaurant - Confirmation ID: " + confirmationId;
    }
}