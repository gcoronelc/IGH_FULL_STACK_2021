package com.desarrollasoftware.app.service;

import org.springframework.stereotype.Service;

import com.desarrollasoftware.app.dto.VentaDto;

@Service
public class VentaService {

	public VentaDto procesar(VentaDto dto) {
		// Variables
		double importe, impuesto, total;
		// Proceso
		total = dto.getPrecio() * dto.getCantidad();
		importe = total / 1.18;
		impuesto = total - importe;
		// Reporte
		dto.setImporte(importe);
		dto.setImpuesto(impuesto);
		dto.setTotal(total);
		return dto;
	}

}
