package com.desarrollasoftware.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.desarrollasoftware.app.dto.ProductoDto;
import com.desarrollasoftware.app.dto.VentaDto;
import com.desarrollasoftware.app.service.VentaService;

@Controller
public class AppController {
	
	@Autowired
	private VentaService ventaService;

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
	
	
	@GetMapping(value = {"/venta"})
	public String venta(Model model) {
		
		model.addAttribute("titulo", "CALCULO DE UNA VENTA");
		model.addAttribute("datos", "DATOS DE LA VENTA");
		
		return "venta";
	}
	
	@PostMapping(value = "/procesar6")
	public ModelAndView procesar6(@ModelAttribute VentaDto ventaDto) {
		
		// Proceso
		ventaDto = ventaService.procesar(ventaDto);
		
		// Reporte con ModelAndView
		ModelAndView mav = new ModelAndView("venta");
		mav.addObject("service", "procesar6");
		mav.addObject("ventaDto", ventaDto);

		
		mav.addObject("titulo", "CALCULO DE UNA VENTA");
		mav.addObject("reporte", "REPORTE DE CALCULO");
		
		return mav;
	}
	
	@GetMapping(value = "/procesar7", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public VentaDto procesar7(@ModelAttribute VentaDto ventaDto) {
		
		// Proceso
		ventaDto = ventaService.procesar(ventaDto);
		
		// Reporte con ModelAndView
		ModelAndView mav = new ModelAndView("venta");
		mav.addObject("service", "procesar6");
		mav.addObject("ventaDto", ventaDto);
		
		return ventaDto;
	}
	
	@GetMapping(value = "/procesar8", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<ProductoDto> procesar8() {
		
		// Dato
		List<ProductoDto> lista = new ArrayList<>();
		lista.add(new ProductoDto("Producto 1", 500.0));
		lista.add(new ProductoDto("Producto 2", 400.0));
		lista.add(new ProductoDto("Producto 3", 300.0));
		lista.add(new ProductoDto("Producto 4", 600.0));
		lista.add(new ProductoDto("Producto 5", 700.0));
		
		return lista;
	}
	
}
