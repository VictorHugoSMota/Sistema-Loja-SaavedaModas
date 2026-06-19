package com.saavedramodas.loja.exception;

public class ResourceNotFoundException
        extends RuntimeException {

    public ResourceNotFoundException(
            String mensagem) {

        super(mensagem);
    }
}