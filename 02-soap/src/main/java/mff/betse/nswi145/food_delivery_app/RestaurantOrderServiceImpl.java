package mff.betse.nswi145.food_delivery_app;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

@WebService(endpointInterface = "mff.betse.nswi145.food_delivery_app.IRestaurantOrderService")
public class RestaurantOrderServiceImpl implements IRestaurantOrderService {
    
    private Map<String, String> orderStatusMap = new HashMap<>(); // Mock storage

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
        //String confirmationId = "REST_" + System.currentTimeMillis();
        orderStatusMap.put(orderRequest.getOrderId(), "Accepted");
        return orderRequest.getOrderId();
    }

    public String checkOrderStatus(String orderId) {
        String status = orderStatusMap.getOrDefault(orderId, "Not Found");
        return "Order Status for " + orderId + ": " + status;
    }
}