package com.osinergmin.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osinergmin.app.domain.Empleado;
import com.osinergmin.app.repository.EmpleadoRepository;
import com.osinergmin.app.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> listarTodos() {
		return (List<Empleado>) empleadoRepository.findAll();
	}

	@Override
	public Empleado buscarPorId(Long id) {
		return empleadoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Empleado grabar(Empleado empleado) {
		if(empleado.getTelefono() == null) {
			empleado.setTelefono("none");
		}
		return empleadoRepository.save(empleado);
	}

	@Override
	public void eliminar(Long id) {
		
		empleadoRepository.deleteById(id);
	}

	@Override
	public List<Empleado> buscarPorNombre(String nombre) {
		return empleadoRepository.findByNombreLike(nombre + "%");
	}

	@Override
	public List<Empleado> buscarPorNombreAndApellido(String nombre, String apellido) {
		return empleadoRepository.findByNombreIgnoreCaseAndApellidoIgnoreCase(nombre, apellido);
	}

}
