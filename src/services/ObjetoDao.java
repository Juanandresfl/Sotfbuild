package services;
import java.util.List;

import javax.persistence.EntityManager;

import entities.Objeto;
import entities.ObjetoAlmacen;
import services.GenericDao;
import util.Conexion;


public class ObjetoDao extends Conexion<Objeto> implements GenericDao<Objeto> {
	
public ObjetoDao(){
		super(Objeto.class);
	}

public List<Objeto> MostrarObjetos(){
	
	 EntityManager em = Conexion.getEm();
	 String query = "select * from objeto";
	 List<Objeto> resultado;
	 resultado = em.createNativeQuery(query, Objeto.class).getResultList();
	 
	 System.out.println("NOMBRE : "+resultado.get(0).getNombre());
	return resultado;
}

public List<Objeto> MostrarObjetosAlmacen(int id){
	
	 EntityManager em = Conexion.getEm();
	 String query = "SELECT o.id_objeto,o.nombre,o.descripcion,o.unidad FROM objeto o inner join objeto_almacen oa ON o.id_objeto=oa.id_objeto WHERE oa.id_almacen="+id;
	 List<Objeto> resultado;
	 resultado = em.createNativeQuery(query, Objeto.class).getResultList();
	 
//	 System.out.println("NOMBRE : "+resultado.get(0).getNombre());
	return resultado;
}
}
