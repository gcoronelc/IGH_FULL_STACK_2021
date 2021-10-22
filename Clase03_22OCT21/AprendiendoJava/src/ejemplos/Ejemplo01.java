package ejemplos;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Ejemplo01 {

	public static void main(String[] args) {

		int notas[];

		notas = new int[5]; // Un objeto arreglo
		notas[0] = 18;
		notas[1] = 15;

		for (int nota : notas) {
			System.out.println(nota);
		}

		notas = new int[8]; // Otro objeto arreglo

		System.out.println("-----------------------------");
		for (int nota : notas) {
			System.out.println(nota);
		}
		
	}

}
