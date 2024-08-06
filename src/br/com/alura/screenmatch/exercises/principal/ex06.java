package br.com.alura.screenmatch.exercises.principal;

import br.com.alura.screenmatch.exercises.model.Veiculo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ex06 {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca("Toyota");
        veiculo.setModelo("Corolla");
        veiculo.setAnoLancamento(2018);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(veiculo);
        System.out.println(json);
    }
}
