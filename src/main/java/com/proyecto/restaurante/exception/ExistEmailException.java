package com.proyecto.restaurante.exception;

public class ExistEmailException extends RuntimeException{
    public ExistEmailException() {
    }

    public ExistEmailException(String message) {
        super(message);
    }
}
