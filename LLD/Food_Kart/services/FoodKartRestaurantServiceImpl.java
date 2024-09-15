package services;

import dao.RestaurantDao;
import dao.UserDao;
import models.Restaurance;
import strategy.PriceStrategy;
import strategy.RatingStrategy;
import strategy.RestaurantDisplayStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodKartRestaurantServiceImpl implements FoodKartRestaurantService {
    RestaurantDao restaurantDao;
    UserDao userDao;

    public FoodKartRestaurantServiceImpl() {
        this.restaurantDao = RestaurantDao.getInstance();
        this.userDao = UserDao.getInstance();
    }


    @Override
    public void registerRestaurant(String restaurantName, String listOfPincodes, String foodName, double price, int quantity) {
        Restaurance restaurant = new Restaurance(restaurantName, listOfPincodes.split("[/]"), foodName, price, quantity);
        restaurantDao.addRestaurant(restaurant);
    }

    @Override
    public boolean updateQuantity(String restaurantName, int quantityToAdd) {
        Restaurance restaurant = restaurantDao.getRestaurant(restaurantName);
        if (restaurant != null) {
            restaurant.updateQuantity(quantityToAdd);
            return true;
        }
        return false;
    }

    @Override
    public void rateRestaurant(String restaurantName, int rating, String comment) {
        Restaurance restaurant = restaurantDao.getRestaurant(restaurantName);
        restaurant.addComments(rating, comment);
    }

    @Override
    public List<Restaurance> showRestaurant(String sortBy) {
        RestaurantDisplayStrategy strategy = null;
        if (sortBy.equals("rating")) {
            strategy = new RatingStrategy();
        }
        if (sortBy.equals("price")) {
            strategy = new PriceStrategy();
        }
        if (strategy != null)
            return strategy.findRestaurants(restaurantDao.getListOfRestaurants(), userDao.getCurrentLoginUser());
        return new ArrayList<>();
    }

    @Override
    public boolean placeOrder(String restaurantName, int quantity) {
        Restaurance restaurant = restaurantDao.getRestaurant(restaurantName);
        if (restaurant != null) {
            return restaurant.placeOrder(quantity);
        }
        return false;
    }
}
