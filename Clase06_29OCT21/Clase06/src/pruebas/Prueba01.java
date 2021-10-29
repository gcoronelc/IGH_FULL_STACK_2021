package pruebas;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Prueba01 {

	// Esta variable recien existe en el objeto.
	private String nombre;

	// El metodo main tiene alcance de clase
	public static void main(String[] args) {
		Prueba01 o = new Prueba01();
		o.saludo();
		
		//System.out.println("Nombre: " + nombre);
		
	}
	
	// Esta metodo recien existe en el objeto.
	public void saludo(){
		System.out.println("Hola todos.");
	}

}
