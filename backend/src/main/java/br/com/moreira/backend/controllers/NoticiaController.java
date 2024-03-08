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
@CrossOrigin(origins="*")
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

    @SuppressWarnings("null")
    @PostMapping("/api/noticia")
    public ResponseEntity<String> cadastrar(@RequestBody NoticiaModel obj){
        repositoryNoticia.save(obj);
        String msg = "Notícia cadastrada com sucesso";
        return ResponseEntity.ok(msg);
    }  

    @GetMapping("/api/noticia/corpo/{codigo}")
    public ResponseEntity<List<ParagrafoModel>> corpoNoticia(@PathVariable int codigo){
        List<ParagrafoModel> listagem = repositoryParagrafo.corpoNoticia(codigo);
        return ResponseEntity.ok(listagem);
    }
    
    @GetMapping("/api/noticia/lista")
    public ResponseEntity<List<NoticiaModel>> listarNoticiasPrincipal(){
        List<NoticiaModel> listagem = repositoryNoticia.listarNoticiasPrincipal();
        return ResponseEntity.ok(listagem);
    }

    @GetMapping("/api/noticia/ultima")
    public ResponseEntity<NoticiaModel> ultimaPostagemPrincipal(){
        Optional<NoticiaModel> obj = repositoryNoticia.ultimaPostagemPrincipal();
        return ResponseEntity.ok(obj.get());
    }

    @GetMapping("/api/noticia/categoria/lista/{codigo}")
    public ResponseEntity<List<NoticiaModel>> listarNoticiasCategoria(@PathVariable int codigo){
        List<NoticiaModel> listagem = repositoryNoticia.listarNoticiasCategoria(codigo);
        return ResponseEntity.ok(listagem);
    }

    @GetMapping("/api/noticia/categoria/{codigo}")
    public ResponseEntity<NoticiaModel> ultimaPostagemCategoria(@PathVariable int codigo){
        Optional<NoticiaModel> obj = repositoryNoticia.ultimaPostagemCategoria(codigo);
        return ResponseEntity.ok(obj.get());
    }
}
