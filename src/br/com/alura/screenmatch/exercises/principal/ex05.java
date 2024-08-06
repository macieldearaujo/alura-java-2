package br.com.alura.screenmatch.exercises.principal;

import br.com.alura.screenmatch.exercises.model.Titulo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

public class ex05 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        Titulo titulo = new Titulo("Matrix", new Date(), 120);
        String json = gson.toJson(titulo);
        System.out.println(json);
    }
}
