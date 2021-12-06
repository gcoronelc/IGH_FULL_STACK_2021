package com.osinergmin.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osinergmin.app.entity.Categoria;
import com.osinergmin.app.repository.CategoriaRepository;
import com.osinergmin.app.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> listarTodos() {
		List<Categoria> lista = (List<Categoria>) categoriaRepository.findAll();
		return lista;
	}

}

