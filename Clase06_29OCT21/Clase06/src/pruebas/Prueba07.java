package pruebas;

import modelo.IMatematica;
import modelo.MatematicaService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Prueba07 {

    public static void main(String[] args) {
		 
		 IMatematica obj = new MatematicaService();
		 
		 System.out.println("Suma: " + obj.sumar(5,6,7,8));
		 System.out.println("Factorial: " + obj.factorial(6));
		 
		 IMatematica.NOMBRE = "Angel";
		 System.out.println("Nombre: " + IMatematica.NOMBRE);
        
    }

}
