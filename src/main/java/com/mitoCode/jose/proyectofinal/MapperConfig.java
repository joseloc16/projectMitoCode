package com.mitoCode.jose.proyectofinal;

import com.mitoCode.jose.proyectofinal.dto.EstudianteDto;
import com.mitoCode.jose.proyectofinal.model.Estudiante;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

  @Bean("estudianteMapper")
  public ModelMapper modelMapper() {
    ModelMapper mapper = new ModelMapper();
    TypeMap<Estudiante, EstudianteDto> typeMap =
        mapper.createTypeMap(Estudiante.class, EstudianteDto.class);
    typeMap.addMapping(Estudiante::getIdEstudiante, EstudianteDto::setId);
    typeMap.addMapping(Estudiante::getNombres, EstudianteDto::setNombreEstudiante);
    typeMap.addMapping(Estudiante::getApellidos, EstudianteDto::setApellidosEstudiante);
    typeMap.addMapping(Estudiante::getDni, EstudianteDto::setDniEstudiante);
    typeMap.addMapping(Estudiante::getEdad, EstudianteDto::setEdadEstudiante);
    return mapper;
  }
}
