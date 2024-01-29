package com.informatics.assignment.Order.Processing.reposiotry;

import com.informatics.assignment.Order.Processing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserID(Long userID);
}
