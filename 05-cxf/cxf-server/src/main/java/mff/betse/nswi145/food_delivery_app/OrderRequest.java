package mff.betse.nswi145.food_delivery_app;

import java.util.ArrayList;
import java.util.List;

public class OrderRequest {
    private String orderId;
    private String customerName;
    private List<FoodItem> foodItems;

    public OrderRequest() {
        this.foodItems = new ArrayList<>();
    }

    public OrderRequest(String orderId, String customerName, List<FoodItem> foodItems) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.foodItems = foodItems != null ? foodItems : new ArrayList<>();
    }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }


    public List<FoodItem> getFoodItems() { return foodItems; }
    public void setFoodItems(List<FoodItem> foodItems) { this.foodItems = foodItems != null ? foodItems : new ArrayList<>(); }
}