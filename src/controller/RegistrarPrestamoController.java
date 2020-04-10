package controller;

import java.io.IOException;
import java.util.Date;

import services.AlmacenDao;
import services.AlmacenistaDao;
import services.ObjetoAlmacenDao;
import services.ObjetoAlmacenPrestamoDao;
import services.ObjetoDao;
import services.PrestamoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Almacen;
import entities.Almacenista;
import entities.Empleado;
import entities.Objeto;
import entities.ObjetoAlmacen;
import entities.ObjetoAlmacenPrestamo;
import entities.Prestamo;

/**
 * Servlet implementation class AgregarCantidadController
 */
@WebServlet("/RegistrarPrestamoController")
public class RegistrarPrestamoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarPrestamoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (esValido(request.getParameter("origen")) && esValido(request.getParameter("destino"))  && esValido(request.getParameter("objeto"))
				 && esValido(request.getParameter("cantidad")) && esValido(request.getParameter("transportador"))&& esValido(request.getParameter("placa"))) {
		
		int origen= Integer.parseInt(request.getParameter("origen"));
		int destino=Integer.parseInt(request.getParameter("destino"));
		int objeto=Integer.parseInt(request.getParameter("objeto"));
		int cantidad=Integer.parseInt(request.getParameter("cantidad"));
		String transportador= request.getParameter("transportador");
		String placa= request.getParameter("placa");
		Date fecha = new Date();
		
//		almacenista
		HttpSession session =request.getSession();
		Empleado empleado= (Empleado) session.getAttribute("dni");	

		AlmacenistaDao almDao = new AlmacenistaDao();
		Almacenista almacenista= almDao.obtenerAlmacenistaPorIdEmpleado(empleado.getIdEmpleado());
		
//		almacen origen
		
		AlmacenDao aDao = new AlmacenDao();
		Almacen a= aDao.find(origen);
		
//		almacen destino
		
		AlmacenDao alDao= new AlmacenDao();
		Almacen al= alDao.find(destino);
		
//		objeto prestamo
		
		ObjetoDao obDao= new ObjetoDao();
		Objeto o= obDao.find(objeto);
		
//		insertar prestamo
		
		PrestamoDao pDao = new PrestamoDao();
		Prestamo p= new Prestamo();
		p.setAlmacen1(a);
		p.setAlmacen2(al);
		p.setAlmacenista(almacenista);
		p.setFecha(fecha);
		p.setNombreConductor(transportador);
		p.setPlacaVehiculo(placa);
		
		pDao.insert(p);
		
//		objeto almacen
		
		ObjetoAlmacenDao oaDao= new ObjetoAlmacenDao();
		ObjetoAlmacen oa= oaDao.obtenerObjAlmacenPorIdObjeto(objeto);
		int cant= oa.getCantidad()-cantidad;
		oa.setCantidad(cant);
		oaDao.update(oa);
		
//		insertar ObjetoAlmacenPrestamo
		
		ObjetoAlmacenPrestamoDao obaDao= new ObjetoAlmacenPrestamoDao();
		ObjetoAlmacenPrestamo oba = new ObjetoAlmacenPrestamo();
		
		oba.setCantidad(cantidad);
		oba.setObjetoAlmacen(oa);
		oba.setPrestamo(p);
		obaDao.insert(oba);
		response.sendRedirect("Prestamos.jsp?validar=Success");
		}
		
		else {
			response.sendRedirect("Prestamos.jsp?validar=Fail");
		}
	}
	
	public <T> boolean esValido(T valor) {
		if(valor == null) {
			return false;
		}
		return valor != "";
	}

}
