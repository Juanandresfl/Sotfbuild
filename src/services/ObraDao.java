package services;

import java.util.List;

import javax.persistence.EntityManager;

import entities.Almacen;
import entities.Empleado;
import entities.IngResidente;
import entities.Obra;
import services.GenericDao;
import util.Conexion;


public class ObraDao extends Conexion<Obra> implements GenericDao<Obra> {
	
public ObraDao(){
		super(Obra.class);
	}

public List<Obra> Obras(){
	
	 EntityManager em = Conexion.getEm();
	 String query = "select * from obra where fecha_fin is null";
	 List<Obra> resultado;
	 resultado = em.createNativeQuery(query,Obra.class).getResultList();
	return resultado;
}

public List<Obra> MostrarObras(){
	
	 EntityManager em = Conexion.getEm();
	 String query = "select o.id_obra,o.nombre,o.direccion,o.telefono,o.id_ing_residente,o.fecha_inicio,o.fecha_fin from obra o left outer join almacen on o.id_obra=almacen.id_obra";
	 List<Obra> resultado;
	 resultado = em.createNativeQuery(query, Obra.class).getResultList();
	return resultado;
}

public Obra obraById(int id){
	
	 EntityManager em = Conexion.getEm();
	 String query = "select * from obra where id_obra="+id;
	 List<Obra> resultado;
	 resultado = em.createNativeQuery(query,Obra.class).getResultList();
	return resultado.get(0);
}

public String IngResidente(int id){
	
	 EntityManager em = Conexion.getEm();
	 String query ="SELECT e.id_empleado,e.nombre,e.apellido,e.telefono,e.direccion,e.dni,e.pass from empleado e INNER JOIN ing_residente ir ON e.id_empleado=ir.id_empleado INNER JOIN obra o on ir.id_ing_residente=o.id_ing_residente where ir.id_ing_residente="+id;
	 List<Empleado> resultado;
	 resultado = em.createNativeQuery(query,Empleado.class).getResultList();
	return resultado.get(0).getNombre()+" " +resultado.get(0).getApellido();
}

public String ObtenerAlmacen(int idObra){
	
	 EntityManager em = Conexion.getEm();
	 String query ="SELECT a.id_almacen,a.id_obra,a.id_almacenista,a.nombre,a.telefono,a.direccion FROM obra o inner join almacen a on o.id_obra=a.id_obra where o.id_obra="+idObra;
	 List<Almacen> resultado;
	 resultado = em.createNativeQuery(query,Almacen.class).getResultList();
	 if(resultado.isEmpty()) return "No asignado aun";
	 
	return resultado.get(0).getNombre()+" "+resultado.get(0).getIdAlmacen();
}
}
