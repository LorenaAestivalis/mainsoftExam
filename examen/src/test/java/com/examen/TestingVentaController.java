package com.examen;


import com.examen.controllers.VentaController;
import com.examen.repositories.ClienteRepository;
import com.examen.repositories.ProdctoRepository;
import com.examen.repositories.VentaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestingVentaController {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private ProdctoRepository productoRepository;

    @Autowired
    private VentaController controller;
    private String nombreProducto;
    private int precioProducto;
    private String idCliente;
    private String dniCliente;
    private String telCliente;
    private String correoCliente;
    private String nombreCliente;

    @BeforeEach
    void init() {
        idCliente = String.valueOf(Math.abs(Math.random() * 1060000));
        nombreProducto= String.valueOf(Math.abs(Math.random() * 1070000));
        precioProducto = (int) (Math.random() * 1000900);
        nombreCliente = String.valueOf(Math.abs(Math.random() * 1008000));
        dniCliente = "lore7637";
        telCliente = "67537623-3";
        correoCliente = "lore@gmail.com";
    }



}
