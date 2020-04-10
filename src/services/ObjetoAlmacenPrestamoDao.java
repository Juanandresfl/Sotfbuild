package services;


import entities.ObjetoAlmacenPrestamo;
import services.GenericDao;
import util.Conexion;


public class ObjetoAlmacenPrestamoDao extends Conexion<ObjetoAlmacenPrestamo> implements GenericDao<ObjetoAlmacenPrestamo> {
	
public ObjetoAlmacenPrestamoDao(){
		super(ObjetoAlmacenPrestamo.class);
	}
}
