package ejemplos;

import java.util.Scanner;
				
/**
 *
 * @author Josefranco
 */
public class Pregunta1 {

	public static void main(String[] Args) {
		//ANALISIS DE DATOS 
		double pv;
		double pc;
		String condicion;
		double gan;

		//LECTURA DE DATOS   
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese el Precio de Venta ");
		pv = scanner.nextDouble();

		System.out.print("Ingrese el Precio de Costo ");
		pc = scanner.nextDouble();

		//PROCESO
		gan = calcularGanacias(pv, pc);
		condicion = asignarCondicionV2(gan, pc);

		//SALIDA
		System.out.print(condicion);

	}

	public static double calcularGanacias(double pv, double pc) {
		double gan;
		gan = pv - pc;
		return gan;

	}

	public static String asignarCondicionV2(double gan, double pc) {
		String condicion;
		condicion = "";
		condicion = (gan > pc * 0.5) ? "CARO" : condicion;
		condicion = (gan < pc * 0.5) ? "BARATO" : condicion;
		return condicion;
	}
	/*
    public  static String asignarCondicion(double gan,double pc){
        String condicion;
        
        if (gan > pc*0.5){
            condicion = "CARO"; 
            
        }else{
            condicion = "BARATO";
            
        }
        return condicion;
                     
    }
    
	 */
}
