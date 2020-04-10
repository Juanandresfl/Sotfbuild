package controller;

import java.io.IOException;
import java.util.Date;

import services.ObraDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Obra;
import services.ObraDao;

/**
 * Servlet implementation class DarBajaObraController
 */
@WebServlet("/DarBajaObraController")
public class DarBajaObraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DarBajaObraController() {
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
		System.out.print(5);
		int id1 = Integer.parseInt(request.getParameter("id"));
		System.out.println(id1);
		ObraDao od=new ObraDao();
		Obra o=od.obraById(id1);
		o.getIngResidente().setEstado("Libre");
		o.setFechaFin(new Date());
		response.sendRedirect("HomeAdministrador.jsp");
		
	}

}
