package br.com.alura.screenmatch.desafio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GravaArquivo {
    public void geraArquivoJson(Endereco endereco) {
        try {
            FileWriter fileWriter = new FileWriter(endereco.cep() + ".txt");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            fileWriter.write(gson.toJson(endereco));
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
