package ejemplos;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Ejemplo02 {

    public static void main(String[] args) {
		 
		 Object algo[] = new Object[5];
		 
		 algo[0] = 2345;
		 algo[1] = 2345.234;
		 algo[2] = "Gustavo";
		 algo[3] = new Random();
		 algo[4] = new ArrayList<>();
		 
		 for (Object object : algo) {
			 System.out.println(object.getClass());
		 }
        
    }

}
