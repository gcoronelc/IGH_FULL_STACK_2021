<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="/css/bootstrap.min.css">
<!-- Bootstrap CSS -->
<title>${titulo}</title>
</head>
<body>

	<div class="container">

		<h1>${titulo}</h1>

		<c:if test="${datos != null}">

			<div class="card">
				<div class="card-header">${datos}</div>
				<div class="card-body">
					<form method="post" action="procesar">

						<div class="form-group row">
							<label for="precio" class="col-sm-2 col-form-label">Precio</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="precio"
									name="precio" placeholder="Precio del producto">
							</div>
						</div>

						<div class="form-group row">
							<label for="cantidad" class="col-sm-2 col-form-label">Cantidad</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="cantidad"
									name="cantidad" placeholder="Cantidad">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-10 offset-sm-2">
								<button type="submit" class="btn btn-primary">Procesar</button>
							</div>
						</div>

					</form>
				</div>
			</div>

		</c:if>

		<c:if test="${reporte != null}">

			<div class="card">
				<div class="card-header">${reporte}</div>
				<div class="card-body">
					<form method="get" action="home">

						<div class="form-group row">
							<label for="precio" class="col-sm-2 col-form-label">Precio</label>
							<div class="col-sm-10">
								<fmt:formatNumber type="number" maxFractionDigits="2"
									minFractionDigits="2" value="${precio}" />
							</div>
						</div>

						<div class="form-group row">
							<label for="cantidad" class="col-sm-2 col-form-label">Cantidad</label>
							<div class="col-sm-10">
								<fmt:formatNumber type="number" value="${cantidad}" />
							</div>
						</div>

						<div class="form-group row">
							<label for="importe" class="col-sm-2 col-form-label">Importe</label>
							<div class="col-sm-10">
								<fmt:formatNumber type="number" maxFractionDigits="2"
									minFractionDigits="2" value="${importe}" />
							</div>
						</div>

						<div class="form-group row">
							<label for="impuesto" class="col-sm-2 col-form-label">Impuesto</label>
							<div class="col-sm-10">
								<fmt:formatNumber type="number" maxFractionDigits="2"
									minFractionDigits="2" value="${impuesto}" />
							</div>
						</div>

						<div class="form-group row">
							<label for="total" class="col-sm-2 col-form-label">Total</label>
							<div class="col-sm-10">
								<fmt:formatNumber type="number" maxFractionDigits="2"
									minFractionDigits="2" value="${total}" />
							</div>
						</div>


						<div class="form-group row">
							<div class="col-sm-10 offset-sm-2">
								<button type="submit" class="btn btn-primary">Nueva
									Venta</button>
							</div>
						</div>

					</form>
				</div>
			</div>

		</c:if>

	</div>




	<!-- JavaScript -->
	<script src="/js/jquery-3.5.1.min.js"></script>
	<script src="/js/popper.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<!-- JavaScript -->
</body>
</html>