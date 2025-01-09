package services;

import models.Property;

import java.util.List;

public class PropertyHutDisplay {
    public static void displayProperty(List<Property> propertyList) {
        System.out.println("----------------------------------------------------------------");
        System.out.println(
                "Property ID  |  Property Title | Property Location |  Property Price | Property Size | Property Room | Avaliable For | is propery Avaliable ");
        for (Property property : propertyList) {
            System.out.println(
                    property.getPropertyID() + " " + property.getPropertyTitle() + " " + property.getLocation() + " "
                            + property.getPrice() + " " + property.getPropertySize() + " " + property.getRoomType() + " "
                            + property.getListingType() + " " + property.isPropertySold());
        }
        System.out.println("----------------------------------------------------------------");
    }
}