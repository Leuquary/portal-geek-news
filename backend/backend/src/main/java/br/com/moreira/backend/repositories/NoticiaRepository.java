package br.com.moreira.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.moreira.backend.models.NoticiaModel;

@Repository
public interface NoticiaRepository extends JpaRepository<NoticiaModel,Integer>,JpaSpecificationExecutor<NoticiaModel>{
    @Query(value = "select * from noticia where codigo_categoria = ?1", nativeQuery = true)
    List<NoticiaModel> listarCategoria(int codigoCategoria);
}
