package services;

import java.util.List;

import javax.persistence.EntityManager;

import entities.Almacenista;
import entities.Empleado;
import entities.IngResidente;
import entities.Obra;
import services.GenericDao;
import util.Conexion;


public class IngResidenteDao extends Conexion<IngResidente> implements GenericDao<IngResidente> {
	
public IngResidenteDao(){
		super(IngResidente.class);
	}


public List<IngResidente> IngeResidentes(){
	
	 EntityManager em = Conexion.getEm();
	 String query = "select * from ing_residente where estado <>'Ocupado'";
	 List<IngResidente> resultado;
	 resultado = em.createNativeQuery(query, IngResidente.class).getResultList();
	return resultado;
}

public IngResidente obtenerIngPorIdEmpleado(int idEmpleado) {
	EntityManager em = Conexion.getEm();
	 String query = "select * from ing_residente where id_empleado ="+idEmpleado;
	 List<IngResidente> resultado;
	 resultado = em.createNativeQuery(query, IngResidente.class).getResultList();
	 IngResidente ing = find(resultado.get(0).getIdIngResidente());
	 return ing;
}
public Obra obtenerObraActual(int idIngResidente) {
	
	 EntityManager em = Conexion.getEm();
	 String query = "SELECT o.id_obra,o.nombre,o.direccion,o.telefono,o.id_ing_residente,o.fecha_inicio,o.fecha_fin FROM obra o inner join ing_residente ir on o.id_ing_residente=ir.id_ing_residente WHERE o.fecha_fin is null and ir.id_ing_residente="+idIngResidente;
	 List<Obra> resultado;
	 resultado = em.createNativeQuery(query, Obra.class).getResultList();
	return resultado.get(0);
	
}
public List<Empleado> Residentes(){
	EntityManager em = Conexion.getEm();
	 String query = "SELECT e.id_empleado,e.nombre,e.apellido,e.telefono,e.direccion,e.dni,e.pass FROM empleado e inner join ing_residente ir on e.id_empleado=ir.id_empleado ";
	 List<Empleado> resultado;
	 resultado = em.createNativeQuery(query, Empleado.class).getResultList();
	return resultado;
	
}
public String Estado(int idEmpleado){
	 System.out.print(5);
	 EntityManager em = Conexion.getEm();
	 String query ="SELECT a.id_ing_residente, a.id_empleado, a.estado FROM ing_residente a inner JOIN empleado e on a.id_empleado=e.id_empleado WHERE e.id_empleado="+ idEmpleado;;
	 List<IngResidente> resultado;
	
	 resultado = em.createNativeQuery(query, IngResidente.class).getResultList();
	 if(resultado.get(0).getEstado()==null) return "Libre";	 
	 String estado=(resultado.get(0).getEstado().equalsIgnoreCase("Ocupado")) ? "Ocupado":"Libre" ;
	
	return estado;
}
}
