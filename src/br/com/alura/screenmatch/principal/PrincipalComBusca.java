package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.exception.ErroConversaoAnoException;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.FilmeOmdb;
import br.com.alura.screenmatch.modelos.Titulo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um filme para busca:");
        String tituloDigitado = sc.nextLine();
        String tituloDigitadoFormatado = tituloDigitado.replace(" ", "+");

        String endereco = "https://www.omdbapi.com/?t=" + tituloDigitadoFormatado + "&apikey=39309093";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        FilmeOmdb filmeOmdb = gson.fromJson(json, FilmeOmdb.class);
        System.out.println(filmeOmdb);

        try {
            Titulo meuTitulo = new Titulo(filmeOmdb);
            System.out.println("Título convertido!");
            System.out.println(meuTitulo);
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter: " + e.getMessage());
        } catch(ErroConversaoAnoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("O programa finalizou corretamente!");
//        Titulo titulo = new Titulo(filmeOmdb);
//        System.out.println(titulo);

    }
}
