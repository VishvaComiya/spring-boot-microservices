package com.informatics.assignment.Product.Catalog.dto;

import lombok.Data;

@Data
public class ErrorResponse {

    private int responseCode;
    private String responseDescription;

}
