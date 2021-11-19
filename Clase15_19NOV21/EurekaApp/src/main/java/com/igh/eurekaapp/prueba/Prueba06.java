package com.igh.eurekaapp.prueba;

import com.igh.eurekaapp.dto.EmpleadoDto;
import com.igh.eurekaapp.service.CrudService;
import com.igh.eurekaapp.service.impl.CrudEmpleadoImpl;
import java.util.List;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba06 {

	public static void main(String[] args) {

		try {
			// Datos
			List<EmpleadoDto> lista;
			// Proceso
			CrudService<EmpleadoDto> crudService = new CrudEmpleadoImpl();
			lista = crudService.findAll();
			for (EmpleadoDto dto : lista) {
				System.out.println("Nombre: " + dto.getNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
