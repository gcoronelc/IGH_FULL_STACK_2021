package com.igh.eurekaapp.prueba;

import com.igh.eurekaapp.dto.EmpleadoDto;
import com.igh.eurekaapp.service.CrudService;
import com.igh.eurekaapp.service.impl.CrudEmpleadoImpl;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba05 {

	public static void main(String[] args) {

		try {
			// Datos
			String empleado = "0003";
			// Proceso
			CrudService<EmpleadoDto> crudService = new CrudEmpleadoImpl();
			EmpleadoDto dto = crudService.findById(empleado);
			System.out.println("Nombre: " + dto.getNombre());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
