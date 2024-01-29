package com.informatics.assignment.Order.Processing.dto;


import lombok.Data;

import java.util.Date;

@Data
public class OrderHistoryDto {

    private Long orderRefId;
    private String OrderDecs;
    private String userName;
    private String ProductName;
    private Date addedDate;
    private String status;

}
