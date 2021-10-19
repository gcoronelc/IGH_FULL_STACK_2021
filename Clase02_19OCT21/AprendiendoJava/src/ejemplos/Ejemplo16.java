package ejemplos;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Ejemplo16 {

    public static void main(String[] args) {
			
			for (int i = 0; i <= 10; i++) {
				if(i==4){
					continue;
				}
				System.out.println("i = " + i);
				if(i==7){
					break;
				}
			}
			System.out.println("Chau bucle.");
        
    }

}
