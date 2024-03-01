package br.com.moreira.backend.models;

import java.util.List;

public class Noticia {
    private int id;
    private String titulo;
    private String subtitulo;
    private List<Paragrafo> paragrafos;
    private String imagem;
    private String data;
    private Categoria categoria;

    public Noticia(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public List<Paragrafo> getParagrafos() {
        return paragrafos;
    }

    public void setParagrafos(List<Paragrafo> paragrafos) {
        this.paragrafos = paragrafos;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
}

