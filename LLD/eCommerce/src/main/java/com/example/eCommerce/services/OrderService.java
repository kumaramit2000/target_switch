package com.example.eCommerce.services;

import com.example.eCommerce.enums.OrderStatus;
import com.example.eCommerce.models.*;
import com.example.eCommerce.payment.PaymentMethodType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    InventoryService inventoryService;

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

//    ----

    public void cancelOrderItem(String orderId, String orderItemId) {
        Order order = getOrderById(orderId);
        OrderItem item = order.getOrderItemById(orderItemId);

        if (item.getStatus() == OrderItemStatus.ORDERED) {
            item.setStatus(OrderItemStatus.CANCELLED);
            inventoryService.increaseStock(item.getProduct().getProductId(), item.getQuantity());
        }

        updateOrderStatus(order);
        recalculateTotal(order);
    }

    public void cancelEntireOrder(String orderId) {
        Order order = getOrderById(orderId);

        for (OrderItem item : order.getItems()) {
            if (item.getStatus() == OrderItemStatus.ORDERED) {
                item.setStatus(OrderItemStatus.CANCELLED);
                inventoryService.increaseStock(item.getProduct().getProductId(), item.getQuantity());
            }
        }

        order.setStatus(OrderStatus.CANCELLED);
        order.setTotalPrice(0);
    }

    private void updateOrderStatus(Order order) {
        boolean allCancelled = order.getItems().stream().allMatch(i -> i.getStatus() == OrderItemStatus.CANCELLED);
        boolean someCancelled = order.getItems().stream().anyMatch(i -> i.getStatus() == OrderItemStatus.CANCELLED);

        if (allCancelled) {
            order.setStatus(OrderStatus.CANCELLED);
        } else if (someCancelled) {
            order.setStatus(OrderStatus.PARTIALLY_CANCELLED);
        }
    }

    private void recalculateTotal(Order order) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            if (item.getStatus() != OrderItemStatus.CANCELLED) {
                total += item.getItemPrice();
            }
        }
        order.setTotalPrice(total);
    }

    private Order getOrderById(String orderId) {
        // Fetch from DB or in-memory map
        return null;
    }

//    ----
}
