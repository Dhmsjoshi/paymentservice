package dev.dharam.paymentservice.paymentGateWays;

import com.stripe.exception.StripeException;

public interface PaymentGateWay {
    String generatePaymentLink(Long amount, String orderId) throws StripeException;
}
