package com.informatics.assignment.User.Management.repositories;

import com.informatics.assignment.User.Management.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String userName);
}
