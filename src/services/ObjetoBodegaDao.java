package services;

import java.util.List;

import javax.persistence.EntityManager;

import entities.IngResidente;
import entities.ObjetoBodega;
import services.GenericDao;
import util.Conexion;


public class ObjetoBodegaDao extends Conexion<ObjetoBodega> implements GenericDao<ObjetoBodega> {
	
public ObjetoBodegaDao(){
		super(ObjetoBodega.class);
	}

public List<ObjetoBodega> objetosByAlmace(int idBodega){
	
	 EntityManager em = Conexion.getEm();
	 String query = "select * from objeto_bodega where id_bodega="+idBodega;
	 List<ObjetoBodega> resultado;
	 resultado = em.createNativeQuery(query, ObjetoBodega.class).getResultList();
	return resultado;
}
}
