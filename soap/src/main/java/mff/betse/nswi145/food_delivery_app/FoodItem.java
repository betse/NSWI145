package mff.betse.nswi145.food_delivery_app;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FoodItem {
    private String name;
    private int quantity;

    public FoodItem() {
    }

    public FoodItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}