package com.examen;

import static org.junit.Assert.assertEquals;

import com.examen.controllers.ClienteController;
import com.examen.entities.Cliente;
import com.examen.repositories.ClienteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class TestingClienteController {
	@Autowired
	private ClienteRepository clienteRepository;
	private ClienteController clienteController;
	private int idRandom;
	private String nombre;
	private String apellido;
	private String dni;
	private String tel;
	private String email;


	@BeforeEach
	void init() {
		idRandom = 1;
		nombre = "lore";
		apellido="macias";
		dni = "lore123";
		tel = "8732986";
		email = "lore@gmail.com";

	}

	@Test
	void crearCliente() {
		Cliente c = new Cliente(idRandom, nombre,apellido, dni, tel, email);
		assertEquals(HttpStatus.CREATED, clienteController.agregarCliente(c));

	}

	@AfterEach
	void test() {
		assertEquals(1L,
				clienteRepository.findAll().stream()
						.filter(cli -> cli.getApellido().equals(idRandom)
								&& cli.getNombre().equals(idRandom)
								&& cli.getApellido().equals(idRandom)
								&& cli.getTelefono().equals(tel) && cli.getEmail().equals(email)
								&& cli.getDni().equals(dni) && cli.getIdCliente() != 1)
						.count());

	}
}
