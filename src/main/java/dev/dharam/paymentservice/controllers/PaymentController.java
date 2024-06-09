package dev.dharam.paymentservice.controllers;

import com.stripe.exception.StripeException;
import dev.dharam.paymentservice.dtos.CreatePaymentLinkRequestDto;
import dev.dharam.paymentservice.dtos.CreatePaymentLinkResponseDto;
import dev.dharam.paymentservice.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public ResponseEntity<CreatePaymentLinkResponseDto> createPaymentLink(@RequestBody  CreatePaymentLinkRequestDto request) throws StripeException {
        CreatePaymentLinkResponseDto response = paymentService.createPaymentLink(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
