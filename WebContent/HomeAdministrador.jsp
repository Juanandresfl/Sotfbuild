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
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle my-2 my-sm-0"  id="navbarDropdown" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Administrador &nbsp <i class="fas fa-user-tie"></i>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <button class="dropdown-item" type="submit">Cerrar Sesion </button>
                </div>
              </li>
              </ul>
          </form>
          </div>
        </nav>

        <!-- fin nav -->

            <!-- Inicio botones administrador -->
            <div class="container" id="administrar">
            <div class="row jumbotron">
              <div class="col-6 col-sm-6 col-md-6 list-group">
              <a href="RegistrarObra.jsp"><button type="button" name="button" class="btn btn-link espacio list-group-item"> Crear Obra &nbsp<i class="far fa-building"></i></button></a>
              <a href="RegistrarAlmacen.jsp"><button type="button" name="button" class="btn btn-link espacio list-group-item"> Registrar Almacen &nbsp<i class="fas fa-home"></i></button></a>
              <a href="RegistrarBodega.jsp"><button type="button" name="button" class="btn btn-link espacio list-group-item">Registrar Bodega &nbsp<i class="fas fa-warehouse"></i></button></a>
              <a href="InfoAlmacenes.jsp"> <button type="button" name="button" class="btn btn-link espacio list-group-item">Ver informacion almacenes &nbsp<i class="fas fa-home"></i></button></a>
              <a href="InfoBodegas.jsp"><button type="button" name="button" class="btn btn-link espacio list-group-item">Ver informacion bodegas &nbsp<i class="fas fa-home"></i></button></a>

              </div>
              <div class="col-6 col-sm-6 col-md-6 list-group">
              <a href="RegistrarEmpleado.jsp"><button type="button" name="button" class="btn btn-link espacio list-group-item">Registrar Empleado &nbsp <i class="far fa-user"></i></button> </a>
              <a href="InfoObras.jsp"><button type="button" name="button" class="btn btn-link espacio list-group-item">Ver Obras &nbsp<i class="far fa-eye"></i></button></a>
			  <a href="VerResidentes.jsp"><button type="button" name="button" class="btn btn-link espacio list-group-item">Ver Residentes &nbsp<i class="far fa-eye"></i></button></a>
			  <a href="VerAlmacenistas.jsp"><button type="button" name="button" class="btn btn-link espacio list-group-item">Ver Almacenistas &nbsp<i class="far fa-eye"></i></button></a>
              </div>
            </div>
            </div>

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
