<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="card mt-2">
	<div class="card-header">RESULTADO - Tabla del ${numero}</div>
	<div class="card-body">
		<table class="table table-striped">
			<tbody>
				<c:forEach items="${tabla}" var="dto">
					<tr>
						<td>${dto.num1}</td>
						<td>X</td>
						<td>${dto.num2}</td>
						<td>=</td>
						<td>${dto.prod}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>