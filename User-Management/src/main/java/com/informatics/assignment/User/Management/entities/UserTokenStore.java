package com.informatics.assignment.User.Management.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "USER_TOKEN_STORE")
@Data
public class UserTokenStore {

    @Id
    @Column(name = "USER_NAME")
    private String userName;


    @Column(name = "JWT_TOKEN")
    private String jwtToken;

    @Column(name = "ADDED_DATE")
    private Date addedDate;


    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

}
