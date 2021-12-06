package com.osinergmin.app.service;

import java.util.List;

import com.osinergmin.app.entity.Producto;

public interface ProductoService {

	List<Producto> listarTodos();

	void grabar(Producto producto);

	Producto buscarPorId(Long id);

	void eliminar(Long id);

}
