package models;

import lombok.Data;

@Data
public class PropertySold {
    String soldTo;
    int soldPrice;
    public PropertySold() {
        this.soldTo = null;
        this.soldPrice = 0;
    }
}