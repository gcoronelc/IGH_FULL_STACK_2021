package ejemplos;

import java.util.Scanner;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Ejemplo01 {

	public static void main(String[] args) {
		// Variables
		Scanner scanner = new Scanner(System.in);
		double sueldo, porcentaje, nuevoSueldo;
		// Lectura
		System.out.println("LECTURA");
		System.out.print("Sueldo: ");
		sueldo = scanner.nextDouble();
		// Proceso
		porcentaje = porcentajeAumento(sueldo);
		nuevoSueldo = sueldo + sueldo * porcentaje;
		// Reporte
		System.out.println("");
		System.out.println("REPORTE");
		System.out.println("Nuevo sueldo: " + nuevoSueldo);
	}

	// Stefano Tamayo
	private static double porcentajeAumentoV1(double sueldo) {
		return sueldo <= 3500 ? sueldo <= 2000 ? 0.25 : 0.2 : sueldo <= 5000 ? 0.15 : 0.1;
	}

	private static double porcentajeAumentoV2(double sueldo) {
		return sueldo > 5000 ? 0.1 : sueldo > 3500 ? 0.15 : sueldo > 200 ? 0.10 : 0.25;
	}

	private static double porcentajeAumentoV3(double sueldo) {
		double porcentaje;
		porcentaje = 0.0;
		porcentaje = (sueldo > 5000) ? 0.1 : porcentaje;
		porcentaje = (sueldo > 3500 && sueldo <= 5000) ? 0.15 : porcentaje;
		porcentaje = (sueldo > 2000 && sueldo <= 3500) ? 0.20 : porcentaje;
		porcentaje = (sueldo > 0 && sueldo <= 2000) ? 0.25 : porcentaje;
		return porcentaje;
	}

	private static double porcentajeAumento(double sueldo) {
		double porcentaje;
		if (sueldo > 5000) {
			porcentaje = 0.10;
		} else if (sueldo > 3500) {
			porcentaje = 0.15;
		} else if (sueldo > 2000) {
			porcentaje = 0.20;
		} else if (sueldo > 0) {
			porcentaje = 0.25;
		} else {
			porcentaje = 0.0;
		}
		return porcentaje;
	}

}
