package br.com.moreira.backend.models;

public class Paragrafo {
    private int id;
    private String corpoParagrafo;
    private String imagem;

    public Paragrafo(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorpoParagrafo() {
        return corpoParagrafo;
    }

    public void setCorpoParagrafo(String corpoParagrafo) {
        this.corpoParagrafo = corpoParagrafo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    
}
