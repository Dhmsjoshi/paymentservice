package dev.dharam.paymentservice.services;


import com.stripe.exception.StripeException;
import dev.dharam.paymentservice.Client.orderserviceclient.OrderServiceClient;
import dev.dharam.paymentservice.Client.orderserviceclient.dtos.OrderDto;
import dev.dharam.paymentservice.dtos.CreatePaymentLinkRequestDto;
import dev.dharam.paymentservice.dtos.CreatePaymentLinkResponseDto;
import dev.dharam.paymentservice.paymentGateWays.PaymentGateWay;
import dev.dharam.paymentservice.paymentGateWays.stripe.StripePaymentGateWayAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    private StripePaymentGateWayAdapter stripePaymentGateWayAdapter;
    @Autowired
    private OrderServiceClient orderServiceClient;

    public PaymentServiceImpl(StripePaymentGateWayAdapter stripePaymentGateWayAdapter) {
        this.stripePaymentGateWayAdapter = stripePaymentGateWayAdapter;
    }

    @Override
    public CreatePaymentLinkResponseDto createPaymentLink(CreatePaymentLinkRequestDto requestDto) throws StripeException {


//            Thing to generate payment link we need:
//            String :email of customer
//            String:  phon no. of customer
//            Long:  amount
//
//
//            So,
            OrderDto orderDto = orderServiceClient.getOrderDetails(requestDto.getOrderId());
//            Long userId = order.get(userId)
//            User user =    restClient.get(localhost:8080/users/{userId});
//            String email = user.getEmail()
//            String phonNumber = user.getPhonNumber()
//            Long amount = order.getTotalAmount();
//
//            After completing all above details, payment service will call P.G. to get link
            long totalAmount = (long) (orderDto.getTotalPrice()*100);



        String paymentLink =  stripePaymentGateWayAdapter.generatePaymentLink(totalAmount, requestDto.getOrderId());
        CreatePaymentLinkResponseDto response = new CreatePaymentLinkResponseDto();
        response.setPaymentLink(paymentLink);
        return response;
    }
}
