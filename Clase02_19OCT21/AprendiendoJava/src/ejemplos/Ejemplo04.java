package ejemplos;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Ejemplo04 {

	public static void main(String[] args) {

		String dato = "1234";

		int numero = Integer.parseInt(dato);

		System.out.println("numero: " + numero);

		Persona obj = new Persona();
		obj.nombre = "Delia";
		obj.edad = 25;
		String empleado = new String("Jorge");
		
		asignarDatos(obj);
		cambiarNombre(empleado);
		
		System.out.println(obj.nombre + " - " + obj.edad);
		System.out.println("Empleado " + empleado);

	}

	private static void asignarDatos(Persona obj) {
		obj.nombre = "Gustavo";
		obj.edad = 40;
	}

	private static void cambiarNombre(String empleado) {
		empleado = "Claudia";
	}

}

class Persona {

	public String nombre;
	public int edad;
}
