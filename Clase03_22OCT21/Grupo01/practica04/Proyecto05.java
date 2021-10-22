/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica04;

import java.util.Arrays;

/**
 *
 * @author angie
 */
public class Proyecto05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Variable
        int[][] matriz = new int[4][3];
        int arreglo[] = new int[3];

        // Lectura
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = (int) ((Math.random() * 21) + 10);
            }
        }
        // Proceso

        arreglo = sumaDatos(matriz);
        // Reporte

        for (int i = 0; i < matriz.length; i++) {
            
            for (int j = 0; j < matriz[0].length; j++) {
                
                System.out.print(matriz[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.print("Suma: ");
        System.out.println(Arrays.toString(arreglo));
    }

    private static int[] sumaDatos(int[][] matriz) {
        int suma[] = new int[3];
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                suma[i] += matriz[j][i];
            }
        }
        return suma;
    }
}
