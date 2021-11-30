package com.igh.demo03.service;

import java.util.List;

import com.igh.demo03.entity.Producto;

public interface ProductoService {

	List<Producto> listarTodos();

	void grabar(Producto producto);

	Producto buscarPorId(Long id);

	void eliminar(Long id);

}
