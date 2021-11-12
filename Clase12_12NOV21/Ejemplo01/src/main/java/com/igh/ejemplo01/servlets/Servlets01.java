package com.igh.ejemplo01.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Coronel
 */
@WebServlet(name = "Servlets01", urlPatterns = {"/cambiar", "/cambia", "/cambio"})
public class Servlets01 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
			case "/cambiar":
				reponseCaso1(request, response);
				break;
			case "/cambia":
				reponseCaso2(request, response);
				break;

		}
	}

	private void reponseCaso1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Datos
		int soles = Integer.parseInt(request.getParameter("soles"));
		// Proceso
		double dolares = soles / 4.12;
		// Reporte
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>CAMBIO</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + soles + " soles equivale a " + dolares + " Dolares");
		out.println("</body>");
		out.println("</html>");
		out.flush();
	}

	private void reponseCaso2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Datos
		int soles = Integer.parseInt(request.getParameter("soles"));
		// Proceso
		double dolares = soles / 4.12;
		// Reporte
		request.setAttribute("soles", soles);
		request.setAttribute("dolares", dolares);
		RequestDispatcher rd = request.getRequestDispatcher("demo02Respuesta.jsp");
		rd.forward(request, response);
	}

}
