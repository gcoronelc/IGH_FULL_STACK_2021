package pe.uni.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.uni.app.service.CuentaService;
import pe.uni.app.specification.CuentaSpecification;

@WebServlet({ "/ConsultarMovimientos" })
public class CuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/ConsultarMovimientos":
			consultarMovimientos(request, response);
		}
	}

	private void consultarMovimientos(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		// Dato
		String cuenta = request.getParameter("cuenta");
		// Proceso
		CuentaSpecification cuentaService = new CuentaService();
		List<Map<String, ?>> lista = cuentaService.conMovimientos(cuenta);
		// Preparan JSON
		Gson gson = new Gson();
		String cadenaJson = gson.toJson(lista);
		// Enviar el JSON
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(cadenaJson);
		out.flush();
	}

}
