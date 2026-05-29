package com.clubnautico.excepciones;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Captura el error 404 (No encontrado)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetalles> manejarResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetalles error = new ErrorDetalles(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Captura el error 400 (Datos incorrectos)
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDetalles> manejarBadRequest(BadRequestException ex, WebRequest request) {
        ErrorDetalles error = new ErrorDetalles(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Captura el error 409 (Duplicados)
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorDetalles> manejarResourceAlreadyExists(ResourceAlreadyExistsException ex, WebRequest request) {
        ErrorDetalles error = new ErrorDetalles(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    // Captura cualquier otro error interno del servidor (Error 500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetalles> manejarErroresGlobales(Exception ex, WebRequest request) {
        ErrorDetalles error = new ErrorDetalles(LocalDateTime.now(), "Error interno en el servidor", request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}