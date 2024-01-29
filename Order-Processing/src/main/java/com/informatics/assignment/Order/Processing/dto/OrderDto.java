package com.informatics.assignment.Order.Processing.dto;

import jakarta.persistence.Column;
import lombok.Data;


@Data
public class OrderDto {

    private Long orderRefId;
    private String OrderDecs;
    private int responseCode;
    private String responseDecs;

}
