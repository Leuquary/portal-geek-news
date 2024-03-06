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

import br.com.moreira.backend.models.AutorModel;
import br.com.moreira.backend.repositories.AutorRepository;

@RestController
@CrossOrigin(origins = "*")
public class AutorController {
    @Autowired
    AutorRepository repository;

    @GetMapping("/api/autor/{codigo}")
    public ResponseEntity<AutorModel> carregar(@PathVariable int codigo){
        Optional<AutorModel> obj = repository.findById(codigo);
        return ResponseEntity.ok(obj.get());
    }

    @SuppressWarnings("null")
    @PostMapping("/api/autor")
    public ResponseEntity<String> cadastrar(@RequestBody AutorModel obj){
        repository.save(obj);
        String msg = "Autor cadastrado com sucesso";
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/api/autor/lista")
    public ResponseEntity<List<AutorModel>> listar(){
        List<AutorModel> listagem = repository.findAll();
        return ResponseEntity.ok(listagem);
    }
}
