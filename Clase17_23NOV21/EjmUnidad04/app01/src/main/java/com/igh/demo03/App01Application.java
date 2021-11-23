package com.igh.demo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App01Application {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(App01Application.class, args);
	}

	@RequestMapping("/saludo")
	public String saludo() {
		return environment.getProperty("app.saludo");
	}

}
