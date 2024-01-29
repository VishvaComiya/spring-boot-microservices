package com.informatics.assignment.Product.Catalog.service;

import com.informatics.assignment.Product.Catalog.dto.ProdRequest;
import com.informatics.assignment.Product.Catalog.dto.ProductDto;

import java.util.List;

public interface ProdService {


    ProductDto createProduct(ProdRequest prodRequest);

    List<ProductDto> getAllProduct();

    ProductDto getProductById(Long prodID);

}
