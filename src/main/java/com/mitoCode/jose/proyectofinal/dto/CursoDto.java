package com.mitoCode.jose.proyectofinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDto {

  @Min(1)
  @Max(999)
  private Integer id;

  @NotNull
  @NotEmpty
  @Size(min = 3, max = 50)
  private String nombreCurso;

  @NotNull
  @NotEmpty
  @Size(min = 2)
  private String siglasCurso;

  @NotNull
  private Boolean estadoCurso;
}
