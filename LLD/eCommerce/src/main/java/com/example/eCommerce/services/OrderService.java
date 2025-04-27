package com.example.eCommerce.services;

import com.example.eCommerce.enums.OrderStatus;
import com.example.eCommerce.models.*;
import com.example.eCommerce.payment.PaymentMethodType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderService {

    public synchronized Order placeOrder(User user, ShoppingCart cart, LocalDateTime orderDate, String shippingAddress, Map<String, String> paymentDetails) {
        List<Item> orderItems = new ArrayList<>();
        for (Item item : cart.getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            if (product.isAvailable(quantity)) {
                product.updateQuantity(-quantity);
                orderItems.add(item);
            }
        }
        if (orderItems.isEmpty()) {
            throw new IllegalStateException("No available products in the cart.");
        }
        String orderId = generateOrderId();
        Order order = new Order(orderId, user.getUserId(), orderItems, OrderStatus.PLACED, orderDate, shippingAddress);
        orders.put(orderId, order);
        user.addOrder(order);
        cart.clear();
        if (order.makePayment(PaymentMethodType.CREDIT_CARD, paymentDetails)) {
            order.setStatus(OrderStatus.PLACED);
        } else {
            order.setStatus(OrderStatus.CANCELLED);
            // Revert the product quantities
            for (Item item : orderItems) {
                Product product = item.getProduct();
                int quantity = item.getQuantity();
                product.updateQuantity(quantity);
            }
        }
        return order;
    }
}
