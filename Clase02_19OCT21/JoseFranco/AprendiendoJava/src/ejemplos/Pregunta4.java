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
public class Pregunta4 {
      public static void main(String[] Args){
        //ANALISIS DE DATOS 
        double km;
        double peso;
        double costo;
        double total;
        
       //LECTURA DE DATOS 
      
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de km ");
        km = scanner.nextDouble();
        
        
        System.out.print("Ingrese el peso ");
        peso = scanner.nextDouble();
        
        
        
        //PROCESO
        costo = asignarCosto(peso);
        total = calculandoTotal(km,costo);
        
        
        
        
        
        
      
        //SALIDA
        //System.out.print();
        System.out.print("El total a pagar es"+total+"Y el costo por peso  es"+costo);
      
    }
        public static double asignarCosto(double peso){
               double costo;
               costo = 0.0;
               costo = (peso>=10)? 4:costo;
               costo = (peso>=5 && peso<10?6:costo);               
               costo = (peso>=1.5 && peso<5?8:costo);
               return costo;
               
        }
        
        public static double calculandoTotal(double km,double costo){
            double total;
            
            total = km*costo;
            return total;
            
            
        }
    
}
