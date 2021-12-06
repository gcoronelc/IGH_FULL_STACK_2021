package com.osinergmin.app.service;

import java.util.List;
import java.util.Map;


public interface ReporteService {
	
	List<Map<String, ?>> traerCategorias();
	
	List<Map<String, ?>> traerProductos( Long categoria );

}

