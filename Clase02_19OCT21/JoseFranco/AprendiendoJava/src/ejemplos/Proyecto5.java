/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplos;
/**
 *
 * @author 51925
 */
import java.util.Scanner;
public class Proyecto5 {
    public static void main(String[] args) {
        //Variables
        Scanner scanner = new Scanner(System.in);
        double pagoPorHora;
        double horasTrabajadas;
        double horasExtras;
        double pagoHorasExtras;
        double sueldoNeto;
        //Lectura
        System.out.println("Pago por hora: ");
        pagoPorHora = scanner.nextDouble();
        System.out.println("Horas trabajadas: ");
        horasTrabajadas = scanner.nextDouble();
        //Salida
        horasExtras = calcularHorasExtras(horasTrabajadas);
        pagoHorasExtras = calcularPagoHorasExtras(pagoPorHora, horasExtras);
        sueldoNeto = calcularSueldoNeto(pagoPorHora, horasTrabajadas, pagoHorasExtras);
        System.out.println("-------------------------------------");
        System.out.println("Sueldo básico: "+pagoPorHora*horasTrabajadas);
        System.out.println("Horas Extras: "+horasExtras);
        System.out.println("Pago por Horas Extras: "+pagoHorasExtras);
        System.out.println("Sueldo Neto: "+sueldoNeto);
    }
     
    private static double calcularHorasExtras(double horasTrabajadas){
        double horasExtras;
        horasExtras = 0;
        horasExtras = (horasTrabajadas>40)?horasTrabajadas-40:horasExtras;
        return horasExtras;
    }
    
    private static double calcularPagoHorasExtras(double pagoPorHora, double horasExtras){
        double pago;
        pago = (pagoPorHora*0.5)*horasExtras;
        return pago;
    }
    
    private static double calcularSueldoNeto(double pagoPorHora,double horasTrabajadas,double pagoHorasExtras){
        double sueldo;
        sueldo = pagoPorHora*horasTrabajadas+pagoHorasExtras;
        sueldo = (sueldo>2000)?sueldo-(sueldo*0.08):sueldo;
        return sueldo;           
    }      
}