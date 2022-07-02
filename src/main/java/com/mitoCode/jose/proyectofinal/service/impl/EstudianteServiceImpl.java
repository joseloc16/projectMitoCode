package com.mitoCode.jose.proyectofinal.service.impl;

import com.mitoCode.jose.proyectofinal.model.Estudiante;
import com.mitoCode.jose.proyectofinal.repository.IEstudianteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class EstudianteServiceImpl extends CrudServiceImpl<Estudiante, Integer> {

  @Autowired
  private IEstudianteRepo repo;

  @Override
  protected JpaRepository<Estudiante, Integer> getRepo() {
    return repo;
  }
}
