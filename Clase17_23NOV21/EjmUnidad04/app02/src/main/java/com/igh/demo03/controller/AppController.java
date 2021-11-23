package com.igh.demo03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.igh.demo03.service.ClienteService;

@Controller
public class AppController {
	
	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("mensaje", "Hola GUSTAVO CORONEL.");
		return "home"; // Nombre de la página JSP
	}
	
	@GetMapping(value = "/clientes/leer/{id}")
	public String clientes(@PathVariable Integer id, Model model){
		model.addAttribute("nombre", clienteService.leerNombre(id));
		return "clientes";
	}

}
