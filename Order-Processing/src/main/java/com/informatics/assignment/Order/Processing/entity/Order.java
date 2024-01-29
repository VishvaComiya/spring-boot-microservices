package com.informatics.assignment.Order.Processing.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "ORDER_DM_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderSeqNo")
    @SequenceGenerator(name = "OrderSeqNo" , sequenceName = "ORDER_SEQ_NO", allocationSize = 1)
    @Column(name = "ORDER_ID")
    private Long orderID;

    @Column(name = "ORDER_DECS")
    private String OrderDecs;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PROD_ID")
    private Product product;

    @Column(name = "ADDED_DATE")
    private Date addedDate;

    @Column(name = "STATUS")
    private String status;


}
