/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viaexitos.pagolaboralservice;

import com.viaexitos.pagolaboral.dto.PagoDto;

/**
 *
 * @author Ben
 */
public class PagoLaboralService {

	public double calcularPago(int horas, int dias, double pph) {
		double pago;
		pago = horas * dias * pph;
		return pago;
	}

	public double calculoImpuesto(double ingreso) {
		double impuesto = 0;
		impuesto = ingreso > 1500 ? ingreso * 0.08 : 0;
		return impuesto;
	}
	
	public PagoDto procesarPago(PagoDto dto){
		// Variables
		double pagoTotal, retencion, pagoNeto;
		// Proceso
		pagoTotal = dto.getDias() * dto.getHorasDiarias() * dto.getPagoHora();
		retencion = pagoTotal * (pagoTotal>1500.0?0.08:0.0);
		pagoNeto = pagoTotal - retencion;
		// Reporte
		dto.setPagoTotal(pagoTotal);
		dto.setRetencion(retencion);
		dto.setPagoNeto(pagoNeto);
		return dto;
	}

}
