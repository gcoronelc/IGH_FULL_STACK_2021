/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba03 {

	public static void main(String[] args) {
		try {
			int a = 10;
			int b = 0;
			
			int c = dividir(a, b);
			
			System.out.println("c = " + c);
		} catch (Exception ex) {
			Logger.getLogger(Prueba03.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private static int dividir(int a, int b) throws Exception {
		if (b == 0) {
			throw new Exception("No se puede dividir por cero.");
		}
		return (a / b);
	}

}
