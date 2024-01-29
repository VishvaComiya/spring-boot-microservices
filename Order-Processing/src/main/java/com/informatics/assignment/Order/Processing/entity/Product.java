package com.informatics.assignment.Order.Processing.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Table(name = "PROD_DM_PROD")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProdSeqNo")
    @SequenceGenerator(name = "ProdSeqNo" , sequenceName = "PROD_SEQ_NO", allocationSize = 1)
    @Column(name = "PROD_ID")
    private Long proID;

    @Column(name = "PROD_NAME")
    private String prodName;

    @Column(name = "PROD_DESCRIPTION")
    private String prodDescription;

    @Column(name = "ADDED_BY")
    private String addedBy;

    @Column(name = "ADDED_DATE")
    private Date addedDate;

    @Column(name = "MODIFY_BY")
    private String modifyBy;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;
}
