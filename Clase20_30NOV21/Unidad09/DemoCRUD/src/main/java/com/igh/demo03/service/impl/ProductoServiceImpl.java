package com.igh.demo03.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igh.demo03.entity.Producto;
import com.igh.demo03.repository.ProductoRepository;
import com.igh.demo03.service.ProductoService;

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
