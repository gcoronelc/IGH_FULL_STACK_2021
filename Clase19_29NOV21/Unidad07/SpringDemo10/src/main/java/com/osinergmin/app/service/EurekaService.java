package com.osinergmin.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osinergmin.app.repository.EurekaRepository;
import com.osinergmin.app.repository.SPSaldoCuenta;

@Service
public class EurekaService {
	
	@Autowired
	private EurekaRepository eurekaRepository;
	
	@Autowired
	private SPSaldoCuenta spSaldoCuenta;
	
	public List<Map<String,Object>> traerMovimeinto(String cuenta) {
		return eurekaRepository.buscarMovimientos(cuenta);
	}
	
	public Map<String,Object> datosCuenta(String cuenta){
		return spSaldoCuenta.ejecutar(cuenta);
	}
}

