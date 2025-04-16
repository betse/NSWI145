package mff.betse.nswi145;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="order")
@XmlAccessorType(XmlAccessType.FIELD)
@Schema(description = "An order of food items")
public class Order {
    @Schema(description = "Unique order ID", example = "ORD12345")
    private String id;

    @XmlElement(name = "customer")
    @Schema(description = "Name of the customer", example = "John Doe")
    private String customerName;

    @Schema(description = "List of items in this order")
    @XmlElement(name = "foodItem")
    private List<FoodItem> items;

    @Schema(description = "Current status", example = "Pending")
    private String status;

    public Order() { }

    public Order(String id, String customerName, List<FoodItem> items, String status) {
        this.id           = id;
        this.customerName = customerName;
        this.items        = items;
        this.status       = status;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<FoodItem> getItems() {
        return items;
    }
    public void setItems(List<FoodItem> items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
