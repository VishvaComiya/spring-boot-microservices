package com.informatics.assignment.Order.Processing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ProductResponse {

    @JsonProperty("prodId")
    private Long prodId;

    @JsonProperty("prodName")
    private String prodName;

    @JsonProperty("prodDescription")
    private String prodDescription;

    @JsonProperty("addedBy")
    private String addedBy;

    @JsonProperty("addedDate")
    private Date addedDate;

    @JsonProperty("modifyBy")
    private String modifyBy;

    @JsonProperty("modifyDate")
    private Date modifyDate;

    @JsonProperty("responseCode")
    private int responseCode;

    @JsonProperty("responseMessage")
    private String responseMessage;
}