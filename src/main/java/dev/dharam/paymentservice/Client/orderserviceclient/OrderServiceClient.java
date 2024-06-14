package dev.dharam.paymentservice.Client.orderserviceclient;

import dev.dharam.paymentservice.Client.orderserviceclient.dtos.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderServiceClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    public OrderDto getOrderDetails(Long orderId){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<OrderDto> orderDtoResponseEntity = restTemplate.getForEntity("http://localhost:8082/order/"+orderId, OrderDto.class);

        return orderDtoResponseEntity.getBody();
    }
}
