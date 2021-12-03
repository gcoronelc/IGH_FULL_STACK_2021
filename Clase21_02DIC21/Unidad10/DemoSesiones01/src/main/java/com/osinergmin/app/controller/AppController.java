package com.osinergmin.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
	
	@GetMapping({"/","/home"})
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("listado") == null) {
			List<String> listado = new ArrayList<String>();
			//listado.add("Gustavo Coronel");
			session.setAttribute("listado", listado);
		}
		model.addAttribute("listado", session.getAttribute("listado"));
		return "home";
	}
	
	@PostMapping("/grabar")
	public String grabar(String nombre, HttpSession session) {
		List<String> listado;
		if(session.getAttribute("listado") == null) {
			listado = new ArrayList<String>();
		} else {
			listado = (List<String>) session.getAttribute("listado");
		}
		listado.add(nombre);
		session.setAttribute("listado", listado);
		return "redirect:/home";
	}
	
	@GetMapping("/fin")
	public String fin(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}
	
	@GetMapping("/eliminar1/{nombre}")
	public String eliminar1( @PathVariable("nombre") String nombre, HttpSession session) {
		List<String> listado;
		if(session.getAttribute("listado") == null) {
			listado = new ArrayList<String>();
		} else {
			listado = (List<String>) session.getAttribute("listado");
		}
		listado.remove(nombre);
		System.err.println("Proceso ok. " + nombre);
		session.setAttribute("listado", listado);
		return "redirect:/home";
	}
	
	@GetMapping("/eliminar2/{id}")
	public String eliminar2( @PathVariable("id") Integer id, HttpSession session) {
		List<String> listado;
		if(session.getAttribute("listado") == null) {
			listado = new ArrayList<String>();
		} else {
			listado = (List<String>) session.getAttribute("listado");
		}
		listado.remove(id.intValue());
		System.err.println("Proceso ok. " + id);
		session.setAttribute("listado", listado);
		return "redirect:/home";
	}

}

