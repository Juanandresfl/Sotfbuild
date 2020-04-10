package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Empleado;
import services.EmpleadoDao;

/**
 * Servlet implementation class 
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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

		String tipo = request.getParameter("tipo");
		String dni = request.getParameter("dni");
		String pass = request.getParameter("pass");

		EmpleadoDao eDao = new EmpleadoDao();
		Empleado empleado = eDao.findByField("dni", dni);

		String mensajeError = ":)";
		
		if (empleado != null) {
			
			if (comprobarPassword(empleado, pass)) {

				HttpSession session = request.getSession();
				session.setAttribute("dni", empleado);

				switch ((String)tipo) {
				case "Administrador":
					session.setAttribute("rol", "Administrador");
					response.sendRedirect("HomeAdministrador.jsp");
					break;
				case "Almacenista":
					session.setAttribute("rol", "Almacenista");
					response.sendRedirect("HomeAlmacenista.jsp");
					break;
				case "Residente":
					session.setAttribute("rol", "IngResidente");
					response.sendRedirect("HomeResidente.jsp");
					break;
				}

			} else {
				mensajeError = "invalidPassword";
				response.sendRedirect("index.jsp?result="+mensajeError);
			}
		} else {
			mensajeError = "invalidUser";
			response.sendRedirect("index.jsp?result="+mensajeError);
		}
		
	}
	public boolean comprobarPassword(Empleado e, String pass) {
		return e.getPass().contentEquals(pass);
	}
}
