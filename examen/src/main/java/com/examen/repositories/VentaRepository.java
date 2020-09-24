package com.examen.repositories;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.examen.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Serializable> {
	public List<Venta> findByFecha(Date Fecha);
}