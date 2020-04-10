package services;


import java.util.List;

import javax.persistence.EntityManager;

import entities.Almacenista;
import entities.Empleado;
import services.GenericDao;
import util.Conexion;


public class AlmacenistaDao extends Conexion<Almacenista> implements GenericDao<Almacenista> {
	
public AlmacenistaDao(){
		super(Almacenista.class);
	}

public List<Empleado> Almacenistas(){
	 System.out.print(5);
	 EntityManager em = Conexion.getEm();
	 String query ="SELECT * FROM empleado WHERE id_empleado IN (SELECT id_empleado FROM almacenista)";
	 List<Empleado> resultado;
	
	 resultado = em.createNativeQuery(query, Empleado.class).getResultList();
	
	return resultado;
}

public String Estado(int idEmpleado){
	 System.out.print(5);
	 EntityManager em = Conexion.getEm();
	 String query ="SELECT a.id_almacenista, a.id_empleado, a.estado FROM almacenista a inner JOIN empleado e on a.id_empleado=e.id_empleado WHERE e.id_empleado="+ idEmpleado;
	 List<Almacenista> resultado;
	 resultado = em.createNativeQuery(query, Almacenista.class).getResultList();
	 if(resultado.get(0).getEstado()==null) return "Libre";	 
	
	 String estado=(resultado.get(0).getEstado().equalsIgnoreCase("ocupado")) ? "Ocupado":"Libre" ;
	
	return estado;
}

public Almacenista obtenerAlmacenistaPorIdEmpleado(int idEmpleado) {
	EntityManager em = Conexion.getEm();
	 String query = "select * from almacenista where id_empleado ="+idEmpleado;
	 List<Almacenista> resultado;
	 resultado = em.createNativeQuery(query, Almacenista.class).getResultList();
	 
	 Almacenista ing = find(resultado.get(0).getIdAlmacenista());
	 System.out.println("ALMACENISTA EN SESION "+ ing.getIdAlmacenista());
	 return ing;
}
}
