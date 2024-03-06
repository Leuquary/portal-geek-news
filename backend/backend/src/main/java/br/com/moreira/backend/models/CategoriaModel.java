package br.com.moreira.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="categoria")
public class CategoriaModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    private String nome;
    private String corCabecalho;
    private String corPesquisa;
    private String corLogo;

    public CategoriaModel(){

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getCorLogo() {
        return corLogo;
    }

    public void setCorLogo(String corLogo) {
        this.corLogo = corLogo;
    } 

    
}
