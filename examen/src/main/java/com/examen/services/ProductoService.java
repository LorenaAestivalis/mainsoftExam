package com.examen.services;
import java.util.List;

import com.examen.entities.Cliente;
import com.examen.entities.Producto;
import com.examen.exceptions.NotFoundException;
import com.examen.repositories.ClienteRepository;
import com.examen.repositories.ProdctoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductoService {
	private ProdctoRepository productoRepository;
	@Autowired
	public ProductoService(ProdctoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	public List<Producto> listarProductos() {
		try {
			return productoRepository.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean crear(Producto producto) {
		try {
			productoRepository.save(producto);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean actualizar(Producto producto) {
		try {
			productoRepository.save(producto);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean eliminar(long id) {
		try {
			productoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Producto obtenerPorID(long id) {
		try {
			if (productoRepository.findById(id) == null) {
				throw new Exception();
			}
			return productoRepository.findById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new NotFoundException("Id de producto no encontrado");
		}
	}

	public List<Producto> obtenerPorNombreAndPrecio(String nombre, double precio) {
		try {
			return productoRepository.findByNombreAndPrecio(nombre, precio);
		} catch (Exception e) {

			System.out.println(e.getMessage());
			 throw new NotFoundException("Id de producto no encontrado");
		}
	}
}
