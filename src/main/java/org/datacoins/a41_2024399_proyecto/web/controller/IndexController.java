package org.datacoins.a41_2024399_proyecto.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.datacoins.a41_2024399_proyecto.dominio.service.IEstudianteService;
import org.datacoins.a41_2024399_proyecto.persistence.entity.Estudiante;
import org.primefaces.PrimeFaces;
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

    public void guardarEstudiante(){
        logger.info("Estudiante a guardar" + this.estudianteSeleccionado);

        if (this.estudianteSeleccionado.getCodigoEstudiante() == null){
            this.estudianteService.guardarEstudiante(this.estudianteSeleccionado);
            this.estudiantes.add(this.estudianteSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estudiante agregado"));
        }
        else {
            this.estudianteService.guardarEstudiante(this.estudianteSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estudiante Actualizado"));
        }

        //ocultar
        PrimeFaces.current().executeScript("PF('VentanaModalEstudiante').hide()");

        //actualizar
        PrimeFaces.current().ajax().update("formulario-estudiantes:mensaje-emergente",
                                    "formulario-estudiantes:tabla-estudiantes");

        //resetear
        this.estudianteSeleccionado = null;

    }

    public void eliminarEstudiante(){
        //mostrar en al consola
        logger.info("Estudiante a eliminar: "+this.estudianteSeleccionado);
        //llamar a nuestro servicio
        this.estudianteService.eliminarEstudiante(estudianteSeleccionado);
        //eliminar
        this.estudiantes.remove(estudianteSeleccionado);
        //limpiar
        this.estudianteSeleccionado=null;
        //enviar mensaje
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estudiante eliminado"));
        //actualizar
        PrimeFaces.current().ajax().update("formulario-estudiantes:mensaje_emergente",
                "formulario-estudiantes:tabla-estudiantes");
    }

}
