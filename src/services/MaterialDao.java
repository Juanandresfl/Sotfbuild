package services;

import java.util.List;

import javax.persistence.EntityManager;

import entities.Material;
import services.GenericDao;
import util.Conexion;


public class MaterialDao extends Conexion<Material> implements GenericDao<Material> {
	
public MaterialDao(){
		super(Material.class);
	}
}
