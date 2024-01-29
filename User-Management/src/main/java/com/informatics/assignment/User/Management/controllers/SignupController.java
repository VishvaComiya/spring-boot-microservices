package com.informatics.assignment.User.Management.controllers;

import com.informatics.assignment.User.Management.common.Constant;
import com.informatics.assignment.User.Management.dto.SignupDTO;
import com.informatics.assignment.User.Management.dto.UserDTO;
import com.informatics.assignment.User.Management.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class SignupController {

    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupDTO signupDTO) {
       UserDTO createdUser = authService.createUser(signupDTO);
       if (createdUser == null){
           return new ResponseEntity<>(Constant.FAILED_RES_MSG_SIGNUP, HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

}
