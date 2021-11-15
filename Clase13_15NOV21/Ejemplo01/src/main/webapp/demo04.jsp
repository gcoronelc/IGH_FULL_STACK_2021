<%-- 
    Document   : demo04
    Created on : 15 nov. 2021, 12:32:48
    Author     : Gustavo Coronel
--%>
<%@page import="com.igh.ejemplo01.service.MateService"%>
<%
	// Variables
	int num1=0, num2=0, mcd=0, mcm=0;
	if(request.getParameter("btnProcesar")!=null){
		// Datos
		num1 = Integer.parseInt(request.getParameter("n1"));
		num2 = Integer.parseInt(request.getParameter("n2"));
		// Proceso
		MateService bean = new MateService();
		mcd = bean.mcd(num1, num2);
		mcm = bean.mcm(num1, num2);
	}
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<h1>MCD y MCM</h1>
		<form method="post" action="demo04.jsp">
			<div>
				<label>Número 1: </label>
				<input type="text" name="n1"/>
			<div>
				<label>Número 2: </label>
				<input type="text" name="n2"/>
			</div>
			<div>
				<input type="submit" name="btnProcesar" value="Procesar"/>
			</div>
		</form>
		
		<%if( request.getParameter("btnProcesar")!=null ){%>
			<h3>Resultado</h3>
			<div>
				<label>MCD: </label><%=mcd%>
			<div>
				<label>MCM: </label><%=mcm%>
			</div>
		<%}%>
	</body>
</html>
