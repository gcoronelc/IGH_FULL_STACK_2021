package com.igh.demo03.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	/*
	@GetMapping("/crear")
	public String crear(Model model) {
		Producto producto = new Producto();
		model.addAttribute("titulo", "NUEVO PRODUCTO");
		model.addAttribute("producto", producto);
		return "/productos/frmEditar";
	}
	*/

	@PostMapping("/grabar")
	public String guardar(@ModelAttribute Producto producto) {
		productoService.grabar(producto);
		System.out.println("Producto grabado con exito!");
		return "redirect:/productos/";
	}

	@PostMapping("/grabar")
	public String guardar(@Valid @ModelAttribute Producto producto, 
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.err.println("Se presentaron errores en el formulario!");
			String titulo = "NUEVO PRODUCTO";
			if (producto.getId() > 0) {
				titulo = "EDITAR PRODUCTO (" + producto.getId() + ")";
			}
			model.addAttribute("titulo", titulo);
			model.addAttribute("producto", producto);
			return "/productos/frmEditar";
		}
		productoService.grabar(producto);
		System.out.println("Producto grabado con exito!");
		return "redirect:/productos/";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long idProd, Model model) {
		Producto producto = productoService.buscarPorId(idProd);
		model.addAttribute("titulo", "EDITAR PRODUCTO (" + idProd + ")");
		model.addAttribute("producto", producto);
		return "/productos/frmEditar";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long idProd) {
		productoService.eliminar(idProd);
		System.out.println("Producto eliminado con exito!");
		return "redirect:/productos/";
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
