package com.proyecto.restaurante.exception;


public class UppercaseInStringException extends RuntimeException{
    public UppercaseInStringException(String message) {
        super(message);
    }

    public UppercaseInStringException() {
    }
}
