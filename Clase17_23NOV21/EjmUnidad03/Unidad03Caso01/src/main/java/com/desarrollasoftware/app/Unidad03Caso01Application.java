package com.desarrollasoftware.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollasoftware.app.service.AppService;

@SpringBootApplication
@RestController
public class Unidad03Caso01Application {
	
	@Autowired
	private AppService appService;

	public static void main(String[] args) {
		SpringApplication.run(Unidad03Caso01Application.class, args);
	}
	
	@RequestMapping("/saludo")
	public String saludo() {
		return appService.getNombre();
	}

}
