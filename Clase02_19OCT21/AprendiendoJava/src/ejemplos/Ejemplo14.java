package ejemplos;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Ejemplo14 {

	public static void main(String[] args) {
		
		int datos[] = {54, 67, 23, 45, 67, 98};
		
		System.out.println("Recorrido indexado");
		for (int i = 0; i < datos.length; i++) {
			int dato = datos[i];
			System.out.println(dato);
		}
		
		System.out.println("Recorrido tipo colección");
		for (int dato : datos) {
			System.out.println(dato);
		}
		
	}

}
