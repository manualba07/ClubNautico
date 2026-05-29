package com.clubnautico.excepciones;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String mensaje) {
        super(mensaje);
    }
}