package pe.com.igh.pedidoapp.prueba;

import pe.com.igh.pedidoapp.service.PedidoService;

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
		// Variables
		double importe, impuesto, total;
		// Datos
		importe = 1000;
		// Proceso
		PedidoService service = new PedidoService();
		impuesto = service.calcularImpuesto(importe);
		total = service.calcularTotal(importe);
		// Reporte
		System.out.println("Importe: " + importe);
		System.out.println("Impuesto: " + impuesto);
		System.out.println("Total: " + total);
	}

}
