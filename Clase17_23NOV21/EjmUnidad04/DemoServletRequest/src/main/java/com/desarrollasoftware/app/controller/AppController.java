package com.desarrollasoftware.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@GetMapping(value = {"/","/home"})
	public String home(Model model) {
		
		model.addAttribute("titulo", "CALCULO DE UNA VENTA");
		model.addAttribute("datos", "DATOS DE LA VENTA");
		
		return "home";
	}
	
	@PostMapping(value = "/procesar1")
	public String procesar1(HttpServletRequest request) {
		
		// Datos
		double precio = Double.parseDouble(request.getParameter("precio"));
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		
		// Proceso
		double total = precio * cantidad;
		double importe  = total / 1.18;
		double impuesto = total - importe;
		
		// Reporte con request
		request.setAttribute("service", "procesar1");
		request.setAttribute("precio", precio);
		request.setAttribute("cantidad", cantidad);
		request.setAttribute("importe", importe);
		request.setAttribute("impuesto", impuesto);
		request.setAttribute("total", total);
			
		request.setAttribute("titulo", "CALCULO DE UNA VENTA");
		request.setAttribute("reporte", "REPORTE DE CALCULO");
		
		return "home";
	}
	
	@PostMapping(value = "/procesar2")
	public String procesar2(HttpServletRequest request, Model model) {
		
		// Datos
		double precio = Double.parseDouble(request.getParameter("precio"));
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		
		// Proceso
		double total = precio * cantidad;
		double importe  = total / 1.18;
		double impuesto = total - importe;
		
		
		// Reporte con model
		model.addAttribute("service", "procesar2");
		model.addAttribute("precio", precio);
		model.addAttribute("cantidad", cantidad);
		model.addAttribute("importe", importe);
		model.addAttribute("impuesto", impuesto);
		model.addAttribute("total", total);
		
		model.addAttribute("titulo", "CALCULO DE UNA VENTA");
		model.addAttribute("reporte", "REPORTE DE CALCULO");
		
		return "home";
	}
	
	@PostMapping(value = "/procesar3")
	public ModelAndView procesar3(HttpServletRequest request) {
		
		// Datos
		double precio = Double.parseDouble(request.getParameter("precio"));
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		
		// Proceso
		double total = precio * cantidad;
		double importe  = total / 1.18;
		double impuesto = total - importe;
		
		
		// Reporte con ModelAndView
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("service", "procesar3");
		mav.addObject("precio", precio);
		mav.addObject("cantidad", cantidad);
		mav.addObject("importe", importe);
		mav.addObject("impuesto", impuesto);
		mav.addObject("total", total);
		
		mav.addObject("titulo", "CALCULO DE UNA VENTA");
		mav.addObject("reporte", "REPORTE DE CALCULO");
		
		return mav;
	}
	
	@PostMapping(value = "/procesar4")
	public ModelAndView procesar4(@RequestParam double precio, @RequestParam int cantidad) {
		
		// Proceso
		double total = precio * cantidad;
		double importe  = total / 1.18;
		double impuesto = total - importe;
		
		// Reporte con ModelAndView
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("service", "procesar4");
		mav.addObject("precio", precio);
		mav.addObject("cantidad", cantidad);
		mav.addObject("importe", importe);
		mav.addObject("impuesto", impuesto);
		mav.addObject("total", total);
		
		mav.addObject("titulo", "CALCULO DE UNA VENTA");
		mav.addObject("reporte", "REPORTE DE CALCULO");
		
		return mav;
	}
	
	@PostMapping(value = "/procesar5")
	public ModelAndView procesar5(
			@RequestParam(name = "precio") double valor, 
			@RequestParam(name = "cantidad") int cant,
			@RequestParam(name="dcto", defaultValue = "10") Double dcto) {
		
		// Proceso
		double total = valor * cant;
		double importe  = total / 1.18;
		double impuesto = total - importe;
		
		System.out.println("DESCUENTO: " + dcto);
		
		// Reporte con ModelAndView
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("service", "procesar5");
		mav.addObject("precio", valor);
		mav.addObject("cantidad", cant);
		mav.addObject("importe", importe);
		mav.addObject("impuesto", impuesto);
		mav.addObject("total", total);
		
		mav.addObject("titulo", "CALCULO DE UNA VENTA");
		mav.addObject("reporte", "REPORTE DE CALCULO");
		
		return mav;
	}
	
}
