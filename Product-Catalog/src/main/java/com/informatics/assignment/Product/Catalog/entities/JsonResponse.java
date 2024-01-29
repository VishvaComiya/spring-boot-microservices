package com.informatics.assignment.Product.Catalog.entities;


import lombok.Data;

@Data
public class JsonResponse {

    private String operation;
    private int responseCode;
    private String responseDesc;
    private Object data;

}
