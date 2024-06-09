package dev.dharam.paymentservice.services;

import com.stripe.exception.StripeException;
import dev.dharam.paymentservice.dtos.CreatePaymentLinkRequestDto;
import dev.dharam.paymentservice.dtos.CreatePaymentLinkResponseDto;

public interface PaymentService {
    CreatePaymentLinkResponseDto createPaymentLink(CreatePaymentLinkRequestDto requestDto) throws StripeException;
}
