package com.osinergmin.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.osinergmin.app.domain.Empleado;
import com.osinergmin.app.service.EmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping({ "/", "/todos" })
	@ResponseBody
	public List<Empleado> listar() {
		List<Empleado> lista = empleadoService.listarTodos();
		return lista;
	}

	@GetMapping("/leer/{id}")
	@ResponseBody
	public Empleado editar(@PathVariable("id") Long id) {
		Empleado empleado = empleadoService.buscarPorId(id);
		if (empleado == null) {
			empleado = new Empleado(-1L, "", "", "", "");
		}
		return empleado;
	}

	@PostMapping("/grabar")
	@ResponseBody
	public Empleado guardar(@ModelAttribute Empleado empleado) {
		Empleado bean = empleadoService.grabar(empleado);
		return bean;
	}

	@GetMapping("/eliminar/{id}")
	@ResponseBody
	public Empleado eliminar(@PathVariable("id") Long id) {
		Empleado empleado = empleadoService.buscarPorId(id);
		if( empleado == null) {
			empleado = new Empleado(-1L, "", "", "", "");
		} else  {
			empleadoService.eliminar(id);
		}
		return empleado;
	}

	@GetMapping("/buscar1" )
	@ResponseBody
	public List<Empleado> buscar1(String nombre) {
		List<Empleado> lista = empleadoService.buscarPorNombre(nombre);
		return lista;
	}
	
	@GetMapping("/buscar2" )
	@ResponseBody
	public List<Empleado> buscar2(String nombre, String apellido) {
		List<Empleado> lista = empleadoService.buscarPorNombreAndApellido(nombre, apellido);
		return lista;
	}
	
}
