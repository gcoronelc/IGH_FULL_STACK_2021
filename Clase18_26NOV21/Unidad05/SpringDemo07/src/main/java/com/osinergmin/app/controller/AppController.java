package com.osinergmin.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.osinergmin.app.model.MateModel;
import com.osinergmin.app.model.Producto;
import com.osinergmin.app.model.User;

@Controller
public class AppController {

	@GetMapping({ "/", "/home" })
	public String home(Model model) {
		model.addAttribute("titulo", "Página de Inicio");
		model.addAttribute("mensaje", "Bienvenido a Thymeleaf.");
		return "home";
	}

	@GetMapping("/producto")
	public String datosProducto(Model model) {
		Producto producto = new Producto(1000, "Licuadora", 598.00, 768);
		model.addAttribute("titulo", "Datos del Producto");
		model.addAttribute("producto", producto);
		return "producto";
	}

	@GetMapping("/listado")
	public String listado(Model model) {
		List<Producto> productos = new ArrayList<>();
		productos.add(new Producto(1001, "Producto A", 598.00, 768));
		productos.add(new Producto(1002, "Producto B", 783.00, 100));
		productos.add(new Producto(1003, "Producto C", 278.00, 350));
		productos.add(new Producto(1004, "Producto D", 723.00, 820));
		productos.add(new Producto(1005, "Producto E", 634.00, 649));
		model.addAttribute("titulo", "Listado de Productos");
		model.addAttribute("productos", productos);
		return "listado2";
	}
	
	@GetMapping("/datos")
	public String datos(Model model) {
		model.addAttribute("ver", 1);
		return "datos";
	}

	@GetMapping("/usuario")
	public String datosUsuario(Model model) {
		User user = new User(1000, "Gustavo", "admin");
		model.addAttribute("titulo", "Datos del Usuario");
		model.addAttribute("user", user);
		return "usuario";
	}

	@GetMapping("/calculadora1")
	public String calculadora1(Model model) {
		MateModel mate = new MateModel(0, 0);
		model.addAttribute("titulo", "CALCULADORA BASICA");
		model.addAttribute("mate", mate);
		return "calculadora1";
	}

	@PostMapping("/procesar1")
	public String procesar1(@ModelAttribute MateModel mate, Model model) {
		// Proceso
		mate.setSuma(mate.getNum1() + mate.getNum2());
		mate.setProducto(mate.getNum1() * mate.getNum2());
		// Reporte
		model.addAttribute("titulo", "CALCULADORA BASICA");
		model.addAttribute("resultado", "LOS RESULTADOS");
		model.addAttribute("mate", mate);
		return "calculadora1";
	}
	
	@GetMapping("/calculadora2")
	public String calculadora2(MateModel mateModel, Model model) {
		model.addAttribute("titulo", "CALCULADORA BASICA");
		return "calculadora2";
	}
	
	@PostMapping("/procesar2")
	public String procesar2(MateModel mateModel, Model model) {
		// Proceso
		mateModel.setSuma(mateModel.getNum1() + mateModel.getNum2());
		mateModel.setProducto(mateModel.getNum1() * mateModel.getNum2());
		// Reporte
		model.addAttribute("titulo", "CALCULADORA BASICA");
		model.addAttribute("resultado", "LOS RESULTADOS");
		return "calculadora2";
	}

}
