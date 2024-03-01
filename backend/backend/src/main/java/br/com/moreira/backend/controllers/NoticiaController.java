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
@CrossOrigin(origins="*")
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
    
    @GetMapping("/api/listar/{codigo}")
    public ResponseEntity<List<NoticiaModel>> listarCategoria(@PathVariable int codigoCategoria){
        List<NoticiaModel> listagem = repository.listarCategoria(codigoCategoria);
        return ResponseEntity.ok(listagem);
    }
}
