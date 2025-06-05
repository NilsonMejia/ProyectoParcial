package edu.sv.catolica.ProyectoParcial.payload;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BibliotecaException.class)
    public ResponseEntity<MessageResponse> handleBibliotecaException(BibliotecaException ex) {
        return new ResponseEntity<>(
                new MessageResponse("Error de Biblioteca", ex.getMessage()),
                HttpStatus.BAD_REQUEST // o INTERNAL_SERVER_ERROR si aplica
        );
    }
}