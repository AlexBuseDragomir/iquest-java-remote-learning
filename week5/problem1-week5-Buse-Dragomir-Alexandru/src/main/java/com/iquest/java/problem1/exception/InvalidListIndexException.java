package com.iquest.java.problem1.exception;

public class InvalidListIndexException extends RuntimeException {

    public InvalidListIndexException(String errorMessage) {
        super(errorMessage);
    }
}
