<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="entities.Obra" %>
 <%@ page import="services.ObraDao" %>
 <%@ page import="java.util.List" %>
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
   <!-- fin nav -->
                <h3 align="center" class="espacio"> Informacion Obras</h3>
        <div class="container">
          <div class="row" id="administrar">
            <div class="col-12 col-sm-12 col-md-12">
              <table class="table table-hover">
                <thead class="thead-dark">
                  <tr>
                  <th>Nombre de la obra</th>
                  <th>Direccion</th>
                  <th>Telefono</th>
                  <th>Detalles</th>
                </tr>
                 <%ObraDao o=new ObraDao();
                 	List<Obra>obras=o.Obras();%>
                 	 <tbody>
                <%for(Obra h:obras){%> 	
               
                
                  <tr>
                   
                    <td><%=h.getNombre() %></td>
                    <td><%=h.getDireccion()%></td>
                    <td><%=h.getTelefono() %></td>
                    <td>
                     <!-- inicio modal -->
                      <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#exampleModalCenter<%=h.getIdObra()%>">Ver &nbsp <i class="far fa-eye"></i></button>
                      <div class="modal fade" id="exampleModalCenter<%=h.getIdObra() %>" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                          <div class="modal-content">
                            <div class="modal-header">
                              <h5 class="modal-title" id="exampleModalLongTitle"> Obra <%=" "+h.getNombre() %>&nbsp <i class="fas fa-eye"></i></h5>
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                              </button>
                            </div>
                            <div class="modal-body">
                              <strong>Ingeniero Residente:<%=" "+o.IngResidente(h.getIngResidente().getIdIngResidente()) %></strong> <br> <br>
                              <strong>Almacen:<%=" "+ o.ObtenerAlmacen(h.getIdObra()) %></strong> <br><br>
                              <strong>Fecha Inicio:<%="  "+h.getFechaInicio() %></strong> <br><br>
                              <form id="administrar<%=h.getIdObra()%>" action="DarBajaObraController" method="post">
                              <select class="form group btn btn-warning" style="display:none" name="id">
                              <option  value="<%=h.getIdObra()%>">valor nulo</option>
                              </select>
                              <button type="submit" name="button" class="btn btn-danger">Dar de baja</button>
                              </form>
                            </div>
                            <div class="modal-footer">
                              <button type="button" class="btn btn-warning"data-dismiss="modal">Cerrar</button>
                            </div>
                          </div>
                        </div>
                      </div>
                      
                    </td>
                    
                  </tr>
                  <!-- fin ciclo -->
                  
               
                <% } %>
                 </tbody>
                </thead>
              </table>
            </div>
          </div>
        </div>

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