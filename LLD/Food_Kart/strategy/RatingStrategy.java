package strategy;

import models.Restaurance;
import models.User;
import services.FoodKartUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RatingStrategy implements RestaurantDisplayStrategy {
    @Override
    public List<Restaurance> findRestaurants(List<Restaurance> listOfRestaurants, User currentUser) {
        List<Restaurance> list = FoodKartUtil.getMatchingRestaurant(listOfRestaurants, currentUser);
        Collections.sort(list, new Comparator<Restaurance>() {
            @Override
            public int compare(Restaurance o1, Restaurance o2) {
                return Double.compare(o2.getRestaurantRating(), o1.getRestaurantRating());
            }
        });
        return list;
    }
}
