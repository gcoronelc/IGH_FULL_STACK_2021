package com.igh.eurekaapp.prueba;

import com.igh.eurekaapp.controller.CuentaController;
import java.io.InputStream;
import java.util.*;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba08 {

	public static void main(String[] args) {
		Prueba08 bean = new Prueba08();
		bean.ejecutar();
	}

	public void ejecutar() {
		try {
			// Dato
			String cuenta = "00100001";
			// Proceso
			CuentaController control = new CuentaController();
			List<Map<String, ?>> lista = control.conMovimientos(cuenta);
			// Preparar reporte
			JRMapCollectionDataSource data = new JRMapCollectionDataSource(lista);
			Map pars = new HashMap();
			String reporte = "/reportes/ReporteMovimientos.jrxml";
			InputStream is = getClass().getResourceAsStream(reporte);
			if (is == null) {
				throw new RuntimeException("No carga el reporte.");
			}
			JasperReport rep = JasperCompileManager.compileReport(is);
			JasperPrint print = JasperFillManager.fillReport(rep, pars, data);
			// Mostrar Reporte
			JasperViewer viewer = new JasperViewer(print, false);
			viewer.setTitle("Mi Reporte");
			viewer.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
