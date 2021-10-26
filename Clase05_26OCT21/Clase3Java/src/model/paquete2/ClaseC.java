package model.paquete2;

import model.paquete1.ClaseA;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class ClaseC extends ClaseA{
	
	public void mostrar(){
		System.out.println("c = " + this.c);
		
		ClaseA o = new ClaseA();
		System.out.println(o.obtenerSaludo());
	}
	
	public static void main(String[] args) {
		ClaseC obj = new ClaseC();
		obj.mostrar();
	}

}
