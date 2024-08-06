package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.exception.ErroConversaoAnoException;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.FilmeOmdb;
import br.com.alura.screenmatch.modelos.Titulo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        String busca = "";

        List<FilmeOmdb> filmes = new ArrayList<>();
        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um filme para busca:");
            busca = sc.nextLine();

            if(busca.equalsIgnoreCase("sair")) {
                break;
            }

            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=39309093";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();


            FilmeOmdb filmeOmdb = gson.fromJson(json, FilmeOmdb.class);
            System.out.println(filmeOmdb);
            filmes.add(filmeOmdb);

            try {
                Titulo meuTitulo = new Titulo(filmeOmdb);
                System.out.println("Título convertido!");
                System.out.println(meuTitulo);

                FileWriter file = new FileWriter("filme.txt");
                file.write(meuTitulo.toString());
                file.close();
            } catch (NumberFormatException e) {
                System.out.println("Erro ao converter: " + e.getMessage());
            } catch (ErroConversaoAnoException e) {
                System.out.println(e.getMessage());
            }
        }

        FileWriter fileWriter = new FileWriter("filmes.json");
        String jsonFilmes = gson.toJson(filmes);
        fileWriter.write(jsonFilmes);
        fileWriter.close();

        System.out.println("O programa finalizou corretamente!");
//        Titulo titulo = new Titulo(filmeOmdb);
//        System.out.println(titulo);

    }
}
