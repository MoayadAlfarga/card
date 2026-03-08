package com.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CardAlreadyExistsException extends RuntimeException {
    public CardAlreadyExistsException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s already exists with the given input data %s : '%s'", resourceName, fieldName, fieldValue));
    }
}
