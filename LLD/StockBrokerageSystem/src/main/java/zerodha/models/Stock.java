package zerodha.models;

import zerodha.enums.ExchangeType;

public class Stock {
//    String exchange;
    String name;
    double price;
    ExchangeType type;

    public Stock(double price, String name, ExchangeType type) {
        this.price = price;
        this.name = name;
        this.type = type;
    }
}
