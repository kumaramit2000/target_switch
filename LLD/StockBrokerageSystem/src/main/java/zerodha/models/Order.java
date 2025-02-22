package zerodha.models;

import zerodha.enums.ExchangeType;
import zerodha.enums.OrderType;
import zerodha.enums.TransactionType;

public class Order {
    OrderType orderType;
    TransactionType transactionType;
    double price;
    double quantity;
    Stock stock;
    ExchangeType exchange;
    // list of transactions...

    public Order(OrderType orderType, TransactionType transactionType, double price, double quantity, Stock stock, ExchangeType exchange) {
        this.orderType = orderType;
        this.transactionType = transactionType;
        this.price = price;
        this.quantity = quantity;
        this.stock = stock;
        this.exchange = exchange;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setExchange(ExchangeType exchange) {
        this.exchange = exchange;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public Stock getStock() {
        return stock;
    }

    public ExchangeType getExchange() {
        return exchange;
    }
}
