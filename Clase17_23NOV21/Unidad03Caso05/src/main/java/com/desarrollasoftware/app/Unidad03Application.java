package com.desarrollasoftware.app;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollasoftware.app.service.SaludoService;
import com.desarrollasoftware.app.service.SaludoServiceImpl1;

@SpringBootApplication
@RestController
public class Unidad03Application {
	
	@Autowired
	@Resource(name = "impl2")
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
