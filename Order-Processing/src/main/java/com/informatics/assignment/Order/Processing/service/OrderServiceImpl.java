package com.informatics.assignment.Order.Processing.service;

import com.informatics.assignment.Order.Processing.common.Constant;
import com.informatics.assignment.Order.Processing.dto.OrderDto;
import com.informatics.assignment.Order.Processing.dto.OrderHistoryDto;
import com.informatics.assignment.Order.Processing.dto.OrderRequest;
import com.informatics.assignment.Order.Processing.dto.UpdateOrderRequest;
import com.informatics.assignment.Order.Processing.entity.Order;
import com.informatics.assignment.Order.Processing.entity.Product;
import com.informatics.assignment.Order.Processing.entity.User;
import com.informatics.assignment.Order.Processing.reposiotry.OrderRepository;
import com.informatics.assignment.Order.Processing.reposiotry.ProductRepository;
import com.informatics.assignment.Order.Processing.reposiotry.UserRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public OrderDto createOrder(OrderRequest orderRequest) {

        try {

            User user = userRepository.findById(orderRequest.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
            Product product = productRepository.findById(orderRequest.getProdId()).orElseThrow(() -> new RuntimeException("Product not found"));


            Order order = new Order();
            order.setOrderDecs(orderRequest.getOrderDecs());
            order.setUser(user);
            order.setProduct(product);
            order.setAddedDate(new Date());
            order.setStatus("PENDING");

            orderRepository.save(order);

            OrderDto orderDto = new OrderDto();
            orderDto.setOrderRefId(order.getOrderID());
            orderDto.setOrderDecs(orderDto.getOrderDecs());
            orderDto.setResponseCode(Constant.SUCCESS_RES_CODE);
            orderDto.setResponseDecs(Constant.SUCCESS_RES_MSG);

            return orderDto;

        }catch (Exception e){

            e.printStackTrace();

            OrderDto errorDto = new OrderDto();
            errorDto.setResponseCode(Constant.FAILED_RES_CODE);
            errorDto.setResponseDecs(Constant.FAILED_RES_MSG);
            return errorDto;

        }

    }



    @Override
    public List<OrderHistoryDto> findAllOrder() {

        try {
            List<Order> getOrders = orderRepository.findAll();
            List<OrderHistoryDto> orderDto = getOrders.stream()
                    .map(this::convertOrderDto)
                    .collect(Collectors.toList());

            return orderDto;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return Collections.emptyList();

    }


    private OrderHistoryDto convertOrderDto(Order order){

        OrderHistoryDto orderDto = new OrderHistoryDto();
        orderDto.setOrderRefId(order.getOrderID());
        orderDto.setOrderDecs(order.getOrderDecs());
        orderDto.setUserName(order.getUser().getUserName());
        orderDto.setProductName(order.getProduct().getProdName());
        orderDto.setAddedDate(order.getAddedDate());
        orderDto.setStatus(order.getStatus());

        return orderDto;
    }


    @Override
    public String updateOrderStatus(UpdateOrderRequest updateOrderRequest) {

        try{
                Order findOrder = orderRepository.findByOrderID(updateOrderRequest.getOrderId());
                findOrder.setStatus(updateOrderRequest.getStatus());
                Order orderUpdate = orderRepository.save(findOrder);

            return  "Order Status Updated Successfully for order ID" +orderUpdate.getOrderID()+ "";

        }catch (Exception e){

            e.printStackTrace();

            return "Order Updated Unsuccessful!";
        }


    }



}
