package com.informatics.assignment.User.Management.services;

import com.informatics.assignment.User.Management.entities.UserTokenStore;
import com.informatics.assignment.User.Management.repositories.TokenStoreRepository;
import com.informatics.assignment.User.Management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserTokenServiceImpl implements UserTokenService{

    @Autowired
    private TokenStoreRepository tokenStoreRepository;

    @Override
    public String saveToken(String token, String userName) {

        try {

            Boolean exist = tokenStoreRepository.existsByUserName(userName);

            if(!exist){

                UserTokenStore userTokenStore = new UserTokenStore();
                userTokenStore.setUserName(userName);
                userTokenStore.setJwtToken(token);
                userTokenStore.setAddedDate(new Date());
                tokenStoreRepository.save(userTokenStore);

            }else{

                UserTokenStore getUser = tokenStoreRepository.findByUserName(userName);
                getUser.setJwtToken(token);
                getUser.setModifyDate(new Date());

                tokenStoreRepository.save(getUser);
            }


            return "Token Saved Successfully!";

        }catch (Exception e){

            e.printStackTrace();

            return "Error!";
        }


    }
}
