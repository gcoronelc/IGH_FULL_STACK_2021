package modelo;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public abstract class Matematica {

	public Matematica() {
		System.out.println("Hola Gustavo");
	}
	
	// Método concreto
	public int multiplicar(int n1, int n2){
		return (n1*n2);
	}

	// Método abstracto
	public abstract int sumar(int n1, int n2);
	
	
}
