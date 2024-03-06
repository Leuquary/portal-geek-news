package br.com.moreira.backend.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="paragrafo")
public class ParagrafoModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    private String tituloParagrafo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String corpoParagrafo;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "codigo_imagem", referencedColumnName = "codigo", nullable = true)
    private ImagemModel imagem;

    public ParagrafoModel(){

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTituloParagrafo() {
        return tituloParagrafo;
    }

    public void setTituloParagrafo(String tituloParagrafo) {
        this.tituloParagrafo = tituloParagrafo;
    }

    public String getCorpoParagrafo() {
        return corpoParagrafo;
    }

    public void setCorpoParagrafo(String corpoParagrafo) {
        this.corpoParagrafo = corpoParagrafo;
    }

    public ImagemModel getImagem() {
        return imagem;
    }

    public void setImagem(ImagemModel imagem) {
        this.imagem = imagem;
    }

    
    
}
