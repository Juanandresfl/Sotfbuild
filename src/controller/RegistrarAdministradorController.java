package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Administrador;
import entities.Empleado;
import services.AdministradorDao;
import services.EmpleadoDao;

/**
 * Servlet implementation class RegistrarAdministradorController
 */
@WebServlet("/RegistrarAdministradorController")
public class RegistrarAdministradorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarAdministradorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		String nombre=request.getParameter("nombre");
		String apellido=request.getParameter("apellido");
		String pass=request.getParameter("pass");
		String telefono=request.getParameter("telefono");
		String dni= request.getParameter("dni");
		String direccion=request.getParameter("direccion");
		
		if( esValido(nombre) && esValido(apellido) && esValido(pass) && esValido(telefono)&&esValido(dni)){
		
		Empleado e = new Empleado();
		Administrador a = new Administrador();
		EmpleadoDao eDao = new EmpleadoDao();
		
		if(!eDao.BuscarDni(dni)) {
		e.setNombre(nombre);
		e.setApellido(apellido);
		e.setPass(pass);
		e.setTelefono(telefono);
		e.setDni(dni);
		e.setDireccion(direccion);
			
		eDao.insert(e);
		
		response.sendRedirect("RegistrarAdministrador.jsp?estado=Success");
		
		AdministradorDao aDao = new AdministradorDao();
		a.setEmpleado(e);
		aDao.insert(a);
		}
		}
		else {
			response.sendRedirect("RegistrarAdministrador.jsp?estado=Fail");
		}

	}
	
	public <T> boolean esValido(T valor) {
		if(valor == null) {
			return false;
		}
		return valor != "";
	}

}
