package org.datacoins.a41_2024399_proyecto;

import org.datacoins.a41_2024399_proyecto.dominio.service.IEstudianteService;
import org.datacoins.a41_2024399_proyecto.dominio.service.IMaestroService;
import org.datacoins.a41_2024399_proyecto.persistence.entity.Estudiante;
import org.slf4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class A412024399ProyectoApplication implements CommandLineRunner {

	//inyeccion de dependencia
	@Autowired
	private IEstudianteService estudianteService;
	private IMaestroService maestroService;
	//crear nuestro objeto (herramienta) logger para interactuar con al consola
	private static final Logger logger = LoggerFactory.getLogger(A412024399ProyectoApplication.class);
	//crear un objeto String para saltos de linea
	String sl = System.lineSeparator(); //salto de linea


	public static void main(String[] args) {
		logger.info(" AQUI INICIA NUESTRA APLICACION ");
		SpringApplication.run(A412024399ProyectoApplication.class, args);
		logger.info(" AQUI TERMINO NUESTRA APLICACIION ");
	}

	@Override
	public void run(String... args) throws Exception {
		a41_2024399_proyecto();
	}

	private void a41_2024399_proyecto() {
		logger.info("+++++++++++Registro de Estudiantes de un Curso++++++++");
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir) {
			var opcion = mostarMenu(consola);
			salir = ejecutarOpciones(consola, opcion);
			logger.info(sl);
		}
	}

	private int mostarMenu(Scanner consola) {
		logger.info("""
				\n ***Aplicacion***
				1. Listar todos los estudiantes.
				2. Buscar estudiante por codigo
				3. Agregar nuevo Estudiante.
				4. Modificar Estudiante.
				5. Eliminar Estudiante.
				6. Crud Maestro.
				Elija una opcion; \s""");
		var opcion = Integer.parseInt(consola.nextLine());
		return opcion;
	}

	private boolean ejecutarOpciones(Scanner consola, int opcion) {
		var salir = false;
		switch (opcion) {
			case 1 -> {
				logger.info(sl + "***Listado de todos los Clientes***" + sl);
				List<Estudiante> estudiante = estudianteService.listarEstudiante();
				estudiante.forEach(estudiante1 -> logger.info(estudiante.toString() + sl));
			}
			case 2 -> {
				logger.info(sl + "*** Buscar Cliente por su codigo ***" + sl);
				var codigo = Integer.parseInt(consola.nextLine());
				Estudiante estudiante = estudianteService.buscarEstudiantePorId(codigo);
				if (estudiante != null) {
					logger.info("estudiante encontrado:" + sl + estudiante + sl);
				}
			}
			case 3 -> {
				logger.info(sl + "***agregar nuevo estudiantes***" + sl);
				logger.info("escriba el nombre: ");
				var nombre = consola.nextLine();
				logger.info("escriba el apellido: ");
				var apellido = consola.nextLine();
				logger.info("escriba el correo: ");
				var correo = consola.nextLine();
				var estudiante = new Estudiante();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setCorreo(correo);
				estudianteService.guardarEstudiante(estudiante);
				logger.info("Estudiante agregado: " + sl + estudiante + sl);
			}

			case 4 -> {
				logger.info(sl+"*** Modificar Estudiante ***"+sl);
				logger.info("escriba el estudiante que quiere modificar: ");
				var codigo = Integer.parseInt(consola.nextLine());
				Estudiante estudiante = estudianteService.buscarEstudiantePorId(codigo);
				if (estudiante != null){
					logger.info("Ingrese el nombre: ");
					var nombre = consola.nextLine();
					logger.info("Ingrese el apellido: ");
					var apellido = consola.nextLine();
					logger.info("Ingrese el correo: ");
					var correo = consola.nextLine();
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setCorreo(correo);
					estudianteService.guardarEstudiante(estudiante);
					logger.info("Estudiante Modificado: "+sl + estudiante +sl);
				}else{
					logger.info("Estudiante NO encontrado: "+sl+estudiante+sl);
				}
			}

			case 5 -> {
				logger.info(sl+"*** Eliminar Estudiante ***"+sl);
				logger.info("Ingrese el codigo de estudiante a eliminar");
				var codigo = Integer.parseInt(consola.nextLine());
				var estudiante = estudianteService.buscarEstudiantePorId(codigo);
				if (estudiante != null){
					estudianteService.eliminarEstudiante(estudiante);
					logger.info("Estudiante eliminado, adios" +sl + estudiante +sl);
				}else {
					logger.info("Estudiante NO encontrado" + sl + estudiante + sl);
				}
			}
		}
		return salir;
	}
}