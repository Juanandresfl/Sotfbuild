package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Almacenista;
import entities.Empleado;
import entities.IngResidente;
import services.AlmacenistaDao;
import services.EmpleadoDao;
import services.IngResidenteDao;

/**
 * Servlet implementation class RegistrarAdministradorController
 */
@WebServlet("/RegistrarEmpleadoController")
public class RegistrarEmpleadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarEmpleadoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		String tipo=request.getParameter("tipo");
		
		if( esValido(nombre) && esValido(apellido) && esValido(pass) && esValido(telefono)&&esValido(dni)&&esValido(direccion)&& esValido(tipo)){
		
			Empleado e = new Empleado();
			IngResidente ir = new IngResidente();
			Almacenista a = new Almacenista();
			EmpleadoDao eDao = new EmpleadoDao();
			
			if(!eDao.BuscarDni(dni)) {
			e.setNombre(nombre);
			e.setApellido(apellido);
			e.setPass(pass);
			e.setTelefono(telefono);
			e.setDni(dni);
			e.setDireccion(direccion);
			
			eDao.insert(e);
			
			if(tipo.equalsIgnoreCase("residente")) {
				ir.setEmpleado(e);
				IngResidenteDao irDao = new IngResidenteDao();
				irDao.insert(ir);
				
			}
			else {
				a.setEmpleado(e);
				AlmacenistaDao aDao = new AlmacenistaDao();
				aDao.insert(a);
			}
			response.sendRedirect("RegistrarEmpleado.jsp?estado=Success");
		} 
			else {
			
			response.sendRedirect("RegistrarEmpleado.jsp?estado=Fail");
		}
		}
	
		
//			response.sendRedirect("HomeAdministrador.jsp");
		
		}
	
	public <T> boolean esValido(T valor) {
		if(valor == null) {
			return false;
		}
		return valor != "";
	}

}
