package br.com.moreira.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.moreira.backend.models.AutorModel;

@Repository
public interface AutorRepository extends JpaRepository<AutorModel,Integer>,JpaSpecificationExecutor<AutorModel>{
    
}
