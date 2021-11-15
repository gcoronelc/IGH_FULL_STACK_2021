package com.igh.ejemplo01.controller;

import com.igh.ejemplo01.service.MateService;
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
@WebServlet(name = "MateController", urlPatterns = {"/MateController"})
public class MateController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Datos
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
	
		// Proceso
		MateService mateService = new MateService();
		int mcd = mateService.mcd(n1, n2);
		int mcm = mateService.mcm(n1, n2);
		
		//Respuesta
		request.setAttribute("n1", n1);
		request.setAttribute("n2", n2);
		request.setAttribute("mcd", mcd);
		request.setAttribute("mcm", mcm);
		RequestDispatcher rd = request.getRequestDispatcher("demo05.jsp");
		rd.forward(request, response);
	}

	
	
}
