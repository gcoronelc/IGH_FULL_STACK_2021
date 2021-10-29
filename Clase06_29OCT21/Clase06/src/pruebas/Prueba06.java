package pruebas;

import modelo.Matematica;
import modelo.Matematica1;
import modelo.Matematica2;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Prueba06 {

    public static void main(String[] args) {
		 
		 Matematica obj = new Matematica2();
		 
		 System.out.println("7 + 5 = " + obj.sumar(7, 5));
		 System.out.println("7 * 5 = " + obj.multiplicar(7, 5));
		 
		 Matematica1.class.isInstance(obj)
        
    }

}
