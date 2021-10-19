package ejercicio05;

import java.util.Scanner;

/**
 *
 * @author Oliver
 */
public class Ejercicio05 {

	public static void main(String[] args) {
		//Variables
		Scanner scanner = new Scanner(System.in);
		double pagoPorHora;
		double horasTrabajadas;
		double horasExtras;
		double pagoHorasExtras;
		double sueldoNeto;
		// Lectura
		System.out.print("Pago por hora: ");
		pagoPorHora = scanner.nextDouble();
		System.out.print("Horas trabajadas: ");
		horasTrabajadas = scanner.nextDouble();
		// Proceso
		horasExtras = calcularHorasExtras(horasTrabajadas);
		pagoHorasExtras = calcularPagoHorasExtras(pagoPorHora, horasExtras);
		sueldoNeto = calcularSueldoNeto(pagoPorHora, horasTrabajadas, pagoHorasExtras);
		// Reporte
		System.out.println("-------------------------------------");
		System.out.println("Sueldo básico: " + pagoPorHora * horasTrabajadas);
		System.out.println("Horas Extras: " + horasExtras);
		System.out.println("Pago por Horas Extras: " + pagoHorasExtras);
		System.out.println("Sueldo Neto: " + sueldoNeto);
	}

	private static double calcularHorasExtras(double horasTrabajadas) {
		double horasExtras;
		horasExtras = 0;
		horasExtras = (horasTrabajadas > 40) ? horasTrabajadas - 40 : horasExtras;
		return horasExtras;
	}

	private static double calcularPagoHorasExtras(double pagoPorHora, double horasExtras) {
		double pago;
		pago = (pagoPorHora * 0.5) * horasExtras;
		return pago;
	}

	private static double calcularSueldoNeto(double pagoPorHora, double horasTrabajadas, double pagoHorasExtras) {
		double sueldo;
		sueldo = pagoPorHora * horasTrabajadas + pagoHorasExtras;
		sueldo = (sueldo > 2000) ? sueldo - (sueldo * 0.08) : sueldo;
		return sueldo;
	}

}
