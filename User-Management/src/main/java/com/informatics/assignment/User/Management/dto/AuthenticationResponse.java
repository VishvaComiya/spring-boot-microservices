package com.informatics.assignment.User.Management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponse {

    private String token;
    private String type;
    private int resCode;
    private String resMessage;

}
