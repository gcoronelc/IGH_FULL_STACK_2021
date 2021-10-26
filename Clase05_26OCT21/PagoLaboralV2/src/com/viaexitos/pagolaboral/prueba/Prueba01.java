package com.viaexitos.pagolaboral.prueba;

import com.viaexitos.pagolaboral.dto.PagoDto;
import com.viaexitos.pagolaboralservice.PagoLaboralService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Prueba01 {

    public static void main(String[] args) {
       // Datos
		 PagoDto dto = new PagoDto(5, 20, 135.0);
		 // Proceso
		 PagoLaboralService service = new PagoLaboralService();
		 dto = service.procesarPago(dto);
		 // Reporte
		 System.out.println("Pago total: " + dto.getPagoTotal());
		 System.out.println("Retención: " + dto.getRetencion());
		 System.out.println("Pago neto: " + dto.getPagoNeto());
		 
    }

}
