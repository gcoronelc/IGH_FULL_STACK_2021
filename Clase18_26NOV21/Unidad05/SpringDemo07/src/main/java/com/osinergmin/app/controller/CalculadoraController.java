package com.osinergmin.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.osinergmin.app.model.MateModel;

@Controller
@RequestMapping("/calculadora")
public class CalculadoraController {
	
	@GetMapping("/")
	public String form(MateModel mateModel, Model model) {
		model.addAttribute("titulo", "CALCULADORA BASICA");
		return "calculadora/calculadora";
	}

	@PostMapping("/")
	public String procesar2(MateModel mateModel, Model model) {
		// Proceso
		mateModel.setSuma(mateModel.getNum1() + mateModel.getNum2());
		mateModel.setProducto(mateModel.getNum1() * mateModel.getNum2());
		// Reporte
		model.addAttribute("titulo", "CALCULADORA BASICA");
		model.addAttribute("resultado", "LOS RESULTADOS");
		return "calculadora/calculadora";
	}
}

