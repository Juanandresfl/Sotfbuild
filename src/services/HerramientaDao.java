package services;

import java.util.List;

import javax.persistence.EntityManager;

import entities.Herramienta;
import services.GenericDao;
import util.Conexion;


public class HerramientaDao extends Conexion<Herramienta> implements GenericDao<Herramienta> {
	
public HerramientaDao(){
		super(Herramienta.class);
	}
}
