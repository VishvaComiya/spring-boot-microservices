package com.informatics.assignment.User.Management.services.auth;

import com.informatics.assignment.User.Management.dto.ProfileDto;
import com.informatics.assignment.User.Management.dto.SignupDTO;
import com.informatics.assignment.User.Management.dto.UserDTO;

import java.util.List;


public interface AuthService {
    UserDTO createUser(SignupDTO signupDTO);

    List<ProfileDto> findAllUserProfiles();

}
