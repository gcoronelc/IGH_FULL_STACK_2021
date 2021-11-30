package com.igh.demo03.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igh.demo03.entity.Categoria;
import com.igh.demo03.repository.CategoriaRepository;
import com.igh.demo03.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Override
	public List<Categoria> listarTodos() {
		List<Categoria> lista = (List<Categoria>) repository.findAll();
		return lista;
	}
}
