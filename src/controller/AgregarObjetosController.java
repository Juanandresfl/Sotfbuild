package controller;

import java.io.IOException;

import services.AlmacenDao;
import services.AlmacenistaDao;
import services.ObjetoAlmacenDao;
import services.ObjetoDao;

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

/**
 * Servlet implementation class DarBajaObraController
 */
@WebServlet("/AgregarObjetosController")
public class AgregarObjetosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarObjetosController() {
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
		
		if (esValido(request.getParameter("objeto")) && esValido(request.getParameter("estado"))
				&& esValido(request.getParameter("info")) && esValido(request.getParameter("observaciones"))
				&&esValido(request.getParameter("cantidad"))) {
		
		int obj= Integer.parseInt(request.getParameter("objeto"));
		
		System.out.println("ID OBJETO: "+obj);
		String estado=request.getParameter("estado");
		String info=request.getParameter("info");
		String observaciones=request.getParameter("observaciones");
		int cantidad=Integer.parseInt(request.getParameter("cantidad"));
		
//		almacenista
		HttpSession session =request.getSession();
		Empleado empleado= (Empleado) session.getAttribute("dni");	
		
		System.out.println("Empleado " + empleado.getNombre());
		AlmacenistaDao almDao = new AlmacenistaDao();
		Almacenista almacenista= almDao.obtenerAlmacenistaPorIdEmpleado(empleado.getIdEmpleado());
		
		System.out.println("Almacenista ID : "+ almacenista.getIdAlmacenista());
		
//		almacen	
		AlmacenDao alDao = new AlmacenDao();
		Almacen a = alDao.ObtenerIdAlmacen(almacenista.getIdAlmacenista());
	
//		objeto
		ObjetoDao oDao = new ObjetoDao();
		Objeto o= oDao.find(obj);
		
//		objetoalmacen
		ObjetoAlmacenDao objDao = new ObjetoAlmacenDao();		
		ObjetoAlmacen objalmacen = new ObjetoAlmacen();
		
		
		objalmacen.setAlmacen(a);
		objalmacen.setCantidad(cantidad);
		objalmacen.setEstado(estado);
		objalmacen.setObjeto(o);
		objalmacen.setObservaciones(observaciones);
		objalmacen.setPropioAlquilado(info);
		
		objDao.insert(objalmacen);
		
		response.sendRedirect("AgregarObjeto.jsp?validar=Success");
		}
		
		else {
			response.sendRedirect("AgregarObjeto.jsp?validar=Fail");
		}
	}
	
	public <T> boolean esValido(T valor) {
		if(valor == null) {
			return false;
		}
		return valor != "";
	}

}
