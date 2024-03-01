package br.com.moreira.backend.models;

public class Categoria {
    private int id;
    private String nome;
    private String corCabecalho;
    private String corPesquisa;

    public Categoria(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCorCabecalho() {
        return corCabecalho;
    }

    public void setCorCabecalho(String corCabecalho) {
        this.corCabecalho = corCabecalho;
    }

    public String getCorPesquisa() {
        return corPesquisa;
    }

    public void setCorPesquisa(String corPesquisa) {
        this.corPesquisa = corPesquisa;
    } 
}
