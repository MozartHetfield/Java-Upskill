package com.javaupskill.class_design.exceptions;

public class TooYoungException extends InvalidAgeException {
    public TooYoungException(String message) {
        super(message);
    }
}
