package dev.dharam.paymentservice.Client.orderserviceclient.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
    private String itemName;
    private int quantity;
    private double price;


}
