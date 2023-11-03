package com.example.authcomplited.exceptions;

public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException() {
        super("Acesso invalido: email/palavra-passe não está correto.");
    }
}
