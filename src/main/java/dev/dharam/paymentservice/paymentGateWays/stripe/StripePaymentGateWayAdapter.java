package dev.dharam.paymentservice.paymentGateWays.stripe;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import dev.dharam.paymentservice.paymentGateWays.PaymentGateWay;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentGateWayAdapter implements PaymentGateWay {

    @Value("${stripe.secret.key}")
    private String stripeSecretKey;
    @Override
    public String generatePaymentLink(Long amount, String orderId) throws StripeException {
//       System.out.println(stripeSecretKey);
        Stripe.apiKey = stripeSecretKey;



        ProductCreateParams params =
                ProductCreateParams.builder().setName("Generic").build();
        Product product = Product.create(params);



        //first create price object
        PriceCreateParams priceCreateParams =
                PriceCreateParams.builder()
                        .setCurrency("inr")
                        .setUnitAmount(amount) // amount = amout *100 // Rs 10 => 1000
                        .setProduct(product.getId())
                        .build();

        Price price = Price.create(priceCreateParams);

        //after created payment link for perticular price object
        PaymentLinkCreateParams paymentLinkCreateParams =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
//                        .setAfterCompletion(
//                                PaymentLinkCreateParams.AfterCompletion.builder()
//                                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
//                                        .setRedirect(
//                                                PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
//                                                        .setUrl("google.com/?orderId="+orderId).build()
//
//                                        )
//                                        .build()
//                        )

                        .build();


        PaymentLink paymentLink = PaymentLink.create(paymentLinkCreateParams);
        return paymentLink.getUrl();
    }
}
