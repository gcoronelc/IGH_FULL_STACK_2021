package ejemplos;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Ejemplo13 {

	public static void main(String[] args) {

		int n = 5;
		long fact;
		for (fact = 1; n > 1; fact *= n--);
		System.out.println("Factorial: " + fact);

	}

}
