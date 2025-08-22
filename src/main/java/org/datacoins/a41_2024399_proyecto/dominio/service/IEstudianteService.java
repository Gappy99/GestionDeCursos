package org.datacoins.a41_2024399_proyecto.dominio.service;

import org.datacoins.a41_2024399_proyecto.persistence.entity.Estudiante;

import java.util.List;

public interface IEstudianteService {
    //firmas vistas en clase
    List<Estudiante> listarEstudiante();
    Estudiante buscarEstudiantePorId(Integer codigo);
    void guardarEstudiante(Estudiante estudiante);
    void eliminarEstudiante(Estudiante estudiante);
}
