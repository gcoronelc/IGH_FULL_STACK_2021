package pe.uni.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.uni.app.dto.TablaDto;
import pe.uni.app.service.TablaService;

@WebServlet("/TablaController")
public class TablaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Dato
		int numero = Integer.parseInt(request.getParameter("numero"));
		// Proceso
		TablaService service = new TablaService();
		TablaDto[] tabla = service.procesar(numero);
		// Preparan JSON
		Gson gson = new Gson();
		String cadenaJson = gson.toJson(tabla);
		// Enviar el JSON
		
		 PrintWriter out = response.getWriter();
		 response.setContentType("application/json");
		 //response.setContentType("text/plain");
		 response.setCharacterEncoding("UTF-8"); 
		 out.print(cadenaJson); 
		 //out.print("Gustavo Coronel"); 
		 out.flush();
		 

		/*
		response.setHeader("Content-Type", "text/plain");
		response.setHeader("success", "yes");
		PrintWriter writer = response.getWriter();
		writer.write(cadenaJson);
		writer.flush();
		writer.close();
	*/
	}

}
