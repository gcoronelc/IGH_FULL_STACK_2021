package com.igh.demo03.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igh.demo03.dto.DatosDto;

@RestController
@RequestMapping("/api/v1/app")
public class AppController {
	
	@GetMapping
	public String saludo() {
		return "Hola desde Spring Boot REST";
	}
	
	@GetMapping("/saludo")
	public String saludo2() {
		return "Hola, estamos trabajando con Spring Boot REST.";
	}
	
	@GetMapping("/saludo/{nombre}")
	public String saludo2( @PathVariable String nombre) {
		return "Hola " + nombre + ", pronto seremos expertos en Spring Boot REST.";
	}
	
	@PostMapping("/sumar")
	public String sumar(@RequestParam Integer num1, @RequestParam Integer num2) {
		int suma = num1 + num2;
		String respuesta = num1 + " + " + num2 + " = " + suma;
		return respuesta;
	}
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping("/sumar2")
	public String sumar2(@RequestBody DatosDto datosDto) {
		int suma = datosDto.getNum1() + datosDto.getNum2();
		String respuesta = datosDto.getNum1() + " + " + datosDto.getNum2() + " = " + suma;
		return respuesta;
	}
}
