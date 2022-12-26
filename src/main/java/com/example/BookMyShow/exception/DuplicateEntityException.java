package com.example.BookMyShow.exception;

public class DuplicateEntityException extends RuntimeException{

    private final String message;

    public DuplicateEntityException(String message) {
        super(message);
        this.message = message;
    }
}
//if i am trying to add something and
//that entity already exists
