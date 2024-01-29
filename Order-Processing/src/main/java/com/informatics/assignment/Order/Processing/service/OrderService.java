package com.informatics.assignment.Order.Processing.service;

import com.informatics.assignment.Order.Processing.dto.OrderDto;
import com.informatics.assignment.Order.Processing.dto.OrderHistoryDto;
import com.informatics.assignment.Order.Processing.dto.OrderRequest;
import com.informatics.assignment.Order.Processing.dto.UpdateOrderRequest;

import java.util.List;

public interface OrderService {

    OrderDto createOrder(OrderRequest orderRequest);

    List<OrderHistoryDto> findAllOrder();

    String updateOrderStatus(UpdateOrderRequest orderRequest);
}
