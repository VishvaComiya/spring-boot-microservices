package com.informatics.assignment.Product.Catalog.controller;


import com.informatics.assignment.Product.Catalog.common.Constant;
import com.informatics.assignment.Product.Catalog.dto.ProdRequest;
import com.informatics.assignment.Product.Catalog.dto.ProductDto;
import com.informatics.assignment.Product.Catalog.entities.JsonResponse;
import com.informatics.assignment.Product.Catalog.service.ProdService;
import jakarta.ws.rs.GET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProdService prodService;

    @PostMapping("/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody ProdRequest prodRequest){

        ProductDto product = prodService.createProduct(prodRequest);

        if(prodRequest == null){

            return new ResponseEntity<>(Constant.FAILED_RES_MSG_SIGNUP, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(product, HttpStatus.CREATED);

    }


    @GetMapping("/getProductList")
    public List<ProductDto> getAllProducts(){

        List<ProductDto> productList = prodService.getAllProduct();
        return productList;

    }


    @GetMapping("/findProductById/{prodId}")
    public ResponseEntity<?> findProductById(@PathVariable Long prodId){

        ProductDto getProduct = prodService.getProductById(prodId);
        return new ResponseEntity<>(getProduct, HttpStatus.CREATED);
    }



}
