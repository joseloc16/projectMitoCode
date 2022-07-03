package com.mitoCode.jose.proyectofinal.controller;

import com.mitoCode.jose.proyectofinal.model.Estudiante;
import com.mitoCode.jose.proyectofinal.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

  @Autowired
  private IEstudianteService service;

  @GetMapping
  public ResponseEntity<List<Estudiante>> listaEstudiantes() throws Exception {
    List<Estudiante> estudianteList =
        service.readAll().stream()
            .collect(Collectors.toList());
    return new ResponseEntity<>(estudianteList, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Estudiante> obtenerEstudiante(@PathVariable("id") Integer id)
      throws Exception {
    Estudiante estudiante = service.readById(id);
    //im0plementar ModelNotFoundException
    return new ResponseEntity<>(estudiante, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Estudiante> registrarEstudiante(@RequestBody Estudiante estudiante) throws Exception {
    Estudiante estudiante1 = service.register(estudiante);
    return new ResponseEntity<>(estudiante1, HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<Estudiante> actualizarEstudiante(@RequestBody Estudiante estudiante) throws Exception {
    Estudiante estudiante1 = service.update(estudiante);
    return new ResponseEntity<>(estudiante1, HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarEstudiante(@PathVariable("id") Integer id) throws Exception {
    service.remove(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
