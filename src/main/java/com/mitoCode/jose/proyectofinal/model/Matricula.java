package com.mitoCode.jose.proyectofinal.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Matricula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idMatricula;

  @ManyToOne
  @JoinColumn(name = "id_estudiante",
      nullable = false)
  private Estudiante estudiante;

  @Column(nullable = false)
  private LocalDateTime fechaMatricula;//LocalDateTime.now();

  @Column(nullable = false)
  private boolean estado;

  @OneToMany(mappedBy = "matricula",
      cascade = CascadeType.ALL)
  private List<DetalleMatricula> detalleMatricula;
}
