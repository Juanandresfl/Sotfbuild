package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Obra;
import entities.Almacen;
import entities.Almacenista;
import services.AlmacenistaDao;
import services.ObraDao;

/**
 * Servlet implementation class RegistrarAlmacenController
 */
@WebServlet("/RegistrarAlmacenController")
public class RegistrarAlmacenController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrarAlmacenController() {
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

		if (esValido(request.getParameter("nombre")) && esValido(request.getParameter("telefono"))
				&& esValido(request.getParameter("obra")) && esValido(request.getParameter("direccion"))
				&& esValido(request.getParameter("id"))) {

			String nombre = request.getParameter("nombre");
			String telefono = request.getParameter("telefono");
			int obra = Integer.parseInt(request.getParameter("obra"));
			String direccion = request.getParameter("direccion");
			int almacenista = Integer.parseInt(request.getParameter("id"));
			
			AlmacenistaDao aDao= new AlmacenistaDao();
			Almacenista a= aDao.obtenerAlmacenistaPorIdEmpleado(almacenista);

			ObraDao obraDao= new ObraDao();
			Obra o = obraDao.find(obra);
			
			Almacen nuevo = new Almacen(direccion,nombre,telefono,a,o);
			nuevo.registrar();
			
			response.sendRedirect("RegistrarAlmacen.jsp?estado=Success");
		} else {
			response.sendRedirect("RegistrarAlmacen.jsp?estado=Fail");
		}
	}

	public <T> boolean esValido(T valor) {
		if (valor == null) {
			return false;
		}
		return valor != "";
	}

}
