package com.diagnostic.capteur.exception;

public class ErrorHandler extends RuntimeException {

    public ErrorHandler(String message) {
        super(message);
    }
}
