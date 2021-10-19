package ejercicio02;

import java.util.Scanner;

/**
 *
 * @author Dani Lucano
 */
public class Adicional {

	public static void main(String[] args) {
		// Variables
		Scanner entrada = new Scanner(System.in);
		double nota;
		String n;
		// Lectura
		do {
			System.out.print("Digite el puntaje: ");
			nota = entrada.nextDouble();
		} while (nota < 0);
		// Proceso
		n = nota(nota);
		// Reporte
		System.out.println(n);
	}

	static String nota(double nota) {
		return nota >= 80 && nota < 100 ? "sistemas" : nota >= 70 && nota < 80 ? "electronica" : nota >= 60 && nota < 70 ? "industrial" : nota >= 50 && nota < 60 ? "mecanica" : "no ingreso a ninguna escuela";
	}

}
