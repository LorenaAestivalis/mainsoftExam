package com.examen.repositories;

import java.io.Serializable;

import com.examen.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Serializable> {

}
