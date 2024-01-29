package com.informatics.assignment.Order.Processing.reposiotry;

import com.informatics.assignment.Order.Processing.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    Order findByOrderID(Long orderID);
}
