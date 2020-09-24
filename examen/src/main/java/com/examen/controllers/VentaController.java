package com.examen.controllers;

import java.util.Date;
import java.util.List;

import com.examen.entities.Venta;
import com.examen.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/venta")
public class VentaController {

	@Autowired
	VentaService ventaService;

	@GetMapping(value = {"/listar_ventas","listarventas"})//
	public List<Venta> listarVentas() {
		return ventaService.listarVentas();
	}


	@PostMapping({"/agregar", "/registrar"})
	public boolean agregarVenta(@RequestBody Venta venta) {
			return ventaService.crear(venta);
	}

	@GetMapping(value = "/{fecha}")
	public List<Venta> listarVentasByFecha(
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			@PathVariable("nombre") Date fecha) {
			return ventaService.listarVentasByFecha(fecha);
	}
}
