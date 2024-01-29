package com.informatics.assignment.User.Management.repositories;

import com.informatics.assignment.User.Management.entities.UserTokenStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenStoreRepository extends JpaRepository<UserTokenStore,String> {

    Boolean existsByUserName(String userName);

    UserTokenStore findByUserName(String userName);

}
