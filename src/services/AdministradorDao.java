package services;


import entities.Administrador;
import services.GenericDao;
import util.Conexion;


public class AdministradorDao extends Conexion<Administrador> implements GenericDao<Administrador> {
	
public AdministradorDao(){
		super(Administrador.class);
	}
}
