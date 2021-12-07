package com.desarrollasoftware.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTADOR")
public class Contador {

	@Id
	@Column(name = "VCH_CONTTABLA")
	private String id;
	@Column(name = "INT_CONTITEM")
	private Integer contador;
	@Column(name = "INT_CONTLONGITUD")
	private Integer longitud;

	public Contador() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}

	public Integer getLongitud() {
		return longitud;
	}

	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}

}
