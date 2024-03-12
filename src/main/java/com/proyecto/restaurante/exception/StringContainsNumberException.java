package com.proyecto.restaurante.exception;

public class StringContainsNumberException extends RuntimeException {

    public StringContainsNumberException() {
    }

    public StringContainsNumberException(String message) {
        super(message);
    }

}
