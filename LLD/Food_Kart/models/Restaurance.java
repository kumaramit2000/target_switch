package models;

import lombok.Data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

@Data
public class Restaurance {
    String resturantId;
    String resturantName;
    HashSet<String> serviceablePincodes;
    FoodItem foodItem;
    Rating rating;

    public Restaurance(String resturantName, String[] serviceablePincodes, String foodName, double price, int quantity) {
        this.resturantId = UUID.randomUUID().toString();
        this.resturantName = resturantName;
        this.serviceablePincodes = new HashSet<>(Arrays.asList(serviceablePincodes));
        this.foodItem = new FoodItem(foodName, price, quantity);
        this.rating = new Rating();
    }

    public void updateQuantity(int quantityToAdd){
        foodItem.quantity += quantityToAdd;
    }

    public void addComments(Integer rat, String comment){
        this.rating.addCommentsAndRating(rat, comment);
    }

    public boolean placeOrder(int quantity){
        if (quantity <= this.foodItem.quantity) {
            this.foodItem.quantity -= quantity;
            return true;
        }
        return false;
    }

    public double getRestaurantRating(){
        return rating.getAverageRating();
    }

    public boolean isLocationServiceAble(String pincode){
        return serviceablePincodes.contains(pincode);
    }

    public boolean isEnoughQuantityAvailable(){
        return this.foodItem.getQuantity() > 0;
    }
}
