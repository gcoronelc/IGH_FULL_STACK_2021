package prueba;

import modelo.Clase1;
import modelo.Clase2;
import modelo.Clase3;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba01 {

	public static void main(String[] args) {
		
		
		Object o1 = new Clase2(); // Upcasting
		Clase1 o2 = (Clase1) o1; // DownCasting
		Clase2 o3 = (Clase2) o2; // DownCasting
		
		Clase3 o4 = (Clase3) o3; // Error
		
		System.out.println("Hola");

	}

}
