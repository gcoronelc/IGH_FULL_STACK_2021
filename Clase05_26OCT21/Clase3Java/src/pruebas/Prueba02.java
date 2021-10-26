package pruebas;

import model.MateService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Prueba02 {

    public static void main(String[] args) {
		 
		 MateService service = new MateService();
		 
		 System.out.println("7 + 8 = " + service.sumar(7, 8));
		 System.out.println("7.0 + 8 = " + service.sumar(7.0, 8));
        
    }

}
