package com.mitoCode.jose.proyectofinal.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Curso {

  public Curso(Integer idCurso, String nombre, String siglas, Boolean estado) {
    this.idCurso = idCurso;
    this.nombre = nombre;
    this.siglas = siglas;
    this.estado = estado;
  }

  public Curso() {

  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCurso;

  @Column(nullable = false, length = 50)
  private String nombre;

  @Column(nullable = false, length = 50)
  private String siglas;

  private Boolean estado;

  @ManyToMany(mappedBy = "cursos")
  List<Estudiante> estudiantes;
}
