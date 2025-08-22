-- drop database if exists kinvana_db;
create database escuela_db;
use escuela_db;
 
create table Estudiantes(
	codigoEstudiante integer auto_increment,
    nombre varchar (64),
    apellido varchar (64),
    correo varchar (128),
    constraint pk_estudiante primary key (codigoEstudiante)
);

insert into Estudiantes (nombre, apellido, correo)
values
('Carlos', 'Ramírez', 'carlos.ramirez@example.com'),
('Ana', 'González', 'ana.gonzalez@example.com'),
('Luis', 'Mendoza', 'luis.mendoza@example.com');

select * from Estudiantes;