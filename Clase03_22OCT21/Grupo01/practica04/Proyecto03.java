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
public class Proyecto03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Variables
        int arreglo[] = new int[10];
        int impares, pares;
        // Lectura 
        for (int i = 0; i < 10; i++) {
            arreglo[i] = (int) ((Math.random() * 31) + 20);
        }

        // Proceso
        impares = contadorImpares(arreglo);
        pares = contadorPares(arreglo);
        // Reporte
        System.out.println("El arreglo es: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(arreglo[i]);
        }
        System.out.println("Hay " + pares + " numeros pares");
        System.out.println("Hay " + impares + " numeros impares");
    }

    private static int contadorImpares(int[] arreglo) {
        int impar = 0;
        for (int var : arreglo) {
            if ((var % 2) != 0) {
                impar++;
            }
        }
        return impar;
    }

    private static int contadorPares(int[] arreglo) {
        int par = 0;

        for (int var : arreglo) {
            if ((var % 2) == 0) {
                par++;
            }
        }

        return par;
    }

}
