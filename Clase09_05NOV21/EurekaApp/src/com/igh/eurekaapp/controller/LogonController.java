package com.igh.eurekaapp.controller;

import com.igh.eurekaapp.dto.EmpleadoDto;
import com.igh.eurekaapp.service.LogonService;
import com.igh.eurekaapp.service.impl.LogonServiceImpl;
import com.igh.eurekaapp.util.Session;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class LogonController {

	public void validar(String usuario, String clave) {
		LogonService logonService = new LogonServiceImpl();
		EmpleadoDto dto = logonService.validar(usuario, clave);
		Session.put("USUARIO", dto);
	}
}
