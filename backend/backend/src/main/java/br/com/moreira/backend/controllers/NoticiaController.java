package br.com.moreira.backend.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.moreira.backend.models.NoticiaModel;
import br.com.moreira.backend.models.ParagrafoModel;
import br.com.moreira.backend.repositories.NoticiaRepository;
import br.com.moreira.backend.repositories.ParagrafoRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class NoticiaController {
    @Autowired
    NoticiaRepository repositoryNoticia;

    @Autowired
    ParagrafoRepository repositoryParagrafo;

    @GetMapping("/api/noticia/{codigo}")
    public ResponseEntity<NoticiaModel> carregar(@PathVariable int codigo){
        Optional<NoticiaModel> obj = repositoryNoticia.findById(codigo);
        return ResponseEntity.ok(obj.get());
    }

    @GetMapping("/api/noticia/corpo/{codigo}")
    public ResponseEntity<List<ParagrafoModel>> recuperarNoticia(@PathVariable int codigo){
        List<ParagrafoModel> listagem = repositoryParagrafo.recuperarNoticia(codigo);
        return ResponseEntity.ok(listagem);
    }

    @SuppressWarnings("null")
    @PostMapping("/api/noticia")
    public ResponseEntity<String> cadastrar(@RequestBody NoticiaModel obj){
        repositoryNoticia.save(obj);
        String msg = "Notícia cadastrada com sucesso";
        return ResponseEntity.ok(msg);
    }  
    
    @GetMapping("/api/noticia/lista")
    public ResponseEntity<List<NoticiaModel>> listarNoticias(){
        List<NoticiaModel> listagem = repositoryNoticia.listarNoticias();
        return ResponseEntity.ok(listagem);
    }

    @GetMapping("/api/noticia/ultima")
    public ResponseEntity<NoticiaModel> ultimaPostagem(){
        Optional<NoticiaModel> obj = repositoryNoticia.ultimaPostagem();
        return ResponseEntity.ok(obj.get());
    }

    @GetMapping("/api/noticia/categoria/lista/{codigo}")
    public ResponseEntity<List<NoticiaModel>> listarCategoria(@PathVariable int codigo){
        List<NoticiaModel> listagem = repositoryNoticia.listarCategoria(codigo);
        return ResponseEntity.ok(listagem);
    }

    @GetMapping("/api/noticia/categoria/{codigo}")
    public ResponseEntity<NoticiaModel> postagemCategoria(@PathVariable int codigo){
        Optional<NoticiaModel> obj = repositoryNoticia.postagemCategoria(codigo);
        return ResponseEntity.ok(obj.get());
    }
}
