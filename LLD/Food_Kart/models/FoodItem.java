package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FoodItem {
    String foodName;
    Double price;
    Integer quantity;
    public FoodItem(String name) {
        this.foodName = name;
        this.price = 0.0;
        this.quantity = 0;
    }

    public void addQuantity(int quantity){
        this.quantity += quantity;
    }
}
