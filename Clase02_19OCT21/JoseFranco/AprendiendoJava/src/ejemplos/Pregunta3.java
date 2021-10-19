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
public class Pregunta3 {
    public static void main(String[] Args){
        //ANALISIS DE DATOS 
        double cantidad;
        double porcentaje;
        double pago;
        double precio;
        
        
       //LECTURA DE DATOS 
      
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad ");
        cantidad = scanner.nextDouble();
        
        
        System.out.print("Ingrese el precio ");
        precio = scanner.nextDouble();
        
        
        
        //PROCESO
        porcentaje = porcentajeDscto(cantidad);
        pago = calculandoDescto(precio,cantidad,porcentaje);
        
        
        
        
        
      
        //SALIDA
        //System.out.print();
        System.out.print("El total a pagar es"+pago+"Y el porcentaje de su descto es"+porcentaje);
      
    }
        public static double porcentajeDscto(double cantidad){
               double porcentaje;
               porcentaje = 0.0;
               porcentaje = (cantidad>36)? 0.75:porcentaje;
               porcentaje = (cantidad>24 && cantidad<36?0.9:porcentaje);
               porcentaje = (cantidad>12 && cantidad<24?0.95:porcentaje);
               porcentaje = (cantidad>0 && cantidad<12?1.0:porcentaje);
               return porcentaje;
               
        }
        
        public static double calculandoDescto(double precio ,double cantidad,double dscto){
            double total;
            
            total = (precio*cantidad)*dscto;
            return total;
            
            
        }
    
}
