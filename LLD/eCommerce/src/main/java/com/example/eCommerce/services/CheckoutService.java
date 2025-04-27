package com.example.eCommerce.services;

import com.example.eCommerce.payment.PaymentContext;
import com.example.eCommerce.payment.PaymentMethodType;
import com.example.eCommerce.payment.PaymentStrategy;
import com.example.eCommerce.payment.PaymentStrategyFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CheckoutService {

    public boolean checkout(double amount, PaymentMethodType paymentMethodType, Map<String, String> paymentDetails) {
        PaymentStrategy paymentStrategy = PaymentStrategyFactory.getPaymentStrategy(paymentMethodType, paymentDetails);

        PaymentContext paymentContext = new PaymentContext();
        paymentContext.setPaymentStrategy(paymentStrategy);

        boolean paymentSuccess = paymentContext.pay(amount);

        if (paymentSuccess) {
            System.out.println("Payment successful! Order placed");
            return true;
        } else {
            System.out.println("Payment failed. Please try again");
        }
        return false;
    }
}
