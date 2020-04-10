<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="entities.Objeto" %>
    <%@ page import="entities.Almacen" %>
    <%@ page import="entities.Empleado" %>
    <%@ page import="entities.Almacenista" %>
    <%@ page import="entities.Bodega" %>
    <%@ page import="services.ObjetoDao" %>
    <%@ page import="services.AlmacenDao" %>
    <%@ page import="services.AlmacenistaDao" %>
    <%@ page import="entities.ObjetoAlmacen" %>
    <%@ page import="services.ObjetoAlmacenDao" %>
    <%@ page import="services.BodegaDao" %>
<!DOCTYPE html>
<html lang="es" dir="ltr">
<head>
  <meta charset="utf-8">
  <meta name="description" content=""/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

  <title>SoftBuild</title>

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
          <a class="navbar-brand" href="HomeAlmacenista.jsp"> <img src="img/logo.png" width="120px"></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse"
                  data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                  aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
			
		<% HttpSession Session =request.getSession();
		Empleado empleado= (Empleado) session.getAttribute("dni");
		
		AlmacenistaDao aDao= new AlmacenistaDao();
		Almacenista a= aDao.obtenerAlmacenistaPorIdEmpleado(empleado.getIdEmpleado());
		
		AlmacenDao almDao = new AlmacenDao();
		Almacen al= almDao.ObtenerIdAlmacen(a.getIdAlmacenista());
		%>
			
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
            </ul>
            <form class="form-inline my-2 my-lg-0" action="DestruirSesionController" method="post">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle my-2 my-sm-0" href="#"
						id="navbarDropdown" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Almacenista
							&nbsp <i class="fas fa-user-tie"></i>
					</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<button type="submit" class="dropdown-item">Cerrar Sesion</button>
                </div>
              </li>
              </ul>
          </form>
          </div>
        </nav>
        <h3 align="center" class="espacio"> Prestamos de objetos de almacen a almacen</h3>
        <div class="container">
          <div class="row" id="administrar">
            <div class="col-12 col-sm-12 col-md-12">
              <form class="" action="RegistrarPrestamoController" method="post">
              <%	AlmacenDao alDao = new AlmacenDao(); 
             		List<Almacen> almacenes= alDao.ObtenerAlmacenesDiferentes(a.getIdAlmacenista());
             		
             		BodegaDao bDao = new BodegaDao();
             		List<Bodega> bodegas= bDao.Bodegas();
             		
             		ObjetoDao objDao = new ObjetoDao(); 
                 	List<Objeto> obj= objDao.MostrarObjetosAlmacen(al.getIdAlmacen());
             %>
              <table class="table table-hover">
                <thead class="thead-dark">
                  <tr>
                  <th>Origen</th>
                  <th>Destino</th>
                  <th>Objeto</th>
                  <th>Cantidad</th>
                  <th>Transportador</th>
                  <th>Placa Vehiculo</th>
                  <th></th>
                </tr>
                <tbody>
                  <tr>
                    <td>
                      <select class="btn btn-warning" name="origen" >                   
                    	<option value="<%=al.getIdAlmacen()%>"><%=al.getNombre()%></option>
                       </select>
                     </td>
                    <td>
                      <select class="btn btn-warning" name="destino">
                          <% for(Almacen alma: almacenes)
						
						{%>
                    	<option value="<%=alma.getIdAlmacen()%>"><%=alma.getNombre()%></option>
                    	<%} %>
                       </select>
                    </td>
                    <td>
                     <select class="btn btn-warning" name="objeto">
                          <% for(Objeto o: obj)
						
						{%>
                    	<option value="<%=o.getIdObjeto()%>"><%=o.getNombre()%></option>
                    	<%} %>
                       </select>
                    </td>
                    <td>
                      <input type="number" name="cantidad" >
                    </td>
                     <td>
                      <input type="text" name="transportador">
                    </td>
                     <td>
                      <input type="text" name="placa">
                    </td>
                    <td>
                      <button type="submit" name="button" class="btn btn-warning">Agregar</button>
                    </td>
                  </tr>
                </tbody>
                </thead>
              </table>
              </form>
            </div>
            </div>
          </div>
          
          
          	     <%
				String estado = request.getParameter("validar");
				if (estado != null)
					if (estado.equals("Success")) {
			%>
			<SCRIPT>
				Swal.fire('Objeto Agregado!', 'El objeto ha sido agregado con exito!',
						'success')
			</SCRIPT>
			<%
				} else {
			%>
			<SCRIPT>
			Swal.fire('¡Error!','¡el objeto no ha podido ser agregado!','error')
			</SCRIPT>
			<%
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