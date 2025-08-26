package org.datacoins.a41_2024399_proyecto.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Maestros")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Maestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "codigoMaestro")
    private Integer codigoMaestro;
    private String nombre;
    private String apellido;
    private String correo;
    private String materia;
}