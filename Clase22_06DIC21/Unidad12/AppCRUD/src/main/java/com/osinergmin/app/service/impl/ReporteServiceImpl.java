package com.osinergmin.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osinergmin.app.entity.Categoria;
import com.osinergmin.app.entity.Producto;
import com.osinergmin.app.repository.CategoriaRepository;
import com.osinergmin.app.repository.ProductoRepository;
import com.osinergmin.app.service.ReporteService;

@Service
public class ReporteServiceImpl implements ReporteService{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Map<String, ?>> traerCategorias() {
		List<Categoria> lista = (List<Categoria>) categoriaRepository.findAll();
		List<Map<String, ?>> lista2 = new ArrayList<>();
		for(Categoria c: lista) {
			Map<String,Object> r = new HashMap<>();
			r.put("ID", c.getId());
			r.put("NOMBRE", c.getNombre());
			lista2.add(r);
		}
		return lista2;
	}

	@Override
	public List<Map<String, ?>> traerProductos(Long categoria) {
		List<Producto> lista = productoRepository.findByCategoria(categoria);
		List<Map<String, ?>> lista2 = new ArrayList<>();
		for(Producto p: lista) {
			Map<String,Object> r = new HashMap<>();
			r.put("ID", p.getId());
			r.put("NOMBRE", p.getNombre());
			r.put("CATEGORIA", p.getCategoria().getId());
			r.put("PRECIO", p.getPrecio());
			r.put("STOCK", p.getStock());
			lista2.add(r);
		}
		return lista2;
	}

}

