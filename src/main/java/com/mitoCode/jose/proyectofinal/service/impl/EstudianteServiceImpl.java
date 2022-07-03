package com.mitoCode.jose.proyectofinal.service.impl;

import com.mitoCode.jose.proyectofinal.model.Estudiante;
import com.mitoCode.jose.proyectofinal.repository.IEstudianteRepo;
import com.mitoCode.jose.proyectofinal.repository.IGenericRepository;
import com.mitoCode.jose.proyectofinal.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServiceImpl extends CrudServiceImpl<Estudiante, Integer>
    implements IEstudianteService {

  @Autowired
  private IEstudianteRepo repo;

  @Override
  protected IGenericRepository<Estudiante, Integer> getRepo() {
    return repo;
  }
}
