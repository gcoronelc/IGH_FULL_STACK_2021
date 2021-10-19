package ejercicio02;

import java.util.Scanner;

/**
 *
 * @author Dani Lucano
 */
public class Ejercicio02 {

	public static void main(String[] args) {
		// Variables
		Scanner entrada = new Scanner(System.in);
		double nota;
		// Lectura
		do {
			System.out.print("Digite el puntaje: ");
			nota = entrada.nextDouble();
		} while (nota < 0);
		// Proceso y reporte
		if (nota > 49) {
			if (nota >= 50 && nota < 60) {
				System.out.println("El estudiante ingreso a Mecanica");
			}
			if (nota >= 60 && nota < 70) {
				System.out.println("El estudiante ingreso a industrial");
			}
			if (nota >= 70 && nota < 80) {
				System.out.println("El estudiante ingreso a electronica");
			}
			if (nota >= 80 && nota < 100) {
				System.out.println("El estudiante ingreso a sistemas");
			}
		} else {
			System.out.println("No ingreso a ninguna escuela");
		}

	}

}
