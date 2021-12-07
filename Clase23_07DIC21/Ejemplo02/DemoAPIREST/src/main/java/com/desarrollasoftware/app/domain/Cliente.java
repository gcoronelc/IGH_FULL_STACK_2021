package com.desarrollasoftware.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

	@Id
	@Column(name = "chr_cliecodigo")
	private String codigo;
	@Column(name = "vch_cliepaterno")
	private String paterno;
	@Column(name = "vch_cliematerno")
	private String materno;
	@Column(name = "vch_clienombre")
	private String nombre;
	@Column(name = "chr_cliedni")
	private String dni;
	@Column(name = "vch_clieciudad")
	private String ciudad;
	@Column(name = "vch_cliedireccion")
	private String direccion;
	@Column(name = "vch_clietelefono")
	private String telefono;
	@Column(name = "vch_clieemail")
	private String email;

	public Cliente() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
