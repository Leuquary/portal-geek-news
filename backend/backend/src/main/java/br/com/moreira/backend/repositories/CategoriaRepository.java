package br.com.moreira.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.moreira.backend.models.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel,Integer>,JpaSpecificationExecutor<CategoriaModel>{
    
}
