package com.informatics.assignment.Order.Processing.dto;


import lombok.Data;

import java.util.Date;

@Data
public class OrderRequest {

    private String orderDecs;

    private Long userId;

    private Long prodId;

    private Date addedDate;

    private String status;

}
