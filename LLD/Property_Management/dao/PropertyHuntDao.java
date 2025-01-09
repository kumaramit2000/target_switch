package dao;
import models.Property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PropertyHuntDao {
    // list of Property for Each user ID;
    private HashMap<String, List<Property>> userPropertyMap;
    // list of Shortlist property against each user ID.
    private HashMap<String, List<Property>> userShortlistedMap;
    private HashMap<String, Property> listOfAvailableProperty;
    private String currentUserId;
    private static PropertyHuntDao propertyHuntDaoInstance;

    private PropertyHuntDao() {
        this.userPropertyMap = new HashMap<>();
        this.userShortlistedMap = new HashMap<>();
        listOfAvailableProperty = new HashMap<>();
    }

    public static PropertyHuntDao getInstance() {
        if (propertyHuntDaoInstance == null) {
            propertyHuntDaoInstance = new PropertyHuntDao();
        }
        return propertyHuntDaoInstance;
    }

    public String loginNewUser(String userId){
        this.currentUserId = userId;
        return currentUserId;
    }

    public List<Property> getListedProperty(){
        if (userPropertyMap.containsKey(currentUserId)) {
            return new ArrayList<>(userPropertyMap.get(currentUserId));
        }
        return new ArrayList<>();
    }

    public Property getProperty(String propertyId) {
        if (!listOfAvailableProperty.containsKey(propertyId)) {
            System.out.println("Property with the property ID not present");
        }
        return listOfAvailableProperty.get(propertyId);
    }

}