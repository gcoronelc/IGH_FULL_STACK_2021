package com.igh.eurekaapp.service;

import java.util.List;
import java.util.Map;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public interface CuentaService {

	public void procRetiro(String cuenta, Double importe, String clave, String empleado);
	
	public void procDeposito(String cuenta, Double importe, String empleado);
	
	public List<Map<String,?>> conMovimientos(String cuenta);
	
}
