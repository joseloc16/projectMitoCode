package com.mitoCode.jose.proyectofinal.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Curso {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCurso;

  @Column(nullable = false, length = 50)
  private String nombre;

  @Column(nullable = false, length = 50)
  private String siglas;

  private boolean estado;

  @ManyToMany(mappedBy = "cursos")
  Set<Estudiante> estudiantes;
}
