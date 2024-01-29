package com.informatics.assignment.User.Management.services.auth;

import com.informatics.assignment.User.Management.common.Constant;
import com.informatics.assignment.User.Management.dto.ProfileDto;
import com.informatics.assignment.User.Management.dto.SignupDTO;
import com.informatics.assignment.User.Management.dto.UserDTO;
import com.informatics.assignment.User.Management.entities.User;
import com.informatics.assignment.User.Management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(SignupDTO signupDTO) {
        try {
            User user = new User();
            user.setUserName(signupDTO.getUserName());
            user.setFName(signupDTO.getFirstName());
            user.setMName(signupDTO.getMiddleName());
            user.setLName(signupDTO.getLastName());
            user.setDob(signupDTO.getDob());
            user.setAddedDate(new Date());
            user.setAddedBy(signupDTO.getAddedBy());
            user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));

            User createdUser = userRepository.save(user);


            UserDTO userDTO = new UserDTO();
            userDTO.setUserName(createdUser.getUserName());
            userDTO.setFName(createdUser.getFName());
            userDTO.setMName(createdUser.getMName());
            userDTO.setLName(createdUser.getLName());


            return userDTO;
        } catch (Exception e) {
            e.printStackTrace();
            UserDTO errorResponse = new UserDTO();
            errorResponse.setResponseCode(Constant.FAILED_RES_CODE);
            errorResponse.setResponseMessage(Constant.FAILED_RES_MSG_SIGNUP);
            return errorResponse;
        }
    }


    @Override
    public List<ProfileDto> findAllUserProfiles() {
        try {
            List<User> users = userRepository.findAll();
            List<ProfileDto> profileDtos = users.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());

            return profileDtos;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private ProfileDto convertToDTO(User user) {
        ProfileDto profileDto = new ProfileDto();
        profileDto.setId(user.getUserID());
        profileDto.setUserName(user.getUserName());
        profileDto.setFName(user.getFName());
        profileDto.setMName(user.getMName());
        profileDto.setLName(user.getLName());

        return profileDto;
    }
}
