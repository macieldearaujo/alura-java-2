package br.com.alura.screenmatch.exception;

public class ErroConversaoAnoException extends RuntimeException {
    private String messagem;

    public ErroConversaoAnoException(String messagem) {
        this.messagem = messagem;
    }

    @Override
    public String getMessage() {
        return this.messagem;
    }
}
