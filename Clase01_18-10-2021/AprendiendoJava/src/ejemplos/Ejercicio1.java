package ejemplos;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// Variables
		Scanner scanner = new Scanner(System.in);
		int practicas[] = new int[4];
		int promPracticas, promFinal, ep, ef;
		String condicion;
		// Lectura de notas
		for (int i = 0; i < 4; i++) {
			System.out.print("Ingrese practica " + i + ": ");
			practicas[i] = scanner.nextInt();
		}
		System.out.print("Examen parcial: ");
		ep = scanner.nextInt();
		System.out.print("Examen final: ");
		ef = scanner.nextInt();
		// Proceso
		promPracticas = calcPromPracticas(practicas);
		promFinal = calcPromedioFinal(promPracticas, ep, ef);
		condicion = calcCondicion(promFinal);
		// Reporte
		System.out.println("");
		System.out.println("REPORTE");
		System.out.println("Promedio de practicas: " + promPracticas);
		System.out.println("Promedio final: " + promFinal);
		System.out.println("Condicion: " + condicion);
	}

	private static int calcPromPracticas(int practicas[]) {
		int suma;
		Arrays.sort(practicas);
		suma = 0;
		for (int i = 1; i < practicas.length; i++) {
			suma += practicas[i];
		}
		return suma / (practicas.length - 1);
	}

	private static int calcPromedioFinal(int promPracticas, int ep, int ef) {
		int pf;
		pf = (promPracticas + ep + ef) / 3;
		return pf;
	}

	private static String calcCondicion(int promFinal) {
		String condicion;
		condicion = "En proceso.";
		return condicion;
	}

}
