package dev.dharam.paymentservice.controllers.webhooks;

import com.stripe.model.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhooks/stripe")
public class StripeWebhooksController {
   // @PostMapping("/")
//    public void handleWebhookRequest(@RequestBody Event webhookEvent){
//         return null;
//    }
}
