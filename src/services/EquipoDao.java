package services;

import java.util.List;

import javax.persistence.EntityManager;

import entities.Equipo;
import services.GenericDao;
import util.Conexion;


public class EquipoDao extends Conexion<Equipo> implements GenericDao<Equipo> {
	
public EquipoDao(){
		super(Equipo.class);
	}
}
