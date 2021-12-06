package com.osinergmin.app.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.osinergmin.app.entity.Categoria;
import com.osinergmin.app.entity.Producto;
import com.osinergmin.app.service.CategoriaService;
import com.osinergmin.app.service.ProductoService;

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

	@ModelAttribute("categorias")
	public List<Categoria> poblarCategorias() {
		List<Categoria> listaCategorias = categoriaService.listarTodos();
		return listaCategorias;
	}

	@GetMapping("/crear")
	public String crear(Model model) {
		Producto producto = new Producto();
		model.addAttribute("titulo", "NUEVO PRODUCTO");
		model.addAttribute("producto", producto);
		return "/productos/frmEditar";
	}

	@PostMapping("/grabar")
	public String guardar(@Valid @ModelAttribute Producto producto, BindingResult result, Model model,
			RedirectAttributes atributos) {

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
		atributos.addFlashAttribute("success", "Producto guardado con exito!");
		return "redirect:/productos/";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long idProd, Model model, RedirectAttributes atributos) {

		// Id de producto invalido
		if (idProd <= 0) {
			atributos.addFlashAttribute("error", "El id del producto es incorrecto.");
			return "redirect:/productos/todos";
		}

		Producto producto = productoService.buscarPorId(idProd);

		// Id de producto no existe
		if (producto == null) {
			atributos.addFlashAttribute("error", "El id del producto no existe.");
			return "redirect:/productos/todos";
		}

		model.addAttribute("titulo", "EDITAR PRODUCTO (" + idProd + ")");
		model.addAttribute("producto", producto);
		return "/productos/frmEditar";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long idProd, RedirectAttributes atributos) {

		// Id de producto invalido
		if (idProd <= 0) {
			atributos.addFlashAttribute("error", "El ID del producto es incorrecto.");
			return "redirect:/productos/todos";
		}
		
		Producto producto = productoService.buscarPorId(idProd);
		
		// Id de producto no existe
		if (producto == null) {
			atributos.addFlashAttribute("error", "El ID del producto no existe.");
			return "redirect:/productos/todos";
		}

		productoService.eliminar(idProd);
		System.out.println("Producto eliminado con exito!");
		atributos.addFlashAttribute("warning", "Producto " + idProd + " eliminado con éxito.");
		return "redirect:/productos/";
	}

}
