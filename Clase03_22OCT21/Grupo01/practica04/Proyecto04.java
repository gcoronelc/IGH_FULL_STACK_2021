/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica04;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author angie
 */
public class Proyecto04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Variable
        Scanner scanner = new Scanner(System.in);
        int n;
        double mediana, media;

        // Lectura
        System.out.print("Ingrese la cantidad de numeros del arreglo :");
        n = scanner.nextInt();
        int[] arreglo = new int[n];

        for (int i = 0; i < n; i++) {
            //System.out.println("Ingrese el valor :");
            //arreglo[i] = scanner.nextInt();

            arreglo[i] = (int) (Math.random() * 10 + 1);
        }

        // Proceso
        mediana = calMediana(arreglo);
        media = calMedia(arreglo, n);

        //Reporte
        System.out.println(Arrays.toString(arreglo));
        System.out.println("La media es :" + media);
        System.out.println("La mediana es :" + mediana);
    }

    private static double calMediana(int[] arreglo) {
        int posicion = arreglo.length / 2;
        double media;
        Arrays.sort(arreglo);

        if ((arreglo.length % 2) == 0) {
            media = 1.0 * (arreglo[posicion] + arreglo[posicion - 1]) / 2;
        } else {
            media = arreglo[posicion];
        }

        return media;
    }

    private static double calMedia(int[] arreglo, int n) {
        double med = 0;
        double suma = 0;

        for (int i = 0; i < n; i++) {
            suma += arreglo[i];
        }

        med = 1.0 * suma / arreglo.length;

        return med;
    }

}
