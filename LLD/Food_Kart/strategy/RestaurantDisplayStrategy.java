package strategy;

import models.Restaurance;
import models.User;

import java.util.List;

public interface RestaurantDisplayStrategy {
    public List<Restaurance> findRestaurants(List<Restaurance> listOfRestaurants, User currentUser);
}

