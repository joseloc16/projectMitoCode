package com.mitoCode.jose.proyectofinal.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Estudiante {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idEstudiante;

  @Column(nullable = false, length = 50)
  private String nombres;

  @Column(nullable = false, length = 50)
  private String apellidos;

  @Column(nullable = false, length = 8)
  private String dni;

  private double edad;

  @ManyToMany
  @JoinTable(
      name = "cursos_alumno",
      joinColumns = @JoinColumn(name = "id_estudiante"),
      inverseJoinColumns = @JoinColumn(name = "id_curso"))
  Set<Curso> cursos;
}
