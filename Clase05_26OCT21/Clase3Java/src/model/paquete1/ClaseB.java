package model.paquete1;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class ClaseB {
	
	public void mostrarSaludo(){
		ClaseA obj = new ClaseA();
		System.out.println(obj.saludo);
	}
	
	public static void main(String[] args) {
		ClaseB o = new ClaseB();
		o.mostrarSaludo();
	}

}
