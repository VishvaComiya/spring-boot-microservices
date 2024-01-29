package com.informatics.assignment.User.Management.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class SignupDTO {


    private String userName;

    private String firstName;

    private String middleName;

    private String lastName;

    private String dob;

    private Date addedDate;

    private String addedBy;

    private String password;

}
