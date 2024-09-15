package services;

import models.Restaurance;

import java.util.List;

public interface FoodKartRestaurantService {
    void registerRestaurant(String restaurantName, String listOfPincodes, String foodName, double price,
                            int quantity);

    boolean updateQuantity(String restaurantName, int quantityToAdd);

    void rateRestaurant(String restaurantName, int rating, String comment);

    List<Restaurance> showRestaurant(String sortBy);

    boolean placeOrder(String restaurantName, int quantity);
}
