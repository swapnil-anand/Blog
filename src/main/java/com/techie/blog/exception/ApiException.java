package com.techie.blog.exception;

import java.time.LocalDateTime;

public class ApiException {
    private final String message;
    private final Integer statusCode;
    private final LocalDateTime time;

    public ApiException(String message, Integer statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.time = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
