package br.com.moreira.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.moreira.backend.models.NoticiaModel;

@Repository
public interface NoticiaRepository extends JpaRepository<NoticiaModel,Integer>,JpaSpecificationExecutor<NoticiaModel>{

    @Query(value = "select * from noticia where codigo_categoria = ?1 limit 3", nativeQuery = true)
    List<NoticiaModel> listarNoticiasCategoria(int codigo);

    @Query(value = """
            SELECT n.* FROM 
            (SELECT *, ROW_NUMBER() OVER(PARTITION BY codigo_categoria ORDER BY RANDOM()) AS row_num FROM noticia) 
            AS n 
            INNER JOIN categoria AS c ON n.codigo_categoria = c.codigo 
            WHERE n.row_num = 1 
            LIMIT 6;
            """, nativeQuery=true)
    List<NoticiaModel> listarNoticiasPrincipal();

    @Query(value = "select * from noticia order by codigo desc limit 1", nativeQuery = true)
    Optional<NoticiaModel> ultimaPostagemPrincipal();

    @Query(value = "select * from noticia where codigo_categoria = ?1 order by codigo desc limit 1", nativeQuery = true)
    Optional<NoticiaModel> ultimaPostagemCategoria(int codigo);
}
