package com.smartosc.training.exception;

public class RestTemplateException extends RuntimeException {

    public RestTemplateException(String message) {
        super(message);
    }

    public RestTemplateException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
