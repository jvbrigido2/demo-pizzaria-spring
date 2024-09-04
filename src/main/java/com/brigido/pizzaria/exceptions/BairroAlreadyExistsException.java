package com.brigido.pizzaria.exceptions;

public class BairroAlreadyExistsException extends RuntimeException {
    public BairroAlreadyExistsException(String message) {
        super(message);
    }
}
