package com.adil.product_service.exceptions;

import org.springframework.http.ResponseEntity;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }

}
