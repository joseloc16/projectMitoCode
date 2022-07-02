package com.mitoCode.jose.proyectofinal.repository;

import com.mitoCode.jose.proyectofinal.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstudianteRepo extends JpaRepository<Estudiante, Integer> {
}
