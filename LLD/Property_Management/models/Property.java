package models;

import enums.ListingType;
import enums.RoomType;
import lombok.Data;

@Data
public class Property {
    String propertyID;
    String propertyTitle;
    String location;
    String price;
    ListingType listingType;
    String PropertySize;
    RoomType roomType;
    boolean isPropertySold;
    PropertySold propertySoldDetails;

    public void markPropertyAsSold(String soldTo, Integer soldPrice){
        this.isPropertySold = true;
    }
}