package org.datacoins.a41_2024399_proyecto.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Estudiantes")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoEstudiante;
    @Column
    private String nombre;
    private String apellido;
    private String correo;

}