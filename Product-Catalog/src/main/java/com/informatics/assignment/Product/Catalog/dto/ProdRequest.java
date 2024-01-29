package com.informatics.assignment.Product.Catalog.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProdRequest {

    private String prodName;

    private String prodDescription;

    private String addedBy;

    private Date addedDate;

    private String modifyBy;

    private Date modifyDate;
}
