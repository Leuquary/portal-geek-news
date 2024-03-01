package br.com.moreira.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="paragrafo")
public class ParagrafoModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String tituloParagrafo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String corpoParagrafo;

    private String imagem;

    public ParagrafoModel(){

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

    public String getTituloParagrafo() {
        return tituloParagrafo;
    }

    public void setTituloParagrafo(String tituloParagrafo) {
        this.tituloParagrafo = tituloParagrafo;
    }

    
}
