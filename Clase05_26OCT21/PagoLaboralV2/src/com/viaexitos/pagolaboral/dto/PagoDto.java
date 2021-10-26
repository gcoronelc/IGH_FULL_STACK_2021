package com.viaexitos.pagolaboral.dto;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class PagoDto {

	// Datos
	private int horasDiarias;
	private int dias;
	private double pagoHora;
	// Resultado
	private double pagoTotal;
	private double retencion;
	private double pagoNeto;

	// Constructor por defecto
	public PagoDto() {
	}

	// Constructor adicional
	public PagoDto(int horasDiarias, int dias, double pagoHora) {
		this.horasDiarias = horasDiarias;
		this.dias = dias;
		this.pagoHora = pagoHora;
	}

	public int getHorasDiarias() {
		return horasDiarias;
	}

	public void setHorasDiarias(int horasDiarias) {
		this.horasDiarias = horasDiarias;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public double getPagoHora() {
		return pagoHora;
	}

	public void setPagoHora(double pagoHora) {
		this.pagoHora = pagoHora;
	}

	public double getPagoTotal() {
		return pagoTotal;
	}

	public void setPagoTotal(double pagoTotal) {
		this.pagoTotal = pagoTotal;
	}

	public double getRetencion() {
		return retencion;
	}

	public void setRetencion(double retencion) {
		this.retencion = retencion;
	}

	public double getPagoNeto() {
		return pagoNeto;
	}

	public void setPagoNeto(double pagoNeto) {
		this.pagoNeto = pagoNeto;
	}

}
