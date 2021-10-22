/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Stefano
 */
public class P4 {
    public static void main(String[] args) {
        //Falta acabar mediana y cantidad de elementos ingresada por el usuario
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.println("¿Cuantos elementos desea que tenga el arreglo?: ");
        int n=scan.nextInt();
        
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
        arr[i]=rand.nextInt(50-10+1)+10;
        }
        
        //Mediana
        Arrays.sort(arr);
        int mitad=n/2;
        double mediana=n%2==0?(arr[mitad]+arr[mitad-1])/2.0:arr[mitad];
        
        //Promedio
        double media= Arrays.stream(arr).average().getAsDouble();
        
        //Imprimir
        System.out.println("Arreglo de "+n+" elementos");
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("Mediana: "+mediana);
        System.out.println("Media: "+media);
    }
}
