package ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Ejemplo15 {

    public static void main(String[] args) {
			
			String datos[] = {"Chiclayo","Cuzco", "Arequipa","Trujillo", "Huancayo"};
			
			List<String> ciudades = new ArrayList<>();
			Collections.addAll(ciudades, datos); 
			ciudades.add("Iquitos");
			ciudades.add("Amazonas");
			ciudades.add("Chachapoyas");
			
			for (int i = 0; i < ciudades.size(); i++) {
				System.out.println(ciudades.get(i));
			}
		
			System.out.println("------------------------------");
			for (String dato : ciudades) {
				System.out.println(dato);
			}
			
			
			System.out.println("------------------------------");
			ciudades.forEach(dato -> {
				System.out.println(dato);
			});
        
    }

}
