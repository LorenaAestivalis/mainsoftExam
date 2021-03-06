package com.examen.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DetalleVenta")
public class DetalleVenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDetalleVenta;

	@ManyToOne
	@JoinColumn(name = "idProducto")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "idVenta")
	private Venta venta;



///////Constructores/////////////////
	public DetalleVenta() {
	}

	public DetalleVenta(long idDetalleVenta, Producto producto, Venta venta) {
		this.idDetalleVenta = idDetalleVenta;
		this.producto = producto;
		this.venta = venta;
	}




///////Getters and Setters/////////////////
	public long getIdDetalleVenta() {
		return this.idDetalleVenta;
	}

	public void setIdDetalleVenta(long idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

}
