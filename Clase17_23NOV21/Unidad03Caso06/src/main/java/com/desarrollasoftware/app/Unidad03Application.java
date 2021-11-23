package com.desarrollasoftware.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollasoftware.app.service.SaludoService;

@SpringBootApplication
@RestController
public class Unidad03Application {
	
	@Autowired
	@Qualifier("rol2")
	private SaludoService saludoService;
	
	public static void main(String[] args) {
		SpringApplication.run(Unidad03Application.class, args);
	}
	
	@RequestMapping("/saludo")
	public String saludo() {
		String hola = "Hola " + saludoService.getNombre();
		return hola;
	}

}
