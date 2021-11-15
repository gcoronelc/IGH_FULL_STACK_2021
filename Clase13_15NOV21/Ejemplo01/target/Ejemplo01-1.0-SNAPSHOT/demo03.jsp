<%-- 
    Document   : demo03
    Created on : 15 nov. 2021, 11:53:57
    Author     : Gustavo Coronel
--%>
<%!
	private int num1, num2, suma;
%>
<% 
num1 = Integer.parseInt(request.getParameter("n1"));
num2 = Integer.parseInt(request.getParameter("n2"));
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<h1>SUMA CHEVERE</h1>
		<div>
			Número 1: <%=num1%>
		</div>
		<div>
			Número 2: <%=num2%>
		</div>
		<%
			Thread.sleep(2000);
			suma = num1 + num2;
		%>
		<div>
			Suma: <%=suma%>
		</div>
		
		
	</body>
</html>
