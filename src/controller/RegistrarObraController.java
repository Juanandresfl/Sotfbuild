package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.IngResidente;
import entities.Obra;
import services.IngResidenteDao;

/**
 * Servlet implementation class RegistrarAdministradorController
 */
@WebServlet("/RegistrarObraController")
public class RegistrarObraController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrarObraController() {
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


		if (esValido(request.getParameter("nombre")) && esValido(request.getParameter("direccion"))
				&& esValido(request.getParameter("telefono")) && esValido(request.getParameter("id"))) {

			String nombre = request.getParameter("nombre");
			String direccion = request.getParameter("direccion");
			String telefono = request.getParameter("telefono");
			int id = Integer.parseInt(request.getParameter("id"));
			Date fecha = new Date();

			IngResidenteDao irDao = new IngResidenteDao();
			IngResidente ingResidente = irDao.obtenerIngPorIdEmpleado(id);

			Obra o = new Obra(direccion, fecha, fecha, nombre, telefono, ingResidente);

			o.registrar();

			response.sendRedirect("RegistrarObra.jsp?estado=Success");

		} else {
			response.sendRedirect("RegistrarObra.jsp?estado=Fail");
		}
	}

	public <T> boolean esValido(T valor) {
		if(valor == null) {
			return false;
		}
		return valor != "";
	}

}
