package br.com.moreira.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.moreira.backend.models.ImagemModel;

@Repository
public interface ImagemRespository extends JpaRepository<ImagemModel,Integer>,JpaSpecificationExecutor<ImagemModel>{
    
}
