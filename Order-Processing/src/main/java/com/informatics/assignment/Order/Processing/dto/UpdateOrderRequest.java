package com.informatics.assignment.Order.Processing.dto;


import lombok.Data;

@Data
public class UpdateOrderRequest {

    private Long orderId;
    private String status;


}
