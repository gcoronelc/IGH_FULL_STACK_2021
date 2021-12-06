package com.osinergmin.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.osinergmin.app.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>{

	@Query(value = "select * from producto p where p.idcat = ?1", nativeQuery = true)
	List<Producto> findByCategoria(Long idCat);
	
}

