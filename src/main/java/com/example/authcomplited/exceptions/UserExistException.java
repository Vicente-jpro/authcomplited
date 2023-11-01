package com.example.authcomplited.exceptions;

public class UserExistException extends RuntimeException {
    public UserExistException(String elemento) {
        super(elemento);
    }
}
