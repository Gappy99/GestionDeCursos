package org.datacoins.a41_2024399_proyecto.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.datacoins.a41_2024399_proyecto.dominio.service.IEstudianteService;
import org.datacoins.a41_2024399_proyecto.persistence.entity.Estudiante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class IndexController {
    @Autowired
    IEstudianteService estudianteService;
    private List<Estudiante> estudiantes;
    private Estudiante estudianteSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @PostConstruct
    public void init(){ cargarDatos (); }

    public void cargarDatos(){
        this.estudiantes = this.estudianteService.listarEstudiante();
        this.estudiantes.forEach(estudiante -> logger.info(estudiante.toString()));
    }

    public void agregarEstudiante(){
        this.estudianteSeleccionado = new Estudiante();
    }

}
