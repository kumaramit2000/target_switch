package services;

import dao.PropertyHuntDao;
import enums.ListingType;
import enums.RoomType;
import models.Property;

import java.util.List;

public class PropertyHuntServiceImpl implements PropertyHuntService{

    PropertyHuntDao propertyHuntDao;
    public PropertyHuntServiceImpl() {
        this.propertyHuntDao = PropertyHuntDao.getInstance();
    }

    @Override
    public String loginUser(String userId) {
        System.out.println("Current user logged in : " + userId);
        return propertyHuntDao.loginNewUser(userId);
    }

    @Override
    public void listProperty(String propertyId, String propertyTitle, String location, String price, ListingType listingType, String size, RoomType roomType) {

    }

    @Override
    public void shortListProperty(String propertyID) {

    }

    @Override
    public void viewShortListProperty() {
        List<Property> listOfShortListed = propertyHuntDao.getListedProperty();
        PropertyHutDisplay.displayProperty(listOfShortListed);
    }

    @Override
    public void viewListedProperty() {
        List<Property> listOfPropertyListed = propertyHuntDao.getListedProperty();
        PropertyHutDisplay.displayProperty(listOfPropertyListed);
    }

    @Override
    public void markAsSold(String propertyId, String soldTo, String soldPrice) {
        List<Property> propertyList = propertyHuntDao.getListedProperty();
        boolean canPropertyBeSold = false;
        for (Property property : propertyList) {
            if (property.getPropertyID() == propertyId) {
                canPropertyBeSold = true;
                break;
            }
        }
        if (!canPropertyBeSold) {
            throw new RuntimeException("property can't be sold as your are a different user");
        }
        Property property = propertyHuntDao.getProperty(propertyId);
        if (property != null) {
            property.markPropertyAsSold(soldTo, Integer.valueOf(soldPrice));
        }
    }

    @Override
    public void searchProperty(String location, String price, ListingType listingType, String size, RoomType roomType) {

    }

}