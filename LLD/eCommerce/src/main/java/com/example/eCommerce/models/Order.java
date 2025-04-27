package com.example.eCommerce.models;

import com.example.eCommerce.enums.OrderStatus;
import com.example.eCommerce.payment.PaymentMethodType;
import com.example.eCommerce.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Order {
    private String orderId;
    private String userId;
    private List<Item> items;
    private OrderStatus status;
    private LocalDateTime orderDate;
    private String shippingAddress;
    private final CheckoutService checkoutService;

    public Order(String orderId, String userId, List<Item> items, OrderStatus status, LocalDateTime orderDate, String shippingAddress) {
        this.orderId = orderId;
        this.userId = userId;
        this.items = items;
        this.status = status;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
    }

    @Autowired
    public Order(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    public boolean makePayment(PaymentMethodType paymentMethodType, Map<String, String> paymentDetails) {
        CheckoutService checkoutService = new CheckoutService();
        // Example 1: Pay using Credit Card
        Map<String, String> ccDetails = new HashMap<>();
        ccDetails.put("cardNumber", "1234567890123456");
        ccDetails.put("cardHolderName", "John Doe");
        ccDetails.put("expiryDate", "12/26");
        ccDetails.put("cvv", "123");
        return checkoutService.checkout(1200.00, PaymentMethodType.CREDIT_CARD, ccDetails);
    }

    public boolean sendForShipment(){
        return true;
    }

    public double getTotalAmount(){
        return items.stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity()).sum();
    }

    public void setStatus(OrderStatus status){
        this.status = status;
    }

}
