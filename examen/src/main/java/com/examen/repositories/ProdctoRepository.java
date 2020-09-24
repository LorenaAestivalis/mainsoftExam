package com.examen.repositories;
import java.util.List;

import com.examen.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdctoRepository extends JpaRepository<Producto, Long> {
	
	public Producto findById(long id);
	public List<Producto> findByNombreAndPrecio(String nombre, double precio);
}
