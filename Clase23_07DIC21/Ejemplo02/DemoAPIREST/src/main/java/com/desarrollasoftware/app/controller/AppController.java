package com.desarrollasoftware.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demoapi")
public class AppController {
	
	@GetMapping
	public String saludo() {
		return "Hola todos";
	}

}
