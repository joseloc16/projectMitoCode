package com.mitoCode.jose.proyectofinal;

import com.mitoCode.jose.proyectofinal.dto.CursoDto;
import com.mitoCode.jose.proyectofinal.dto.EstudianteDto;
import com.mitoCode.jose.proyectofinal.model.Curso;
import com.mitoCode.jose.proyectofinal.model.Estudiante;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

  @Bean("estudianteMapper")
  public ModelMapper modelMapperEstudiante() {
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

  @Bean("cursoMapper")
  public ModelMapper modelMapperCurso() {
    ModelMapper mapper = new ModelMapper();
    TypeMap<Curso, CursoDto> typeMap =
        mapper.createTypeMap(Curso.class, CursoDto.class);
    typeMap.addMapping(Curso::getIdCurso, CursoDto::setId);
    typeMap.addMapping(Curso::getNombre, CursoDto::setNombreCurso);
    typeMap.addMapping(Curso::getSiglas, CursoDto::setSiglasCurso);
    typeMap.addMapping(Curso::getEstado, CursoDto::setEstadoCurso);
    return mapper;
  }
}
