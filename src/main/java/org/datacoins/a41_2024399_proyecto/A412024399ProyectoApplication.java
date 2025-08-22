package org.datacoins.a41_2024399_proyecto;

import org.datacoins.a41_2024399_proyecto.dominio.service.IEstudianteService;
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
				6. Salir.
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
					logger.info("estudiante encontrado:");
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
				estudiantee.setCorreo(correo);
				cliente.setGenero(genero);
				cliente.setEdad(edad);
				clienteService.guardarCliente(cliente);
				logger.info("Cliente agregado: " + sl + cliente + sl);
			}

			case 4 -> {
				logger.info(sl+"*** Modificar ciente***"+sl);
				logger.info("Ingrese el codigo del cliente a editar: ");
				var codigo = Integer.parseInt(consola.nextLine());
				Cliente cliente = clienteService.buscarClientePorId(codigo);
				if (cliente != null){
					logger.info("Ingrese el nombre: ");
					var nombre = consola.nextLine();
					logger.info("Ingrese el apellido: ");
					var apellido = consola.nextLine();
					logger.info("Ingrese el telefono: ");
					var telefono = consola.nextLine();
					logger.info("Ingrese el correo: ");
					var correo = consola.nextLine();
					logger.info("Ingrese el genero: ");
					var genero = consola.nextLine();
					logger.info("Ingrese la edad: ");
					var edad = Integer.parseInt(consola.nextLine());
					cliente.setNombre(nombre);
					cliente.setApellido(apellido);
					cliente.setTelefono(telefono);
					cliente.setCorreo(correo);
					cliente.setGenero(genero);
					cliente.setEdad(edad);
					clienteService.guardarCliente(cliente);
					logger.info("Cliente agregado: "+sl +cliente +sl);
				}else{
					logger.info("Cliente NO encontrado: "+sl+cliente+sl);
				}
			}

			case 5 -> {
				logger.info(sl+"*** Eliminar Cliente"+sl);
				logger.info("Ingrese el codigo de cliente a eliminar");
				var codigo = Integer.parseInt(consola.nextLine());
				var cliente = clienteService.buscarClientePorId(codigo);
				if (cliente != null){
					clienteService.eliminarCliente(cliente);
					logger.info("Cliente eliminado, adios" +sl + cliente +sl);
				}else {
					logger.info("Cliente NO encontrado" + sl + cliente + sl);
				}
			}

		}
		return salir;
	}
}