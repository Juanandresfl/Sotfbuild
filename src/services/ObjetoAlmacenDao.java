package services;
import java.util.List;

import javax.persistence.EntityManager;

import entities.IngResidente;
import entities.Objeto;
import entities.ObjetoAlmacen;
import services.GenericDao;
import util.Conexion;


public class ObjetoAlmacenDao extends Conexion<ObjetoAlmacen> implements GenericDao<ObjetoAlmacen> {
	
public ObjetoAlmacenDao(){
		super(ObjetoAlmacen.class);
	}

//public List<ObjetoAlmacen> MostrarObjetosAlmacen(int id){
//	
//	 EntityManager em = Conexion.getEm();
//	 String query = "SELECT o.id_objeto,o.nombre,o.descripcion,o.unidad FROM objeto o inner join objeto_almacen oa ON o.id_objeto=oa.id_objeto WHERE oa.id_almacen="+id;
//	 List<ObjetoAlmacen> resultado;
//	 resultado = em.createNativeQuery(query, ObjetoAlmacen.class).getResultList();
//	 
////	 System.out.println("NOMBRE : "+resultado.get(0).getNombre());
//	return resultado;
//}

public ObjetoAlmacen obtenerObjAlmacenPorIdObjeto(int id) {
	EntityManager em = Conexion.getEm();
	 String query = "select * from objeto_almacen where id_objeto ="+id;
	 List<ObjetoAlmacen> resultado;
	 resultado = em.createNativeQuery(query, ObjetoAlmacen.class).getResultList();
	 ObjetoAlmacen obj = find(resultado.get(0).getIdObjetoAlmacen());
	 return obj;
}

public List<ObjetoAlmacen> objetosByAlmace(int idAlmacen){
	
	 EntityManager em = Conexion.getEm();
	 String query = "select * from objeto_almacen where id_almacen="+idAlmacen;
	 List<ObjetoAlmacen> resultado;
	 resultado = em.createNativeQuery(query, ObjetoAlmacen.class).getResultList();
	return resultado;
}
}
