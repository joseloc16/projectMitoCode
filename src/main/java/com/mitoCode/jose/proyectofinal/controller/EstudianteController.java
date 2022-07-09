package com.mitoCode.jose.proyectofinal.controller;

import com.mitoCode.jose.proyectofinal.dto.EstudianteDto;
import com.mitoCode.jose.proyectofinal.model.Estudiante;
import com.mitoCode.jose.proyectofinal.service.IEstudianteService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

  @Autowired
  private IEstudianteService service;

  @Autowired
  @Qualifier("estudianteMapper")
  private ModelMapper mapper;

  @GetMapping
  public ResponseEntity<List<EstudianteDto>> listaEstudiantes()
      throws Exception {
    List<EstudianteDto> estudianteList =
        service.readAll().stream()
            .map(estudiante -> mapper.map(estudiante, EstudianteDto.class))
            .collect(Collectors.toList());
    return new ResponseEntity<>(estudianteList, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<EstudianteDto> obtenerEstudiante(@PathVariable("id") Integer id)
      throws Exception {
    EstudianteDto dto = mapper.map(service.readById(id), EstudianteDto.class);
    //im0plementar ModelNotFoundException
    return new ResponseEntity<>(dto, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<EstudianteDto> registrarEstudiante(@RequestBody EstudianteDto estudianteDto)
      throws Exception {

    try {
      Estudiante estudiante = new Estudiante();
      estudiante.setNombres(estudianteDto.getNombreEstudiante());
      estudiante.setApellidos(estudianteDto.getApellidosEstudiante());
      estudiante.setEdad(estudianteDto.getEdadEstudiante());
      estudiante.setDni(estudianteDto.getDniEstudiante());

      EstudianteDto dto = mapper.map(service.register(estudiante), EstudianteDto.class);
      return new ResponseEntity<>(dto, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  @PutMapping("/{id}")
  public ResponseEntity<EstudianteDto> actualizarEstudiante(
      @PathVariable("id") Integer id, @RequestBody EstudianteDto estudianteDto)
      throws Exception {

    if (service.estudianteExis(id)) {

      Estudiante estudiante = new Estudiante();
      estudiante.setNombres(estudianteDto.getNombreEstudiante());
      estudiante.setApellidos(estudianteDto.getApellidosEstudiante());
      estudiante.setEdad(estudianteDto.getEdadEstudiante());
      estudiante.setDni(estudianteDto.getDniEstudiante());

      EstudianteDto dto = mapper.map(service.update(estudiante), EstudianteDto.class);
      return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarEstudiante(@PathVariable("id") Integer id)
      throws Exception {
    service.remove(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
