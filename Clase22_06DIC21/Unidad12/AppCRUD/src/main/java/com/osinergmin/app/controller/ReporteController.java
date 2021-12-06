package com.osinergmin.app.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.osinergmin.app.service.ReporteService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

@Controller
@RequestMapping("/reportes")
public class ReporteController {
	
	@Autowired
	private ReporteService reporteService;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@GetMapping("/pagCategorias")
	public String paginaCategorias() {
		return "reportes/categorias";
	}
	
	@GetMapping("/pagProductos")
	public String paginaProductos() {
		return "reportes/productos";
	}
	
	
	@GetMapping("categorias1")
	public void categorias1(HttpServletResponse response) {
		try {
			// Data
			List<Map<String,?>> lista = reporteService.traerCategorias();
			JRMapCollectionDataSource data = new JRMapCollectionDataSource(lista);
			// Objeto JasperReport
			String reporte = "classpath:reports/Categorias.jrxml";
			String path = resourceLoader.getResource(reporte).getURI().getPath();
			JasperReport jasperReport = JasperCompileManager.compileReport(path);
			// Ejecutar el reporte
			byte[] bytes = JasperRunManager.runReportToPdf(jasperReport, null, data);
			// Enviar PDF
			enviarPDF(response, bytes);
		} catch (Exception e) {
		}
	}
	

	@GetMapping("categorias2")
	public void categorias2(HttpServletResponse response) {
		try {
			// Data
			List<Map<String,?>> lista = reporteService.traerCategorias();
			JRMapCollectionDataSource data = new JRMapCollectionDataSource(lista);
			// Objeto JasperReport
			String reporte = "classpath:reports/Categorias.jrxml";
			String path = resourceLoader.getResource(reporte).getURI().getPath();
			JasperReport jasperReport = JasperCompileManager.compileReport(path);
			// Ejecutar el reporte
			byte[] bytes = JasperRunManager.runReportToPdf(jasperReport, null, data);
			// Enviar PDF
			descargarPDF(response, bytes, "CATEGORIAS.PDF");
		} catch (Exception e) {
		}
	}
	
	
	@GetMapping("productos1")
	public void productos1(@RequestParam("categoria") Long categoria, HttpServletResponse response) {
		try {
			// Data
			List<Map<String,?>> lista = reporteService.traerProductos(categoria);
			JRMapCollectionDataSource data = new JRMapCollectionDataSource(lista);
			// Objeto JasperReport
			String reporte = "classpath:reports/Productos.jrxml";
			String path = resourceLoader.getResource(reporte).getURI().getPath();
			JasperReport jasperReport = JasperCompileManager.compileReport(path);
			// Ejecutar el reporte
			byte[] bytes = JasperRunManager.runReportToPdf(jasperReport, null, data);
			// Enviar PDF
			enviarPDF(response, bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("productos2")
	public void productos2(@RequestParam("categoria") Long categoria, HttpServletResponse response) {
		try {
			// Data
			List<Map<String,?>> lista = reporteService.traerProductos(categoria);
			JRMapCollectionDataSource data = new JRMapCollectionDataSource(lista);
			// Objeto JasperReport
			String reporte = "classpath:reports/Productos.jrxml";
			String path = resourceLoader.getResource(reporte).getURI().getPath();
			JasperReport jasperReport = JasperCompileManager.compileReport(path);
			// Ejecutar el reporte
			byte[] bytes = JasperRunManager.runReportToPdf(jasperReport, null, data);
			// Enviar PDF
			descargarPDF(response, bytes, "productos.pdf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void descargarPDF(HttpServletResponse response, byte[] bytes, String nombre) throws IOException {
		response.setContentType("application/x-download");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + nombre + "\"");
		response.setContentLength(bytes.length);
		ServletOutputStream out = response.getOutputStream();
		out.write(bytes,0,bytes.length);
		out.flush();
		out.close();
	}


	private void enviarPDF(HttpServletResponse response, byte[] bytes) throws IOException {
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream out = response.getOutputStream();
		out.write(bytes,0,bytes.length);
		out.flush();
		out.close();
	}

}

