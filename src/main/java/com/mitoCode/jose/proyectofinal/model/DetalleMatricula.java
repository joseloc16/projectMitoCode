package com.mitoCode.jose.proyectofinal.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DetalleMatricula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idDetalleMatricula;

  @ManyToOne
  @JoinColumn(name = "id_matricula", nullable = false,
      foreignKey = @ForeignKey(name = "fk_detalle_matricula"))
  private Matricula matricula;

  @ManyToOne
  @JoinColumn(name = "id_curso ", nullable = false,
      foreignKey = @ForeignKey(name = "fk_id_curso"))
  private Curso curso;

  @Column(length = 50, nullable = false)
  private String aula;
}
