package com.mitoCode.jose.proyectofinal.service.impl;

import com.mitoCode.jose.proyectofinal.model.Curso;
import com.mitoCode.jose.proyectofinal.repository.ICursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class CursoServiceImpl extends CrudServiceImpl<Curso, Integer> {

  @Autowired
  private ICursoRepo repo;


  @Override
  protected JpaRepository<Curso, Integer> getRepo() {
    return repo;
  }
}
