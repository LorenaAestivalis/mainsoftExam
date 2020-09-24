package com.examen.controllers;
import java.util.List;

import com.examen.entities.Producto;
import com.examen.exceptions.Errormananger;
import com.examen.exceptions.NotFoundException;
import com.examen.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
@RequestMapping("/producto")
public class ProductoController extends ResponseEntityExceptionHandler {

	@Autowired
	ProductoService productoService;

	@GetMapping(value = "/listar_productos")//
	public List<Producto> listarProductos() {
		return productoService.listarProductos();
	}

	@PostMapping({"/agregar", "/registrar"})//
	public boolean agregarProducto(@RequestBody Producto producto) {
		return productoService.crear(producto);
	}

	@PutMapping("/actualizar")//
	public boolean actualizarProducto(@RequestBody Producto producto) {
		return productoService.actualizar(producto);
	}

	@DeleteMapping("/eliminar/{id}")//
	public boolean eliminarProducto(@PathVariable("id") long id) {
		return productoService.eliminar(id);
	}

	

	@GetMapping(value = "/encontrar/{id}")//
	public Producto obtenerProductosById(@PathVariable("id") long id) {
		return productoService.obtenerPorID(id);
	}

	@GetMapping(value = "/producto/{nombre}/{precio}")//
	public List<Producto> obtenerProductosByNombreAndPrecio(@PathVariable("nombre") String nombre,
			@PathVariable("precio") double precio) {
		return productoService.obtenerPorNombreAndPrecio(nombre, precio);
	}

	/////////////////Error Manager////////////////////

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Errormananger> handleNotFoundException(NotFoundException ex, WebRequest request) {
		Errormananger exceptionResponse = new Errormananger(
			HttpStatus.NOT_FOUND.getReasonPhrase(),
			ex.getLocalizedMessage(), 
			String.valueOf(HttpStatus.NOT_FOUND.value()),
			HttpStatus.NOT_FOUND.getReasonPhrase() + " Exception: ");
		return new ResponseEntity<Errormananger>(
			exceptionResponse, 
			HttpStatus.NOT_FOUND);
	}
}
