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
public class P1 {
    public static void main(String[] args) {
        int[] arr1=new int[10];
        int[] arr2=new int[10];
        int[] arr3=new int[10];
        Random rand = new Random();
        for(int i=0;i<10;i++){
        arr1[i]=rand.nextInt(50-10+1)+10;
        arr2[i]=rand.nextInt(50-10+1)+10;
        arr3[i]=arr1[i]+arr2[i];
        }
        
        System.out.println("Arreglo1: "+Arrays.toString(arr1));
        System.out.println("Arreglo2: "+Arrays.toString(arr2));
        System.out.println("Arreglo3: "+Arrays.toString(arr3));
    }
}