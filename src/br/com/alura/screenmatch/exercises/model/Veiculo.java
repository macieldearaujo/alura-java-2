package br.com.alura.screenmatch.exercises.model;

public class Veiculo {
    private String modelo;
    private String marca;
    private Integer anoLancamento;

    public Veiculo() {
    }

    public Veiculo(String modelo, String marca, Integer anoLancamento) {
        this.modelo = modelo;
        this.marca = marca;
        this.anoLancamento = anoLancamento;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
