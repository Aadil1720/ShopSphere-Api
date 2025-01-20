package com.adil.product_service.controller;

import com.adil.product_service.dto.ProductRequest;
import com.adil.product_service.dto.ProductResponse;
import com.adil.product_service.exceptions.AlreadyExistExceptions;
import com.adil.product_service.reponse.ApiResponse;
import com.adil.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody  ProductRequest request){
        try {
            ProductResponse product = productService.createProduct(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse("success!", product));

        } catch (AlreadyExistExceptions e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ApiResponse("Error: " + e.getMessage(), HttpStatus.CONFLICT));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllProducts() {
        try {
            Object products = productService.getAllProducts();
            return ResponseEntity.ok(new ApiResponse("success!", products));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }


}
