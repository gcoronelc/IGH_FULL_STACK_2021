package com.desarrollasoftware.app.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("impl1")
@Qualifier("rol1")
public class SaludoServiceImpl1 implements SaludoService{

	@Override
	public String getNombre() {
		return "Gustavo Coronel";
	}
	
}
