package util;

import java.util.Date;
import java.util.List;

import entities.Almacen;
import entities.Empleado;
import entities.Obra;
import services.AlmacenDao;
import services.AlmacenistaDao;
import services.EmpleadoDao;
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
import services.IngResidenteDao;
import services.ObraDao;


public class Prueba {

	public Prueba() {
		// TODO Auto-generated constructor stub
	}
public static void main(String[] args) {
		
		
	EmpleadoDao eDao = new EmpleadoDao();
	Empleado e= new Empleado();
	e.setNombre("juan");
	e.setApellido("rodriguez");
	e.setDireccion("123");
	e.setTelefono("321");
	e.setPass("lol");
	e.setDni("10");
	System.out.println(eDao.BuscarDni("181818"));

}
}

