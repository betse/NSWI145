package mff.betse.nswi145.food_delivery_app;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

@WebService(targetNamespace = "http://food_delivery_app.nswi145.betse.mff/", endpointInterface = "mff.betse.nswi145.food_delivery_app.IRestaurantOrderService", portName = "RestaurantOrderServiceImplPort", serviceName = "RestaurantOrderServiceImplService")
public class RestaurantOrderServiceImpl implements IRestaurantOrderService {
	private Map<String, String> orderStatusMap = new HashMap<>(); // Mock storage


	public String sendOrderRequest(OrderRequest orderRequest) {
		System.out.println("Restaurant Order Request Received:");
        System.out.println("Order ID: " + orderRequest.getOrderId());
        System.out.println("Customer Name: " + orderRequest.getCustomerName());
        System.out.println("Food Items:");
        for (FoodItem item : orderRequest.getFoodItems()) {
            System.out.println(" - " + item.getName() + " (Qty: " + item.getQuantity() + ")");
        }

        String confirmationId = "REST_" + System.currentTimeMillis();
        orderStatusMap.put(orderRequest.getOrderId(), "PREPARING"); // Mock status
        return "Order Accepted by Restaurant - Confirmation ID: " + confirmationId;
	}

	public String checkOrderStatus(String orderId) {
		String status = orderStatusMap.getOrDefault(orderId, "NOT_FOUND");
        return "Order " + orderId + " Status: " + status;
	}

}
