<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.List"  %>
   <%@ page import="services.AlmacenDao"  %>
   <%@ page import="services.EmpleadoDao"  %>
   <%@ page import="services.IngResidenteDao"  %>
   <%@ page import="entities.Empleado"  %>
   <%@ page import="entities.IngResidente"  %>
   <%@ page import="entities.Almacen"  %>
   <%@ page import="entities.Obra"  %>
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
          <a class="navbar-brand" href="HomeResidente.jsp"> <img src="img/logo.png" width="120px"></a>
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
                <a class="nav-link dropdown-toggle my-2 my-sm-0" href="#" id="navbarDropdown" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Residente &nbsp <i class="fas fa-user-tie"></i>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <button class="dropdown-item" type="submit" >Cerrar Sesion</button>
                </div>
              </li>
              </ul>
          </form>
          </div>
        </nav>
						
		<%
		HttpSession Session=request.getSession();
		Empleado e=(Empleado)Session.getAttribute("dni");
		IngResidenteDao ad=new IngResidenteDao();
		IngResidente a=ad.obtenerIngPorIdEmpleado(e.getIdEmpleado());
		Obra o=ad.obtenerObraActual(a.getIdIngResidente());
		List<Almacen> al=o.getAlmacens();
		AlmacenDao ald=new AlmacenDao();
 
		%>

        <h3 align="center"> Almacenes de la obra : &nbsp<strong><%=o.getNombre() %></strong></h3>
        
        

        <div class="container">
          <div class="row" id="administrar">
            <div class="col-12 col-sm-12 col-md-12">

              <table class="table table-hover">
                <thead class="thead-dark">
                  <tr>
                  <th>Nombre del almacen</th>
                  <th>Encargado</th>
                  <th>Telefono</th>
                  <th>Direccion</th>
                  <th>Detalle</th>
                </tr>
                <tbody>
               
                  <tr>
                  <%for(Almacen el:al){%>
                    <td><%=el.getNombre()%></td>
                    <td><%=el.getAlmacenista().getEmpleado().getNombre()%></td>
                    <td><%=el.getTelefono()%></td>
                    <td><%=el.getDireccion()%></td>
                    
                    <td>
                   
                    <button type="submit" class="btn btn-warning">
                    <a href="AlmacenesResidentes.jsp?dni=<%=el.getIdAlmacen()%>"><font color=black>Ver <i class="far fa-eye"></font></a></i>
                    </button>
                    </td>
                    </tr>
               <% } %>
                </tbody>
                </thead>
              </table>
            </div>
          </div>
        </div>

        <!-- fin nav -->

        <!-- ##### Footer Area Start ##### -->

        <!-- ##### All Javascript Script ##### -->
        <!-- jQuery-2.2.4 js -->
         <script src="js/jquery/jquery-2.2.4.min.js"></script>
        <!-- Popper js -->
        <script src="js/boots"WebContent/HomeResidente.jsp"trap/popper.min.js"></script>
        <!-- Bootstrap js -->
        <script src="js/bootstrap/bootstrap.min.js"></script>
        <!-- All Plugins js -->
        <script src="js/plugins/plugins.js"></script>
        <!-- Active js -->
        <script src="js/active.js"></script>
  </body>
</html>
