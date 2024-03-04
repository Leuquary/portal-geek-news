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
    List<NoticiaModel> listarCategorias(int codigo);

    @Query(value = "select n.* from (select *, row_number() over(partition by codigo_categoria order by random()) as row_num from noticia) as n inner join categoria as c on n.codigo_categoria = c.codigo where n.row_num = 1 limit 6", nativeQuery=true)
    List<NoticiaModel> listarNoticias();

    @Query(value = "select * from noticia order by codigo desc limit 1", nativeQuery = true)
    Optional<NoticiaModel> ultimaPostagem();

    @Query(value = "select * from noticia where codigo_categoria = ?1 order by codigo desc limit 1", nativeQuery = true)
    Optional<NoticiaModel> postagemCategoria(int codigo);
}
