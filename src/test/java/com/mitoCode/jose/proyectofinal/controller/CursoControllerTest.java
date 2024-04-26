package com.mitoCode.jose.proyectofinal.controller;

import com.mitoCode.jose.proyectofinal.model.Curso;
import com.mitoCode.jose.proyectofinal.service.ICursoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(CursoController.class)
class CursoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ICursoService cursoService;
    @MockBean(name = "cursoMapper")
    private ModelMapper mapper;

    Curso curso1 = new Curso(1, "fisica", "fi", true);
    Curso curso2 = new Curso(2, "comunicacion", "co", true);
    Curso curso3 = new Curso(3, "ingles", "in", true);

    @Test
    void readAllTest() throws Exception {
        List<Curso> cursos = Arrays.asList(curso1, curso2, curso3);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/cursos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}