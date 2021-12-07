package com.desarrollasoftware.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.desarrollasoftware.app.domain.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String> {
	
	List<Cliente> findByPaternoContainingIgnoreCase(String paterno);

}
