package com.informatics.assignment.Order.Processing.client;


import com.informatics.assignment.Order.Processing.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "http://localhost:8082",name = "GET-PRODUCT-LIST")
public interface ProductClient {

    @GetMapping("/getProductList")
    public List<ProductResponse> getProducts();
}
