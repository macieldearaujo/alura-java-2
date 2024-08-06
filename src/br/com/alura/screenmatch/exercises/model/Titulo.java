package br.com.alura.screenmatch.exercises.model;

import java.util.Date;

public class Titulo {
    private String name;
    private Date dataLancamento;
    private Integer duracao;

    public Titulo(String name, Date dataLancamento, Integer duracao) {
        this.name = name;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }
}
