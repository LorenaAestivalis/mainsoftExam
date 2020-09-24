package com.examen;


import static org.junit.Assert.assertEquals;

import java.util.List;

import com.examen.controllers.ProductoController;
import com.examen.entities.Producto;
import com.examen.repositories.ProdctoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;


@SpringBootTest
public class TestingProductoController {
    @Autowired
    private ProdctoRepository productoRepository;
    private ProductoController controller;
    private String nombre;
    private int precio;

    @BeforeEach
    void init() {
        nombre = String.valueOf(Math.abs(Math.random() * 1000));
        precio = (int) (Math.random() * 1000);
    }

    @Test
    void crearProducto() {
        Producto p = new Producto(nombre, precio);
        assertEquals(HttpStatus.CREATED, controller.agregarProducto(p));
        buscarProducto();
    }

    void buscarProducto() {
        List<Producto> body = (List<Producto>) controller.listarProductos();
        List<Producto> productos = body;
        assertEquals(1, productos.size());
        assertEquals(1, productos.stream().filter(
                p -> p.getNombre().equals(nombre) && p.getPrecio() == precio && p.getIdProducto() != 1)
                .count());
    }
}
