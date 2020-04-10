package services;

import java.util.List;

import javax.persistence.EntityManager;

import entities.Empleado;
import services.GenericDao;
import util.Conexion;


public class EmpleadoDao extends Conexion<Empleado> implements GenericDao<Empleado> {
	
public EmpleadoDao(){
		super(Empleado.class);
	}

public List<Empleado> EmpleadoResidentes(){
	
	 EntityManager em = Conexion.getEm();
	 String query = "select e.id_empleado,e.nombre,e.apellido,e.telefono,e.direccion,e.dni,e.pass from empleado e inner join ing_residente ir on e.id_empleado=ir.id_empleado WHERE ir.estado is null";
	 List<Empleado> resultado;
	 resultado = em.createNativeQuery(query, Empleado.class).getResultList();
	return resultado;
}

public List<Empleado> EmpleadoAlmacenista(){
	
	 EntityManager em = Conexion.getEm();
	 String query = "select e.id_empleado,e.nombre,e.apellido,e.telefono,e.direccion,e.dni,e.pass from empleado e inner join almacenista a on e.id_empleado=a.id_empleado WHERE a.estado is null";
	 List<Empleado> resultado;
	 resultado = em.createNativeQuery(query, Empleado.class).getResultList();
	return resultado;
}

public Boolean BuscarDni(String dni){
	
	 EntityManager em = Conexion.getEm();
	 String query = "select * from empleado e where e.dni="+dni;
	 List<Empleado> resultado;
	 resultado = em.createNativeQuery(query, Empleado.class).getResultList();
	 
	return (resultado.isEmpty())?false:true;
}

}