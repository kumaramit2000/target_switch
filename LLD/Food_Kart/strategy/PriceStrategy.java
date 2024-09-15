package strategy;

import models.Restaurance;
import models.User;
import services.FoodKartUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PriceStrategy implements RestaurantDisplayStrategy {

    @Override
    public List<Restaurance> findRestaurants(List<Restaurance> listOfRestaurants, User currentUser) {
        List<Restaurance> list = FoodKartUtil.getMatchingRestaurant(listOfRestaurants, currentUser);
        Collections.sort(list, new Comparator<Restaurance>() {
            @Override
            public int compare(Restaurance restaurant1, Restaurance restaurant2) {
                return Double.compare(restaurant2.getFoodItem().getPrice(), restaurant1.getFoodItem().getPrice());
            }
        });

        return list;
    }
}
