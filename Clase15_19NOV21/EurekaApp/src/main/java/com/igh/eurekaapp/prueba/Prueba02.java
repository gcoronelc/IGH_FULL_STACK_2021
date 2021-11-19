package com.igh.eurekaapp.prueba;

import com.igh.eurekaapp.dto.EmpleadoDto;
import com.igh.eurekaapp.service.LogonService;
import com.igh.eurekaapp.service.impl.LogonServiceImpl;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba02 {
	
	public static void main(String[] args) {
		try {
			String usuario = "cromero";
			String clave = "chichoz";
			
			LogonService logonService = new LogonServiceImpl();
			EmpleadoDto dto = logonService.validar(usuario, clave);
			
			System.out.println("Hola " + dto.getPaterno());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
