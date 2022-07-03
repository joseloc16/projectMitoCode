package com.mitoCode.jose.proyectofinal.service.impl;

import com.mitoCode.jose.proyectofinal.model.Curso;
import com.mitoCode.jose.proyectofinal.repository.ICursoRepo;
import com.mitoCode.jose.proyectofinal.repository.IGenericRepository;
import com.mitoCode.jose.proyectofinal.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl extends CrudServiceImpl<Curso, Integer>
    implements ICursoService {

  @Autowired
  private ICursoRepo repo;

  @Override
  protected IGenericRepository<Curso, Integer> getRepo() {
    return repo;
  }
}
