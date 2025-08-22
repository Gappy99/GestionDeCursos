package org.datacoins.a41_2024399_proyecto.dominio.service;

import org.datacoins.a41_2024399_proyecto.persistence.crud.EstudianteCrud;
import org.datacoins.a41_2024399_proyecto.persistence.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService implements IEstudianteService{
    @Autowired
    private EstudianteCrud crud;

    @Override
    public List<Estudiante> listarEstudiante() {
        Iterable<Estudiante> estudiantes = crud.findAll();
        return (List<Estudiante>) estudiantes;
    }

    @Override
    public Estudiante buscarEstudiantePorId(Integer codigo) {
        Estudiante estudiante = crud.findById(codigo).orElse(null);
        return estudiante;
    }

    @Override
    public void guardarEstudiante(Estudiante estudiante) {
        crud.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        crud.delete(estudiante);
    }
}