package com.igh.eurekaapp.prueba;

import com.igh.eurekaapp.service.CuentaService;
import com.igh.eurekaapp.service.impl.CuentaServiceImpl;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba03 {

	public static void main(String[] args) {

		try {
			// Datos
			String cuenta = "00100001";
			Double importe = 500.0;
			String clave = "123456";
			String empleado = "0003";
			// Proceso
			CuentaService cuentaService = new CuentaServiceImpl();
			cuentaService.procRetiro(cuenta, importe, clave, empleado);
			System.out.println("Proceso ok.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
