package com.igh.demo03.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.igh.demo03.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String>{

	@Query("SELECT * FROM eureka.cliente "
			+ "WHERE upper(vch_cliepaterno) like upper(:paterno) "
			+ "AND upper(vch_cliematerno) like upper(:materno) ")
	List<Cliente> findByPaternoAndMaterno(String paterno, String materno);
	
	List<Cliente> findByPaternoLikeAndMaternoLike(String paterno, String materno);
	
}
