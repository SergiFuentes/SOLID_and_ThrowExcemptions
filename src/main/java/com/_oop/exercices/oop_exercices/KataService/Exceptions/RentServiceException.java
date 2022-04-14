package com._oop.exercices.oop_exercices.KataService.Exceptions;

public class RentServiceException extends RuntimeException{
    private String code;
    public RentServiceException(String message, String code) {
        super(message);
        this.code= code;
    }

    public String getCode() {
        return code;
    }
}
