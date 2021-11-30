package com.igh.demo03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igh.demo03.entity.Categoria;
import com.igh.demo03.entity.Producto;
import com.igh.demo03.service.CategoriaService;
import com.igh.demo03.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping({ "/", "todos" })
	public String listar(Model model) {
		List<Producto> lista = productoService.listarTodos();
		model.addAttribute("titulo", "LISTA DE PRODUCTOS");
		model.addAttribute("productos", lista);
		return "/productos/listado";
	}

	@GetMapping("/crear")
	public String crear(Model model) {
		Producto producto = new Producto();
		List<Categoria> listaCategorias = categoriaService.listarTodos();
		model.addAttribute("titulo", "NUEVO PRODUCTO");
		model.addAttribute("producto", producto);
		return "/productos/frmEditar";
	}
	
	
	// Objetos que se cargan en la página actual
	// Si se necesitan, se utilizan
	// Por ejemplo, para llenar los combos
	
	@ModelAttribute("categorias")
	public List<Categoria> poblarCategorias() {
		List<Categoria> listaCategorias = categoriaService.listarTodos();
		return listaCategorias;
	}

}
