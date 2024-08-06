package br.com.alura.screenmatch.exercises.principal;

import java.io.FileWriter;
import java.io.IOException;

public class ex04 {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("arquivo.txt");
            fileWriter.write("Conteúdo a ser gravado no arquivo.");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
