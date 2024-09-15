package services;

import models.Restaurance;
import models.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FoodKartUtil {
    public static List<Restaurance> getMatchingRestaurant(List<Restaurance> listOfRestaurants, User currentUser) {
        List<Restaurance> list = new ArrayList<>(listOfRestaurants);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Restaurance restaurant = (Restaurance) iterator.next();
            if (!restaurant.isLocationServiceAble(currentUser.getPincode()) && restaurant.isEnoughQuantityAvailable()) {
                iterator.remove();
            }
        }
        return list;
    }
}
