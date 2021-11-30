package com.osinergmin.app.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.osinergmin.app.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String>{

	
	List<Cliente> findByPaterno(String paterno);
	
	List<Cliente> findByPaternoAndMaterno(String paterno, String materno);
	
	@Query("select * from cliente where upper(vch_cliepaterno) like upper(:paterno)")
	List<Cliente> buscarPorPaterno( @Param("paterno") String paterno);
	
	
	
}

