package com.onlineshop.notificationservice.exception;

public class EmailNotSentException extends RuntimeException{
    public EmailNotSentException(String message) {
        super(message);
    }
}
