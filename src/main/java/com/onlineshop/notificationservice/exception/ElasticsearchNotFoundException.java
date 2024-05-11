package com.onlineshop.notificationservice.exception;

public class ElasticsearchNotFoundException extends RuntimeException{
    public ElasticsearchNotFoundException(String message) {
        super(message);
    }
}
