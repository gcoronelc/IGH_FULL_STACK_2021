package ejemplos;

import java.util.Scanner;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Practica3Problema5 {


	public static void main(String[] args) {
		// Variables
		int nota, bono;
		Scanner scanner = new Scanner(System.in);
		// Lectura
		System.out.println("");
		System.out.print("Nota (0 a 20): ");
		nota = scanner.nextInt();
		// Proceso
		bono = calcBono(nota);
		// Reporte
		System.out.println("");
		System.out.println("Bono: " + bono);
		System.out.println("");

	}

	private static int calcBono(int nota) {
		int bono, factor, rango;
		// Proceso: Inicio
		bono = 0;
		for (int i = 0; i < 4; i++) {
			// Inicializando variables
			factor = 0;
			rango = 0;
			// Determina rango y factor
			switch (i) {
				case 0:
					factor = 50;
					rango = (nota >= 5) ? 5 : nota;
					break;
				case 1:
					factor = 80;
					rango = (nota >= 7) ? 7 : nota;		
					break;
				case 2:
					factor = 120;
					rango = (nota >= 5) ? 5 : nota;		
					break;	
				case 3:
					factor = 500;
					rango = (nota >= 3) ? 3 : nota;		
					break;					
			}
			// Aplicando rango y factor
			bono += rango * factor;
			nota -= rango;
		}
		// Proceso: Fin
		return bono;
	}

}
