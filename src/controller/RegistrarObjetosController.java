package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Equipo;
import entities.Herramienta;
import entities.Material;
import entities.Objeto;
import services.EquipoDao;
import services.HerramientaDao;
import services.MaterialDao;
import services.ObjetoDao;

/**
 * Servlet implementation class RegistrarObjetosController
 */
@WebServlet("/RegistrarObjetosController")
public class RegistrarObjetosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrarObjetosController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		if (esValido(request.getParameter("nombre")) && esValido(request.getParameter("descripcion"))
				&& esValido(request.getParameter("unidades")) && esValido(request.getParameter("tipo"))) {
				
				String nombre= request.getParameter("nombre");
				String descripcion=request.getParameter("descripcion");
				String unidades=request.getParameter("unidades");
				String tipo=request.getParameter("tipo");
				
				Objeto o= new Objeto();
				ObjetoDao oDao= new ObjetoDao();
				o.setNombre(nombre);
				o.setDescripcion(descripcion);
				o.setUnidad(unidades);
				oDao.insert(o);
				if(tipo.equalsIgnoreCase("Material")) {
					MaterialDao mDao= new MaterialDao();
					Material m= new Material();
					m.setObjeto(o);
					mDao.insert(m);
				}
				if(tipo.equalsIgnoreCase("Herramienta")) {
					HerramientaDao hDao= new HerramientaDao();
					Herramienta h= new Herramienta();
					h.setObjeto(o);
					hDao.insert(h);
				}
				if(tipo.equalsIgnoreCase("Equipo")) {
					EquipoDao eDao= new EquipoDao();
					Equipo e= new Equipo();
					e.setObjeto(o);
					eDao.insert(e);
				}
					
				response.sendRedirect("RegistrarObjeto.jsp?estado=Success");

		} else {
			response.sendRedirect("RegistrarObjeto.jsp?estado=Fail");
		}
	}

	public <T> boolean esValido(T valor) {
		if(valor == null) {
			return false;
		}
		return valor != "";
	}

}


