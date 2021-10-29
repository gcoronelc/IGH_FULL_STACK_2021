package modelo;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class MatematicaService implements IMatematica {

	@Override
	public int sumar(int... datos) {
		int suma = 0;
		for (int dato : datos) {
			suma += dato;
		}
		return suma;
	}

	@Override
	public long factorial(int n) {
		long f = 1;
		for (int i = 2; i < n; i++) {
			f *= i;
		}
		return f;
	}

}
