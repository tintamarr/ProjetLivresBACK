package com.takima.backskeleton.exceptions;

public class ServiceException extends Exception {
    public ServiceException(String errorMessage) {
        super(errorMessage);
    }
}