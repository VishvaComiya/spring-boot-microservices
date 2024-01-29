package com.informatics.assignment.User.Management.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private String userName;

    private String fName;

    private String mName;

    private String lName;

    private int responseCode;

    private String responseMessage;


}
