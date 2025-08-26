package org.datacoins.a41_2024399_proyecto.dominio.service;

import org.datacoins.a41_2024399_proyecto.persistence.entity.Maestro;

import java.util.List;

public interface IMaestroService {

    List<Maestro> listarMaestro();
    Maestro buscarMaestroPorId(Integer codigo);
    void guardarMaestro(Maestro maestro);
    void eliminarMaestro(Maestro maestro);

}
