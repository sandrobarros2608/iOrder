package com.proyecto.restaurante.exception;

public class EmptyInventoryException extends RuntimeException{
    public EmptyInventoryException() {
    }

    public EmptyInventoryException(String message) {
        super(message);
    }
}
