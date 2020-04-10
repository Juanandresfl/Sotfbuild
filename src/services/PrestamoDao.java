package services;


import entities.Prestamo;
import services.GenericDao;
import util.Conexion;


public class PrestamoDao extends Conexion<Prestamo> implements GenericDao<Prestamo> {
	
public PrestamoDao(){
		super(Prestamo.class);
	}
}
