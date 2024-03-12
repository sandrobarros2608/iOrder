package com.proyecto.restaurante.exception;

public class IdComidaNotFoundException extends RuntimeException{
    public IdComidaNotFoundException() {
    }

    public IdComidaNotFoundException(String message) {
        super(message);
    }
}
