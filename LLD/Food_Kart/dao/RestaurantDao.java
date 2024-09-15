package dao;

import models.Restaurance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantDao {
    private static RestaurantDao restaurantDaoInstance = null;
    private HashMap<String, Restaurance> restaurantMap;
    public static RestaurantDao getInstance() {
        if (restaurantDaoInstance == null) {
            restaurantDaoInstance = new RestaurantDao();
        }
        return restaurantDaoInstance;
    }

    private RestaurantDao() {
        this.restaurantMap = new HashMap<>();
    }

    public void addRestaurant(Restaurance rec){
        if (this.restaurantMap.containsKey(rec.getResturantName())) {
            System.out.println("restaurant Already present");
        }
        this.restaurantMap.put(rec.getResturantName(), rec);
    }

    public Restaurance getRestaurant(String name){
        if(!restaurantMap.containsKey(name)){
            System.out.println("Restaurance not present!!!");
            return null;
        } else {
            return restaurantMap.get(name);
        }
    }

    public List<Restaurance> getListOfRestaurants(){
        List<Restaurance> list = new ArrayList<>();
        for (Map.Entry<String, Restaurance> entry : restaurantMap.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

}
