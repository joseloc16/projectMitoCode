package com.mitoCode.jose.proyectofinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDto {

  private Integer id;
  private String nombreCurso;
  private String siglasCurso;
  private Boolean estadoCurso;
}
