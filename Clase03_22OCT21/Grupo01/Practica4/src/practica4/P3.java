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
public class P3 {
    public static void main(String[] args) {
        int[] arr=new int[10];
        Random rand = new Random();
        int par=0, impar=0;
        
        for(int i=0;i<10;i++){
        arr[i]=rand.nextInt(50-10+1)+10;
        int useless=arr[i]%2==0?par++:impar++;
        }
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("Pares: "+par+"\nImpares: "+impar);
    }
}
