package com.onlineshop.notificationservice.exception;

public class MongoNotFoundException extends RuntimeException{
    public MongoNotFoundException(String message) {
        super(message);
    }
}
