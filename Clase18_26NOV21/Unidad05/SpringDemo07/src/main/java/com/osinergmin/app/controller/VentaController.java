package com.osinergmin.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ventas")
public class VentaController {
	
	@GetMapping({"/","/ventas"})
	public String obtenerPaginaInicio() {
		
		return "venta/venta";
	}

}
