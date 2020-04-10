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
 * Servlet implementation class AgregarCantidadController
 */
@WebServlet("/AgregarCantidadController")
public class AgregarCantidadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarCantidadController() {
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
		
		if (esValido(request.getParameter("objalmacen")) && esValido(request.getParameter("cantidad"))) {
		
		int obj= Integer.parseInt(request.getParameter("objalmacen"));
		int cantidad=Integer.parseInt(request.getParameter("cantidad"));
		
		System.out.println("OBJETO: "+obj);
		
//		objetoalmacen
		ObjetoAlmacenDao objDao = new ObjetoAlmacenDao();		
		ObjetoAlmacen objalmacen = objDao.obtenerObjAlmacenPorIdObjeto(obj);
		
		
		int sumaCant=objalmacen.getCantidad();
		
		objalmacen.setCantidad(cantidad+sumaCant);
		
		objDao.update(objalmacen);
		
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
