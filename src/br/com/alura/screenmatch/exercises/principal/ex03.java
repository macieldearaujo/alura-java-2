package br.com.alura.screenmatch.exercises.principal;

import br.com.alura.screenmatch.exception.ErroConsultaGithub;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um usuário no GitHub para buscar");
        String user = sc.nextLine();
        try {
            String endereco = "https://api.github.com/users/" + user;
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 404) {
                throw new ErroConsultaGithub("Usuário não encontrado no GitHub");
            }

            String json = response.body();
            System.out.println(json);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ErroConsultaGithub e) {
            throw new ErroConsultaGithub("Oops! Houve algum erro na API do GitHub");
        }

    }
}
