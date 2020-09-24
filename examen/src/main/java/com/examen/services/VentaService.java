package com.examen.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.examen.entities.DetalleVenta;
import com.examen.entities.Venta;
import com.examen.repositories.ClienteRepository;
import com.examen.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rx.Observable;

@Service
public class VentaService {
	private VentaRepository ventaRepository;
	@Autowired
	public VentaService(VentaRepository ventaRepository) {
		this.ventaRepository = ventaRepository;
	}


	public List<Venta> listarVentas() {
		try {
			return ventaRepository.findAll();
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return null;
		}
	}


	public boolean crear(Venta venta) {
		try {
			Venta newVenta=ventaRepository.save(venta);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public List<Venta> listarVentasByFecha(Date fecha) {
		try {
			return ventaRepository.findByFecha(fecha);
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<DetalleVenta> listarDetalleVenta(long idVenta) {
		try {
			List<DetalleVenta> detalleVentas = new ArrayList<>();
			Observable<DetalleVenta> obs = Observable.from(detalleVentas);
			return null;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
