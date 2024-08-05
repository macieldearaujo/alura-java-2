package br.com.alura.screenmatch.exercises.exceptions;

public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException(String message) {
        super(message);
    }
}
