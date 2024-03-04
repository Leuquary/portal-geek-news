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
import br.com.moreira.backend.repositories.NoticiaRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class NoticiaController {
    @Autowired
    NoticiaRepository repository;

    @GetMapping("/api/noticia/{codigo}")
    public ResponseEntity<NoticiaModel> carregar(@PathVariable int codigo){
        Optional<NoticiaModel> obj = repository.findById(codigo);
        return ResponseEntity.ok(obj.get());
    }

    @SuppressWarnings("null")
    @PostMapping("/api/noticia")
    public ResponseEntity<String> cadastrar(@RequestBody NoticiaModel obj){
        repository.save(obj);
        String msg = "Notícia cadastrada com sucesso";
        return ResponseEntity.ok(msg);
    }  
    
    @GetMapping("/api/noticia/lista")
    public ResponseEntity<List<NoticiaModel>> listarNoticias(){
        List<NoticiaModel> listagem = repository.listarNoticias();
        return ResponseEntity.ok(listagem);
    }

    @GetMapping("/api/noticia/ultima")
    public ResponseEntity<NoticiaModel> ultimaPostagem(){
        Optional<NoticiaModel> obj = repository.ultimaPostagem();
        return ResponseEntity.ok(obj.get());
    }

    @GetMapping("/api/noticia/categoria/lista/{codigo}")
    public ResponseEntity<List<NoticiaModel>> listarCategorias(@PathVariable int codigo){
        List<NoticiaModel> listagem = repository.listarCategorias(codigo);
        return ResponseEntity.ok(listagem);
    }

    @GetMapping("/api/noticia/categoria/{codigo}")
    public ResponseEntity<NoticiaModel> postagemCategoria(@PathVariable int codigo){
        Optional<NoticiaModel> obj = repository.postagemCategoria(codigo);
        return ResponseEntity.ok(obj.get());
    }
}
