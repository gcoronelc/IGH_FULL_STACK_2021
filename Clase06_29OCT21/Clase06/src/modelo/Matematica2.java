package modelo;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Matematica2 extends Matematica{

	@Override
	public int sumar(int n1, int n2) {
		return ((n1 + n2) * (n1 - n2));
	}

}
