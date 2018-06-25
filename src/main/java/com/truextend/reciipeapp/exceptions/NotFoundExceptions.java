package com.truextend.reciipeapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExceptions extends RuntimeException {

    public NotFoundExceptions() {
        super();
    }

    public NotFoundExceptions(String message) {
        super(message);
    }

    public NotFoundExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
