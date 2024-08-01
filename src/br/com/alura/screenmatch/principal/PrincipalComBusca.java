package br.com.alura.screenmatch.principal;

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
        System.out.println(tituloDigitadoFormatado);

        String endereco = "https://www.omdbapi.com/?t=" + tituloDigitadoFormatado + "&apikey=39309093";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

    }
}
