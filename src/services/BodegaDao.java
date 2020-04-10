package services;


import java.util.List;

import javax.persistence.EntityManager;

import entities.Bodega;
import services.GenericDao;
import util.Conexion;


public class BodegaDao extends Conexion<Bodega> implements GenericDao<Bodega> {
	
public BodegaDao(){
		super(Bodega.class);
	}

public List<Bodega> Bodegas(){
	
	 EntityManager em = Conexion.getEm();
	 String query = "select * from bodega";
	 List<Bodega> resultado;
	 resultado = em.createNativeQuery(query,Bodega.class).getResultList();
	return resultado;
}
}
