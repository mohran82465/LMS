package com.mohran.udemy.ExceptionHandler;

public class ResourceNotFoundException extends RuntimeException {



    public ResourceNotFoundException(String message) {
     super(message);
    }
}
