package com.informatics.assignment.Order.Processing.controller;


import com.informatics.assignment.Order.Processing.client.ProductClient;
import com.informatics.assignment.Order.Processing.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignClientController {

    @Autowired
    private ProductClient productClient;


    @GetMapping("/findAllProducts")
    public List<ProductResponse> getAllProducts(){

        return productClient.getProducts();
    }

}
