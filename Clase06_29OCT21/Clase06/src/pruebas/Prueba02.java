package pruebas;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Prueba02 {

	// Esta variable recien existe en el objeto.
	private static String nombre = "Gustavo";
	
	// Inicializador estático
	static {
		nombre = "José Gustavo";
	}

	// El metodo main tiene alcance de clase
	public static void main(String[] args) {
		saludo();
		System.out.println("Nombre: " + nombre);
	}
	
	// Esta metodo recien existe en el objeto.
	static void saludo(){
		System.out.println("Hola todos.");
	}

}
