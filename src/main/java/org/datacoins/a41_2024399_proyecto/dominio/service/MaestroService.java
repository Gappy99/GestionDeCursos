package org.datacoins.a41_2024399_proyecto.dominio.service;

import org.datacoins.a41_2024399_proyecto.persistence.crud.MaestroCrud;
import org.datacoins.a41_2024399_proyecto.persistence.entity.Maestro;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MaestroService implements IMaestroService{
    @Autowired
    private MaestroCrud crud;

    @Override
    public List<Maestro> listarMaestro() {
        Iterable<Maestro> maestros = crud.findAll();
        return (List<Maestro>) maestros;
    }

    @Override
    public Maestro buscarMaestroPorId(Integer codigo) {
        Maestro maestro = crud.findById(codigo).orElse(null);
        return maestro;
    }

    @Override
    public void guardarMaestro(Maestro maestro) {
        crud.save(maestro);
    }

    @Override
    public void eliminarMaestro(Maestro maestro) {
        crud.delete(maestro);
    }
}
