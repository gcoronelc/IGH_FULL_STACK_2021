package com.osinergmin.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osinergmin.app.entity.Producto;
import com.osinergmin.app.repository.ProductoRepository;
import com.osinergmin.app.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;

	@Override
	public List<Producto> listarTodos() {
		List<Producto> lista = (List<Producto>) repository.findAll();
		return lista;
	}

	@Override
	public void grabar(Producto producto) {
		repository.save(producto);
	}

	@Override
	public Producto buscarPorId(Long id) {
		Producto bean = repository.findById(id).orElse(null);
		return bean;
	}

	@Override
	public void eliminar(Long id) {
		repository.deleteById(id);
	}

}
