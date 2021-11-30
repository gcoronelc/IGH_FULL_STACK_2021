package com.osinergmin.app.service;

import java.util.List;

import com.osinergmin.app.domain.Empleado;

public interface EmpleadoService {

	List<Empleado> listarTodos();

	Empleado buscarPorId(Long id);

	Empleado grabar(Empleado empleado);

	void eliminar(Long id);
	
	List<Empleado> buscarPorNombre(String nombre);
	
	List<Empleado> buscarPorNombreAndApellido(String nombre, String apellido);

}
