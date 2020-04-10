<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.List" %>
  <%@ page import="entities.Objeto" %>
   <%@ page import="entities.Almacenista" %>
   <%@ page import="entities.Almacen" %>
    <%@ page import="entities.Empleado" %>
 <%@ page import="services.ObjetoDao" %>
 <%@ page import="entities.ObjetoAlmacen" %>
 <%@ page import="services.ObjetoAlmacenDao" %>
  <%@ page import="services.AlmacenistaDao" %>
   <%@ page import="services.AlmacenDao" %>
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
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
</head>

    <script>
    $(document).ready(function(){
      $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#myTable tr").filter(function() {
          $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
      });
    });
    </script>
  <body>
    <!-- ##### Preloader ##### -->
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="circle-preloader">
                <img src="img/logo.jpeg" alt=""/>
            </div>
        </div>

     <!-- inicio nav -->
     
     	<% HttpSession Session =request.getSession();
		Empleado empleado= (Empleado) session.getAttribute("dni");
		
		AlmacenistaDao aDao= new AlmacenistaDao();
		Almacenista a= aDao.obtenerAlmacenistaPorIdEmpleado(empleado.getIdEmpleado());
		
		AlmacenDao almDao = new AlmacenDao();
		Almacen al= almDao.ObtenerIdAlmacen(a.getIdAlmacenista());
		%>
          <nav class="navbar navbar-expand-lg navbar-light bg-warning">
          <a class="navbar-brand" href="HomeAlmacenista.jsp"> <img src="img/logo.png" width="120px"></a>
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
						aria-haspopup="true" aria-expanded="false"> Almacenista
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

        <h3 align="center"> Agregar Objetos Almacen</h3>

        <div class="container">
          <div class="row" id="administrar">
            <div class="col-12 col-sm-12 col-md-12">      
             <br>
				<form action="AgregarObjetosController" method="post">
				
			<%	ObjetoDao oDao = new ObjetoDao(); 
             	List<Objeto> objetos= oDao.MostrarObjetos();
             %>
              <table class="table table-hover">
                <thead class="thead-dark">
                <tr>
                  <th>Objeto</th>
                  <th>Cantidad</th>
                  <th>Estado</th>
                  <th>Propio/Alquilado</th>
                  <th>Observaciones</th>
                  <th></th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>
						<select class="form group btn btn-warning" name="objeto">
						<% for(Objeto o: objetos)
						
						{%>
                    	<option value="<%=o.getIdObjeto()%>"><%=o.getNombre()%></option>
                    	<%} %>
                    	</select>
					</td>
                    <td><input type="number" name="cantidad"></input></td>
                    <td>
                    <select class="form group btn btn-warning" name="estado">
                    	<option>Bueno</option>
                    	<option>Malo</option>
                    </select>
                    </td>
                    <td>
                    <select class="form group btn btn-warning" name="info">
                    	<option>Propio</option>
                    	<option>Alquilado</option>
                    </select>
                    </td>
                    <td><textarea type="text" name="observaciones"></textarea></td>
                    <td><button type="submit" class="btn btn-warning">Agregar</button></td>
                  </tr>
                </tbody>

              </table>
              </form>
            </div>
          </div>
        </div>
        
         <h3 align="center"> Objetos Existentes</h3>     	   
         <div class="container">
          <div class="row" id="administrar">
            <div class="col-12 col-sm-12 col-md-12"> 
            
            <%	ObjetoDao objDao = new ObjetoDao(); 
             	List<Objeto> obj= oDao.MostrarObjetosAlmacen(al.getIdAlmacen());
             	%>     
             <input class="form-control" id="myInput" type="text" placeholder="Buscar Objetos....">
             <br>	
		              <table class="table table-hover">
		                <thead class="thead-dark">
		                
		                <tr>
		                  <th>Objeto</th>
		                  <th>Cantidad</th>
		                  <th></th>
		                  </tr>
		                </thead>
		                <tbody id="myTable">
		            <% for(Objeto o: obj)		
					{%>
                  		<tr>
						<form action="AgregarCantidadController" method="post">
						<td>
						<input style="display:none" name="objalmacen" value="<%=o.getIdObjeto()%>">
                    	<%=o.getNombre()%>
						</td>
                    <td><input type="number" name="cantidad"></input></td>
                    <td><button type="submit" class="btn btn-warning">Agregar Cantidad</button></td>
                   		 </form>
                  </tr>
                  <%} 
                   %>
                </tbody>
              </table>
              
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
	
	     <%
		String validar = request.getParameter("estado");
		if (estado != null)
			if (estado.equals("Success")) {
	%>
	<SCRIPT>
		Swal.fire('Cantidad Agregada!', 'se ha agregado la cantidad con exito!',
				'success')
	</SCRIPT>
	<%
		} else {
	%>
	<SCRIPT>
	Swal.fire('¡Error!','¡No se ha podido agregar la cantidad!','error')
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