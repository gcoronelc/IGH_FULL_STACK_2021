package com.desarrollasoftware.app.service;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("impl2")
@Qualifier("rol2")
public class SaludoServiceImpl2 implements SaludoService{

	@Override
	public String getNombre() {
		return "Todo el Mundo";
	}
	
	@PostConstruct
	public void initBean() {
		System.out.println("Bean iniciado.");
	}

	@PreDestroy
	public void resetBean() {
		System.out.println("Bean listo para ser destruido.");
	}

}
