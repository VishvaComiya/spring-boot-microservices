package com.informatics.assignment.User.Management.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "USER_DM_USER")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSeqNo")
    @SequenceGenerator(name = "UserSeqNo" , sequenceName = "USER_SEQ_NO", allocationSize = 1)

    @Column(name = "USER_ID")
    private Long userID;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "F_NAME")
    private String fName;

    @Column(name = "M_NAME")
    private String mName;

    @Column(name = "L_NAME")
    private String lName;

    @Column(name = "DOB")
    private String dob;

    @Column(name = "ADDED_DATE")
    private Date addedDate;

    @Column(name = "ADDED_BY")
    private String addedBy;

    @Column(name = "PASSWORD")
    private String password;

}
