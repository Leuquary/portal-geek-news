package br.com.moreira.backend.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="noticia")
public class NoticiaModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    private String titulo;
    private String subtitulo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "codigo_noticia", referencedColumnName = "codigo", nullable = false)
    private List<ParagrafoModel> paragrafos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codigo_imagem", referencedColumnName = "codigo", nullable = false)
    private ImagemModel imagem;
    
    private String data;
    private String hora;

    @ManyToOne
    @JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo", nullable = false)
    private CategoriaModel categoria;

    @ManyToOne
    @JoinColumn(name = "codigo_autor", referencedColumnName = "codigo", nullable = false)
    private AutorModel autor;

    public NoticiaModel(){

    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public List<ParagrafoModel> getParagrafos() {
        return paragrafos;
    }

    public void setParagrafos(List<ParagrafoModel> paragrafos) {
        this.paragrafos = paragrafos;
    }

    public ImagemModel getImagem() {
        return imagem;
    }

    public void setImagem(ImagemModel imagem) {
        this.imagem = imagem;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public AutorModel getAutor() {
        return autor;
    }

    public void setAutor(AutorModel autor) {
        this.autor = autor;
    }

    
}

