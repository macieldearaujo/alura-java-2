package br.com.alura.screenmatch.desafio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um cep");
        String cep = sc.nextLine();

        BuscaCep buscaCep = new BuscaCep();
        Endereco endereco = buscaCep.buscaEndereco(cep);

        System.out.println(endereco);
    }
}
