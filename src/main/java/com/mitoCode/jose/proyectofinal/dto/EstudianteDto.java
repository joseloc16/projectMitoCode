package com.mitoCode.jose.proyectofinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDto {

  private Integer id;
  private String nombreEstudiante;
  private String apellidosEstudiante;
  private String dniEstudiante;
  private double edadEstudiante;

}
