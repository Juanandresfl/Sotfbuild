package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Bodega;

import services.BodegaDao;


/**
 * Servlet implementation class RegistrarAdministradorController
 */
@WebServlet("/RegistrarBodegaController")
public class RegistrarBodegaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarBodegaController() {
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
		
		doGet(request, response);
		
		if (esValido(request.getParameter("nombre")) && esValido(request.getParameter("direccion"))
				&& esValido(request.getParameter("telefono"))) {
		
		String nombre=request.getParameter("nombre");
		String direccion=request.getParameter("direccion");
		String telefono=request.getParameter("telefono");
		
		BodegaDao bDao= new BodegaDao();
		Bodega b=new Bodega();
		
		b.setNombre(nombre);
		b.setDireccion(direccion);
		b.setTelefono(telefono);
		
		bDao.insert(b);
		response.sendRedirect("RegistrarBodega.jsp?estado=Success");
		
		}
		else {
			response.sendRedirect("RegistrarBodega.jsp?estado=Fail");
		}
	}
	
	public <T> boolean esValido(T valor) {
		if(valor == null) {
			return false;
		}
		return valor != "";
	}

}
