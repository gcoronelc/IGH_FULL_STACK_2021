package model.paquete1;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class ClaseA {

	private int a = 10;
	protected int c = 30;

	String saludo = "Hola Gustavo";

	public String obtenerSaludo() {
		return saludo;
	}

	// Constructor por defecto
	public ClaseA() {
		this.saludo = "Hola todos";
		System.out.println("Objeto de tipo ClaseA creado.");
	}

	@Override
	protected void finalize() throws Throwable {
		System.err.println("Chau objeto de tipo ClaseA.");
	}

}
