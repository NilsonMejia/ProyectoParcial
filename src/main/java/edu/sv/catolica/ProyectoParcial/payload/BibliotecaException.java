package edu.sv.catolica.ProyectoParcial.payload;

public class BibliotecaException extends RuntimeException {
    public BibliotecaException(String message) {
        super(message);
    }

    public BibliotecaException(String message, Throwable cause) {
        super(message, cause);
    }
}
