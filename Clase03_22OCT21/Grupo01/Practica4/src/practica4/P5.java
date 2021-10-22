/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Stefano
 */
public class P5 {
    
    static int[][] matriz = new int[4][3];
    static int[] suma=new int[3];
    
    static void llenarMatriz(){
        Random rand=new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j]=rand.nextInt(30-10+1)+10;
                suma[j]+=matriz[i][j];
            }
        }
    }
    
    public static void main(String[] args) {
        llenarMatriz();
        
        System.out.println("Matriz:");
        for (int[] filas : matriz) {
            System.out.print("       ");
            System.out.println(Arrays.toString(filas));
        }
        System.out.println("Suma:  "+Arrays.toString(suma));
        
    }
}
