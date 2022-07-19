package com.example.catalogservice.exception;

public class CircuitBreakerException extends Exception{

    public CircuitBreakerException(String message) {
        super(message);
    }
}