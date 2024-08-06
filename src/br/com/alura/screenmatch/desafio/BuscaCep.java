package br.com.alura.screenmatch.desafio;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaCep {
    public Endereco buscaEndereco(String cep) {
        try {

            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/" + cep +"/json/"))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            return new Gson().fromJson(json, Endereco.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
