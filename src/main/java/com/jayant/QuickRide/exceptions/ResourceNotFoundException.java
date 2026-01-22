package com.jayant.QuickRide.exceptions;

public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
