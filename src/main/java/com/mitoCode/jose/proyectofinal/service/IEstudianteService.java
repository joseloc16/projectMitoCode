package com.mitoCode.jose.proyectofinal.service;

import com.mitoCode.jose.proyectofinal.model.Estudiante;
import org.springframework.stereotype.Service;


public interface IEstudianteService extends ICrudService<Estudiante, Integer> {
  boolean estudianteExis(Integer id);
}
