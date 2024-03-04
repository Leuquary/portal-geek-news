package br.com.moreira.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.moreira.backend.models.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel,Integer>,JpaSpecificationExecutor<CategoriaModel>{
    @Query(value="select * from categoria order by codigo asc",nativeQuery=true)
    List<CategoriaModel> listar();
}
