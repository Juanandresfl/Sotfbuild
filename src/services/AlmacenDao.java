package services;

import java.util.List;

import javax.persistence.EntityManager;

import entities.Almacen;
import entities.Empleado;
import entities.Obra;
import services.GenericDao;
import util.Conexion;


public class AlmacenDao extends Conexion<Almacen> implements GenericDao<Almacen> {
	
public AlmacenDao(){
		super(Almacen.class);
	}

public List<Almacen> Obras(){
	
	 EntityManager em = Conexion.getEm();
	 String query = "select * from almacen";
	 List<Almacen> resultado;
	 resultado = em.createNativeQuery(query,Almacen.class).getResultList();
	return resultado;
}
public Almacen AlmacenById	(int id){
	
	 EntityManager em = Conexion.getEm();
	 String query = "select * from almacen where id_almacen="+id;
	 List<Almacen> resultado;
	 resultado = em.createNativeQuery(query,Almacen.class).getResultList();
	return resultado.get(0);
}

public Almacen ObtenerIdAlmacen(int id){
	 EntityManager em = Conexion.getEm();
	 String query ="SELECT * FROM almacen a inner JOIN almacenista al on a.id_almacenista=al.id_almacenista WHERE a.id_almacenista="+id;
	 List<Almacen> resultado;
	
	 resultado = em.createNativeQuery(query, Almacen.class).getResultList();
	 Almacen alm = find(resultado.get(0).getIdAlmacen());	
	return alm;
}

public Almacen AlmacenByIdAlmacenista(int id){
	
	 EntityManager em = Conexion.getEm();
	 String query = "select * from almacen where id_almacenista="+id;
	 List<Almacen> resultado;
	 resultado = em.createNativeQuery(query,Almacen.class).getResultList();
	return resultado.get(0);
}
public List<Almacen> ObtenerAlmacenesDiferentes(int id){
	 EntityManager em = Conexion.getEm();
	 String query ="select a.id_almacen,a.id_obra,a.id_almacenista,a.nombre,a.telefono,a.direccion from almacen a inner join almacenista al on a.id_almacenista<>al.id_almacenista where al.id_almacenista="+id;
	 List<Almacen> resultado;
	
	 resultado = em.createNativeQuery(query, Almacen.class).getResultList();
	 System.out.println("ALMACEN DISTINTO_: "+resultado.get(0).getNombre());
	 System.out.println("ALMACEN DISTINTO_: "+resultado.get(0).getIdAlmacen());
	return resultado;
}
}
