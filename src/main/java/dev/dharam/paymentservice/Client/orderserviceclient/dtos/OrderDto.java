package dev.dharam.paymentservice.Client.orderserviceclient.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {
    private List<OrderItemDto> orderItemDtos;
    private double totalPrice;
}
