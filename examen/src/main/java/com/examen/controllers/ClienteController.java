package com.examen.controllers;
import com.examen.entities.Cliente;
import com.examen.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@PostMapping({"/agregar", "/registrar"})
	public boolean agregarCliente(@RequestBody Cliente cliente) {
		return clienteService.crear(cliente);
	}

}
