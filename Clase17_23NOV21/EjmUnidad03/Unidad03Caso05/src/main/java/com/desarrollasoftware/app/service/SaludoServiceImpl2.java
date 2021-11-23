package com.desarrollasoftware.app.service;

import org.springframework.stereotype.Service;

@Service("impl2")
public class SaludoServiceImpl2 implements SaludoService{

	@Override
	public String getNombre() {
		return "Todo el Mundo";
	}
	
}
