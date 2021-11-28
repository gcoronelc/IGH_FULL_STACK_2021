package com.osinergmin.app.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class EmpleadoModel {

	@NotEmpty
	@Size(min = 2, max = 30)
	private String nombre;

	@NotNull
	@Min(value = 18)
	private Integer edad;
	
	@NotEmpty
	@Pattern( regexp = "^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$",
	message = "Correo mal formado")
	private String correo;

	public EmpleadoModel() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
