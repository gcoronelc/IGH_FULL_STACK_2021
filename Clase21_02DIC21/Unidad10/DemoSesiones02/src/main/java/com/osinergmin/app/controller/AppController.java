package com.osinergmin.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.osinergmin.app.dto.ProductoDto;

@Controller
@SessionAttributes({ "listado", "usuario" })
public class AppController {

	
	@ModelAttribute("listado")
	public Map<String, ProductoDto> getListado() {
		Map<String, ProductoDto> listado = new HashMap<>();
		//ProductoDto dto = new ProductoDto("Televisor A1", 4890.0);
		//listado.put(dto.getNombre(), dto);
		return listado;
	}
	
	@ModelAttribute("usuario")
	public String getUsuario() {
		String usuario = "Gustavo Coronel";
		return usuario;
	}

	
	@GetMapping({ "/", "/home" })
	public String home() {
		return "home";
	}

	
	@PostMapping("/grabar")
	public String grabar(@ModelAttribute ProductoDto dto, @ModelAttribute("listado") Map<String, ProductoDto> listado) {
		listado.put(dto.getNombre(), dto);
		return "home";
	}

	
	@GetMapping("/fin")
	public String fin(SessionStatus status) {
		status.setComplete();
		return "redirect:/home";
	}
	
	@GetMapping("/eliminar/{key}")
	public String eliminar(@PathVariable("key") String key, @ModelAttribute("listado") Map<String, ProductoDto> mapa) {
		mapa.remove(key);
		return "home";
	}
	

}
