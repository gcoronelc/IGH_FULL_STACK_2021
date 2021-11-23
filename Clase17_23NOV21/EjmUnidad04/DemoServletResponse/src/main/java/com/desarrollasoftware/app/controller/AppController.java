package com.desarrollasoftware.app.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
public class AppController {

	@GetMapping(value = { "/", "/home" })
	public String home(Model model) {

		model.addAttribute("titulo", "CALCULO DE UNA VENTA");
		model.addAttribute("datos", "DATOS DE LA VENTA");

		return "home";
	}

	@PostMapping(value = "/procesar")
	public void procesar(HttpServletRequest request, HttpServletResponse response) {

		// Datos
		double precio = Double.parseDouble(request.getParameter("precio"));
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));

		// Proceso
		double total = precio * cantidad;
		double importe = total / 1.18;
		double impuesto = total - importe;

		// Reporte
		try {
			// get the output stream for writing binary data in the response.
			ServletOutputStream os = response.getOutputStream();
			// set the response content type to PDF
			response.setContentType("application/pdf");
		    response.setHeader("Content-disposition","attachment;filename="+ "CalculoVenta.pdf");
		    
			// create a new document
			Document doc = new Document();
			// Titulo
			// create some special styles and font sizes
			Font bfBold18 = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD, new BaseColor(0, 0, 0));
			Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLDITALIC, new BaseColor(0, 0, 0));
			Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12);

			// create an instance of the PdfWriter using the output stream
			PdfWriter.getInstance(doc, os);

			// document header properties
			doc.addAuthor("Gustavo Coronel");
			doc.addCreationDate();
			doc.addProducer();
			doc.addCreator("youtube.com/DesarrollaSoftware");
			doc.addTitle("Calculo de una Venta");
			doc.setPageSize(PageSize.A4);
			doc.open();

			// Titulo
			doc.add(new Paragraph("CALCULO DE UNA VENTA", bfBold18));

			// Datos
			doc.add(new Paragraph(" ", bfBold12));
			doc.add(new Paragraph("DATOS", bfBold12));
			doc.add(new Paragraph("Precio: " + precio, bf12));
			doc.add(new Paragraph("Cantidad: " + cantidad, bf12));

			// Resultado
			doc.add(new Paragraph(" ", bfBold12));
			doc.add(new Paragraph("RESULTADO", bfBold12));
			doc.add(new Paragraph("Importe: " + importe, bf12));
			doc.add(new Paragraph("Impuesto: " + impuesto, bf12));
			doc.add(new Paragraph("Total: " + total, bf12));
			
			doc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
