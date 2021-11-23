package com.igh.demo03.service;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	public String leerNombre(Integer id) {
		String nombre = "No se quien eres.";
		nombre = (id==1)?"Gustavo":nombre;
		nombre = (id==2)?"Jimena":nombre;
		nombre = (id==3)?"Carlos":nombre;
		nombre = (id==4)?"Laura":nombre;
		nombre = (id==5)?"Pedro":nombre;
		return nombre;
	}

}
