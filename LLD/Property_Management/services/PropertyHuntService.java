package services;

import enums.ListingType;
import enums.RoomType;

public interface PropertyHuntService {
    void listProperty(String propertyId, String propertyTitle, String location, String price, ListingType listingType,
                      String size, RoomType roomType);
    void shortListProperty(String propertyID);
    void viewShortListProperty();
    void viewListedProperty();
    void markAsSold(String propertyId, String soldTo, String soldPrice);
    void searchProperty(String location, String price, ListingType listingType, String size, RoomType roomType);
    String loginUser(String name);
}