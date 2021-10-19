/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplos;

import java.util.Scanner;

/**
 *
 * @author 51925
 */
public class Pregunta2 {
    public static void main(String[] Args){
        //ANALISIS DE DATOS 
        double puntaje;
        String escuela;
        
       //LECTURA DE DATOS 
      
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el puntaje ");
        puntaje = scanner.nextDouble();
        
        
        
        //PROCESO
        escuela=asignarEscuela(puntaje);
        
        
      /* private static double porcentajeAumentoV3(double sueldo) {
		double porcentaje;
		porcentaje = 0.0;
		porcentaje = (sueldo > 5000) ? 0.1 : porcentaje;
		porcentaje = (sueldo > 3500 && sueldo <= 5000) ? 0.15 : porcentaje;
		porcentaje = (sueldo > 2000 && sueldo <= 3500) ? 0.20 : porcentaje;
		porcentaje = (sueldo > 0 && sueldo <= 2000) ? 0.25 : porcentaje;
		return porcentaje;
	}
         */
       //
        //SALIDA
        //System.out.print();
        
       
        
     
    }
     public static String asignarEscuela(double puntaje){
        String asignacion;
        asignacion = "";
        
        
        if (puntaje >0 &&puntaje > 50){
            asignacion = "Mecanica";
            
           
    
       }else if(puntaje > 60 && puntaje < 70){
           asignacion = "Industrial";
           
           
       }else if(puntaje > 70 && puntaje < 80){
           asignacion = "Electrònica";
          
          
       }else if(puntaje > 80){
           asignacion = "Sistemas";
          
          
       }else{
         System.out.print("No ingreso");
       }
        
       System.out.print(asignacion);
       return null;
   
        
    }
     
   
     
}