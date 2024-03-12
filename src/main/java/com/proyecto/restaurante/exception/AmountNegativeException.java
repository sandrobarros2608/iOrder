package com.proyecto.restaurante.exception;


public class AmountNegativeException extends RuntimeException{
    public AmountNegativeException() {
    }

    public AmountNegativeException(String message) {
        super(message);
    }
}
