<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es" dir="ltr">
<head>
  <meta charset="utf-8">
  <meta name="description" content=""/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

  <title>SoftBuild</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="css/style.css" media="all" />

  <link rel="stylesheet" href="css/estilo.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
       <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
</head>
  <body>
    <!-- ##### Preloader ##### -->
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="circle-preloader">
                <img src="img/logo.jpeg" alt=""/>
            </div>
        </div>

     <!-- inicio nav -->
          <nav class="navbar navbar-expand-lg navbar-light bg-warning">
         <a class="navbar-brand" href="HomeAdministrador.jsp"> <img src="img/logo.png" width="120px"></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse"
                  data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                  aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
          	<ul class="navbar-nav mr-auto">
            </ul>
            <form class="form-inline my-2 my-lg-0" action="DestruirSesionController" method="post">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle my-2 my-sm-0" href="#"
						id="navbarDropdown" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Administrador
							&nbsp <i class="fas fa-user-tie"></i>
					</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<button class="dropdown-item" type="submit" >Cerrar Sesion</button>
                </div>
              </li>
              </ul>
          </form>
          </div>
        </nav>

        <h3 align="center">Registrar Bodega</h3>
        <div class="container">
            <form id="administrar" action="RegistrarBodegaController" method="post">
                <div class="row jumbotron">
              <div class="col-6 col-md-6 col-sm-6">
                <div class="form-group">
                  <label for="exampleInputText1">Nombre bodega</label>
                  <input type="text" name="nombre" class="form-control" id="exampleInputText1" aria-describedby="emailHelp" placeholder="Bodega Sevilla">
                </div>
                <div class="form-group">
                  <label for="exampleInputNumber1">Telefono</label>
                  <input type="text" name="telefono" class="form-control" id="exampleInputText1" aria-describedby="emailHelp" placeholder="+57 3101010101">
                </div>
              </div>
              <div class="col-6 col-md-6 col-sm-6">
                <div class="form-group">
                  <label for="exampleInputText1">Direccion</label>
                  <input type="text" name="direccion" class="form-control" id="exampleInputText1" placeholder="calle falsa #123">
                </div>
                  </div>
                    <button class="btn btn-warning"id="centrar" type="submit">Registrar</button>
                    </div>
                    </form>
                  </div>
                  
                  
                  <%
		String estado = request.getParameter("estado");
		if (estado != null)
			if (estado.equals("Success")) {
	%>
	<SCRIPT>
		Swal.fire('Bodega Registrada!', 'la bodega ha sido registrada con exito!',
				'success')
	</SCRIPT>
	<%
		} else {
	%>
	<SCRIPT>
	Swal.fire('¡Error!','¡la bodega no ha podido ser registrada!','error')
	</SCRIPT>
	<%
		}
	%>

        <!-- ##### Footer Area Start ##### -->

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