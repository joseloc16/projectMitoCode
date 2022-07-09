package com.mitoCode.jose.proyectofinal.controller;

import com.mitoCode.jose.proyectofinal.dto.CursoDto;
import com.mitoCode.jose.proyectofinal.model.Curso;
import com.mitoCode.jose.proyectofinal.service.ICursoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {

  @Autowired
  private ICursoService service;

  @Autowired
  @Qualifier("cursoMapper")
  private ModelMapper mapper;

  @GetMapping
  public ResponseEntity<List<CursoDto>> listarCursos()
      throws Exception {
    List<CursoDto> cursosDtos = service.readAll()
        .stream().map(curso -> mapper.map(curso, CursoDto.class))
        .collect(Collectors.toList());
    return new ResponseEntity<>(cursosDtos, HttpStatus.OK);
  }

  @GetMapping("/{idCurso}")
  public ResponseEntity<CursoDto> obtenerCursoPorId(@PathVariable("idCurso") Integer idCurso)
      throws Exception {
    CursoDto cursoDto = mapper.map(service.readById(idCurso), CursoDto.class);
    return new ResponseEntity<>(cursoDto, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<CursoDto> registrarCurso(@RequestBody CursoDto cursoDto)
      throws Exception {
    Curso curso = service.register(mapper.map(cursoDto, Curso.class));
    CursoDto dto = mapper.map(curso, CursoDto.class);
    return new ResponseEntity<>(dto, HttpStatus.CREATED);
  }

  @PutMapping("/{idCurso}")
  public ResponseEntity<CursoDto> actualizarCurso(
      @PathVariable("idCurso") Integer idCurso, @RequestBody CursoDto cursoDto)
      throws Exception {
    if (service.isExist(idCurso)) {
      Curso curso = service.update(mapper.map(cursoDto, Curso.class));
      CursoDto dto = mapper.map(curso, CursoDto.class);
      return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(HttpStatus.CONFLICT);
  }

  @DeleteMapping("/{idCurso}")
  public ResponseEntity<Void> eliminarCurso(@PathVariable("idCurso") Integer idCurso) throws Exception {
    service.remove(idCurso);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
