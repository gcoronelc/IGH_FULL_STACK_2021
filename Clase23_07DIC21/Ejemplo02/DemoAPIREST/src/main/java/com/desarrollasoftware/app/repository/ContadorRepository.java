package com.desarrollasoftware.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.desarrollasoftware.app.domain.Contador;

public interface ContadorRepository extends CrudRepository<Contador, String> {
	
	

}
