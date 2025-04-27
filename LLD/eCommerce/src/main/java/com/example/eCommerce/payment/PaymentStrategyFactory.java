package com.example.eCommerce.payment;

import java.util.Map;

public class PaymentStrategyFactory {

    public static PaymentStrategy getPaymentStrategy(PaymentMethodType paymentMethodType, Map<String, String> paymentDetails) {
        switch (paymentMethodType) {
            case CREDIT_CARD:
//                return new CreditCardPayment();
            case UPI:
//                return new UpiPayment();
            case PAYPAL:
//                return new PayPalPayment();
            default:
                throw new IllegalArgumentException("Unsupported payment method: " + paymentMethodType);
        }
    }
}
