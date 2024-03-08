package br.com.moreira.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.moreira.backend.models.ParagrafoModel;

@Repository
public interface ParagrafoRepository extends JpaRepository<ParagrafoModel,Integer>,JpaSpecificationExecutor<ParagrafoModel>{
    @Query(value = "select * from paragrafo where codigo_noticia = ?1 order by codigo", nativeQuery = true)
    List<ParagrafoModel> corpoNoticia(int codigo);
}
