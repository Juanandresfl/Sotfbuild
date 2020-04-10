<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es" dir="ltr">
<head>
<meta charset="utf-8">
<meta name="description" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<title>SoftBuild</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css" media="all" />

<link rel="stylesheet" href="css/estilo.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
</head>
<body id="imgInicio">

	<!-- ##### Preloader ##### 
	<div class="preloader d-flex align-items-center justify-content-center">
		<div class="circle-preloader">
			<img src="img/logo.jpeg" alt="" />
		</div>
	</div>-->
	<!-- Login -->
	<div class="container tarjeta">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3 align="center">Iniciar Sesion</h3>

				</div>
				<div class="card-body">
					<form action="LoginController" method="post">
						<div class="form-inline separar">
							<select class="form-control btn btn-warning" name="tipo">
								<option>Administrador</option>
								<option>Almacenista</option>
								<option>Residente</option>
							</select>
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" name="dni" class="form-control"
								placeholder="Identificacion">
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<br>
							<input type="password" name="pass" class="form-control"
								placeholder="Contrasena">
						</div>

						<div class="form-group">
							<button type="submit" value=""
								class="btn float-right login_btn btn btn-warning">
								Iniciar Sesion</button>
						</div>
					</form>
				</div>
				<div class="card-footer">
					<div class="d-flex justify-content-center">
						<p style="color: white">
							<strong>¿No te has registrado? !Hazlo ahora¡</strong>
						</p>
						&nbsp <a href="RegistrarAdministrador.jsp">Registrar</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- ##### Footer Area Start ##### -->
	<%
		if (request.getParameter("result") != null) {

			String mensaje = request.getParameter("result");
			if (mensaje.equals("invalidUser")) {
	%>
	<SCRIPT>
		Swal.fire('¡Ups!', 'El Usuario No es Valido', 'error')
	</SCRIPT>
	<%
		} else if (mensaje.equals("invalidPassword")) {
	%>
	<SCRIPT>
		Swal.fire('¡Ups!', 'Contraseña Incorrecta', 'error')
	</SCRIPT>
	<%
		}
		}
	%>
	<!-- ##### All Javascript Script ##### -->
	<!-- jQuery-2.2.4 js -->
	<script src="js/jquery/jquery-2.2.4.min.js"></script>
	<!-- Popper js -->
	<script src="js/bootstrap/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script src="js/bootstrap/bootstrap.min.js"></script>
	<!-- All Plugins js -->
	<script src="js/plugins/plugins.js"></script>
	<!-- Active js -->
	<script src="js/active.js"></script>
</body>
</html>
