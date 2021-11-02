package modelo;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Matematica1 extends Matematica{

	// Obligado a implementar
	@Override
	public int sumar(int n1, int n2) {
		return (n1+n2);
	}

	// Redefinición
	@Override
	public int multiplicar(int n1, int n2) {
		return super.multiplicar(n1, n2); //To change body of generated methods, choose Tools | Templates.
	}
	
	

}
