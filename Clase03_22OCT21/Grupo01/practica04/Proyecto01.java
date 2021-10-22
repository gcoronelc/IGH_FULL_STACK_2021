/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica04;

/**
 *
 * @author angie
 */
public class Proyecto01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Variables
        int arreglo1[] = new int[10];
        int arreglo2[] = new int[10];
        int arreglo3[] = new int[10];
        // Lectura 
        for (int i = 0; i < 10; i++) {
            arreglo1[i] = (int)(Math.random()*99 + 1);
            arreglo2[i] = (int)(Math.random()*99 + 1);
        }
        
        // Proceso 
        arreglo3 = sumaDeArreg(arreglo1, arreglo2);
        
        // Reporte
        System.out.println("El arreglo es: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(arreglo1[i]+ " " + arreglo2[i]+ " " + arreglo3[i]);
        } 
    }

    private static int[] sumaDeArreg(int[] arreglo1, int[] arreglo2) {
    int suma[] = new int[10];
        for (int i = 0; i < 10; i++) {
            
            suma[i] = arreglo1[i]+arreglo2[i];
        }
        return suma;    
    }
    
}
