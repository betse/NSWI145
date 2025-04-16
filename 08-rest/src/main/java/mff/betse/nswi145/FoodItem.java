package mff.betse.nswi145;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Schema(description = "A single food item in an order")
public class FoodItem {
    @Schema(description = "Name of the food item", example = "Pizza")
    private String name;

    @Schema(description = "Quantity ordered", example = "2")
    private int quantity;

    public FoodItem() { }
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
