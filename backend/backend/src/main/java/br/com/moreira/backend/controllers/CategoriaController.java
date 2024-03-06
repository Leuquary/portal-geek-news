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

import br.com.moreira.backend.models.CategoriaModel;
import br.com.moreira.backend.repositories.CategoriaRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200, http://localhost:8080/")
public class CategoriaController {
    @Autowired
    CategoriaRepository repository;

    @GetMapping("/api/categoria/{codigo}")
    public ResponseEntity<CategoriaModel> carregar(@PathVariable int codigo){
        Optional<CategoriaModel> obj = repository.findById(codigo);
        return ResponseEntity.ok(obj.get());
    }

    @SuppressWarnings("null")
    @PostMapping("/api/categoria")
    public ResponseEntity<String> cadastrar(@RequestBody CategoriaModel obj){
        repository.save(obj);
        String msg = "Categoria cadastrada com sucesso";
        return ResponseEntity.ok(msg);
    } 
    
    @GetMapping("/api/categoria/lista")
    public ResponseEntity<List<CategoriaModel>> listar(){
        List<CategoriaModel> listagem = repository.listar();
        return ResponseEntity.ok(listagem);
    }
}
