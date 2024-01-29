package com.informatics.assignment.User.Management.services;

import com.informatics.assignment.User.Management.entities.UserTokenStore;

public interface UserTokenService {

    String saveToken(String token, String userName);

}
