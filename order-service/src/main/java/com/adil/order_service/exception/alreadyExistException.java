package com.adil.order_service.exception;

public class alreadyExistException extends RuntimeException {
    public alreadyExistException(String message) {
        super(message);
    }
}
