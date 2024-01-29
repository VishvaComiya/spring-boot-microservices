package com.informatics.assignment.User.Management.controllers;


import com.informatics.assignment.User.Management.common.Constant;
import com.informatics.assignment.User.Management.dto.ProfileDto;
import com.informatics.assignment.User.Management.dto.UserDTO;
import com.informatics.assignment.User.Management.entities.JsonResponse;
import com.informatics.assignment.User.Management.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileController {


    @Autowired
    private AuthService userService;

    @GetMapping("/findAllProfile")
    public JsonResponse getAllUsers() {

        List<ProfileDto> users = userService.findAllUserProfiles();

        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setOperation("GET USER PROFILES");
        jsonResponse.setData(users);
        jsonResponse.setResponseCode(Constant.SUCCESS_RES_CODE);
        jsonResponse.setResponseDesc(Constant.SUCCESS_RES_MSG);

        return jsonResponse;
    }


}
