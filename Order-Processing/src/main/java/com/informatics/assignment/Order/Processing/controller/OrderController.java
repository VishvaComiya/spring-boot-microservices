package com.informatics.assignment.Order.Processing.controller;


import com.informatics.assignment.Order.Processing.common.Constant;
import com.informatics.assignment.Order.Processing.dto.OrderDto;
import com.informatics.assignment.Order.Processing.dto.OrderHistoryDto;
import com.informatics.assignment.Order.Processing.dto.OrderRequest;
import com.informatics.assignment.Order.Processing.dto.UpdateOrderRequest;
import com.informatics.assignment.Order.Processing.entity.JsonResponse;
import com.informatics.assignment.Order.Processing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/createOrder")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest){

        OrderDto orderDto = orderService.createOrder(orderRequest);

        if(orderDto == null){

            return new ResponseEntity<>(Constant.FAILED_RES_MSG_SIGNUP, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
    }


    @GetMapping("/orderHistory")
    public JsonResponse orderHistory(){

        List<OrderHistoryDto> getAll = orderService.findAllOrder();

       JsonResponse jsonResponse = new JsonResponse();
       jsonResponse.setOperation("ORDER HISTORY");
       jsonResponse.setData(getAll);
       jsonResponse.setResponseCode(Constant.SUCCESS_RES_CODE);
       jsonResponse.setResponseDesc(Constant.SUCCESS_RES_MSG);

        return jsonResponse;
    }

    @PostMapping("/updateOrder")
    public ResponseEntity<?> updateOrderId(@RequestBody UpdateOrderRequest updateOrderRequest ){

        String orderUpdate = orderService.updateOrderStatus(updateOrderRequest);
        return new ResponseEntity<>(orderUpdate, HttpStatus.CREATED);

    }


}
