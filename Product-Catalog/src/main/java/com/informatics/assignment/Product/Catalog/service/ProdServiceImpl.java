package com.informatics.assignment.Product.Catalog.service;

import com.informatics.assignment.Product.Catalog.common.Constant;
import com.informatics.assignment.Product.Catalog.dto.ErrorResponse;
import com.informatics.assignment.Product.Catalog.dto.ProdRequest;
import com.informatics.assignment.Product.Catalog.dto.ProductDto;
import com.informatics.assignment.Product.Catalog.entities.Product;
import com.informatics.assignment.Product.Catalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProdServiceImpl implements ProdService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProdRequest prodRequest) {

        try {

        Product product = new Product();
        product.setProdName(prodRequest.getProdName());
        product.setProdDescription(prodRequest.getProdDescription());
        product.setAddedBy(prodRequest.getAddedBy());
        product.setAddedDate(new Date());

        Product save = productRepository.save(product);

        ProductDto productDto = new ProductDto();
        productDto.setProdId(product.getProID());
        productDto.setProdName(product.getProdName());
        productDto.setProdDescription(product.getProdDescription());
        productDto.setAddedBy(product.getAddedBy());
        productDto.setAddedDate(product.getAddedDate());

        return productDto;

        } catch (Exception e) {

            e.printStackTrace();
            ProductDto errorPro = new ProductDto();
            errorPro.setResponseCode(Constant.FAILED_RES_CODE);
            errorPro.setResponseMessage(Constant.FAILED_RES_MSG_SIGNUP);
            return errorPro;
        }
    }

    @Override
    public List<ProductDto> getAllProduct() {

        try {
            List<Product> getProducts = productRepository.findAll();
            List<ProductDto> proDto = getProducts.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());

            return proDto;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return Collections.emptyList();
    }


    private ProductDto convertToDTO(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProdId(product.getProID());
        productDto.setProdName(product.getProdName());
        productDto.setProdDescription(product.getProdDescription());
        productDto.setAddedBy(product.getAddedBy());
        productDto.setAddedDate(product.getAddedDate());

        return productDto;
    }

    @Override
    public ProductDto getProductById(Long prodID) {

        try{

            Product getProduct = productRepository.findProductByProID(prodID);
            ProductDto productDto = new ProductDto();
            productDto.setProdId(getProduct.getProID());
            productDto.setProdName(getProduct.getProdName());
            productDto.setProdDescription(getProduct.getProdDescription());
            productDto.setAddedBy(getProduct.getAddedBy());
            productDto.setAddedDate(getProduct.getAddedDate());
            productDto.setResponseCode(Constant.SUCCESS_RES_CODE);
            productDto.setResponseMessage(Constant.SUCCESS_RES_MSG);

            return productDto;

        }catch (Exception e){
            e.printStackTrace();

            ProductDto errorProd = new ProductDto();
            errorProd.setResponseCode(Constant.FAILED_RES_CODE);
            errorProd.setResponseMessage(Constant.PRODUCT_CANT_FIND);

            return errorProd;

        }



    }


}
