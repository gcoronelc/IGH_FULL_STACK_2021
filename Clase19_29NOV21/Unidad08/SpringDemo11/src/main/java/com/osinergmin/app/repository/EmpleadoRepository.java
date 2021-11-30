package com.osinergmin.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.osinergmin.app.domain.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long>{

	
	List<Empleado> findByNombre(String nombre);
	
	List<Empleado> findByNombreLike(String nombre);
	
	List<Empleado> findByNombreIgnoreCase(String nombre);
	
	List<Empleado> findByNombreIgnoreCaseAndApellidoIgnoreCase(String nombre, String apellido);
	
}

