package com.mitoCode.jose.proyectofinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDto {

  @Min(1)
  @Max(999)
  private Integer id;

  @NotNull
  @NotEmpty
  @Size(min = 3, max = 50)
  private String nombreEstudiante;

  @NotNull
  @NotEmpty
  @Size(min = 3, max = 50)
  private String apellidosEstudiante;

  @NotNull
  @NotEmpty
  @Min(10000000)
  @Max(99999999)
  private String dniEstudiante;

  @NotNull
  @Min(1)
  private double edadEstudiante;

}
