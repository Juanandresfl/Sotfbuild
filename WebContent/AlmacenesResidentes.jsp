<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.List"  %>
   <%@ page import="services.AlmacenDao"%>
   <%@ page import="services.AlmacenistaDao"%>
   <%@ page import="services.ObjetoAlmacenDao"%>
   <%@ page import="entities.Empleado"  %>
   <%@ page import="entities.Almacenista"  %>
   <%@ page import="entities.ObjetoAlmacen"%>
    <%@ page import="entities.Almacen"  %>
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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
</head>
  <body>
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
    <script>
    $(document).ready(function(){
      $("#myInput1").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#myTable1 tr").filter(function() {
          $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
      });
    });
    </script>
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
          </div>
        </nav>
        <%AlmacenDao ADao=new AlmacenDao();
        ObjetoAlmacenDao b=new ObjetoAlmacenDao();
        Almacen a=ADao.AlmacenById(Integer.parseInt(request.getParameter("dni")));
        List<ObjetoAlmacen> objetos=b.objetosByAlmace(a.getIdAlmacen());
        %>

        <!-- fin de nav -->
        <h4 align="center">Inventario de maquinarias,equipos y herramientas</h4>
        <!-- inicio tabla -->
        <div class="container" id="administrar">
          <strong><p class="espacio"> Nombre del proyecto:</p></strong>
        <input class="form-control" id="myInput" type="text" placeholder="Buscar herramientas...">
       <br>
        <table class="table table-bordered ">
         <thead class="thead-dark">
           <tr>
             <th>Item</th>
             <th>Nombre</th>
             <th>Cantidad</th>
             <th>Unidades</th>
             <th>Estado</th>
             <th>P=propio &nbsp A=alquilado</th>
             <th>Observaciones</th>
           </tr>
         </thead>
         <tbody id="myTable">
         <%for(ObjetoAlmacen h:objetos){%>
       
           <tr>
            <td><%=h.getObjeto().getIdObjeto() %></td>
             <td><%=h.getObjeto().getNombre()%></td>
             <td><%=h.getCantidad()  %></td>
             <td><%=h.getObjeto().getUnidad() %></td>
              <td><%=h.getEstado() %></td>
               <td><%=h.getPropioAlquilado() %></td>
              <td><%=h.getObservaciones() %> </td>
           </tr>
       <%} %>
         </tbody>
       </table>
       </div>
       <!-- fin tabla -->
       
       <div class="container" id="administrar">

      <button type="button" name="button" class="btn btn-warning"> <i class="fas fa-download"></i> &nbsp Descargar archivo </button>
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
