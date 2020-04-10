package entities;

import java.io.Serializable;

import javax.persistence.*;
import services.EmpleadoDao;

import java.util.List;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@Table(name="empleado")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empleado")
	private int idEmpleado;

	private String apellido;

	private String direccion;

	private String dni;

	private String nombre;

	private String pass;

	private String telefono;

	//bi-directional many-to-one association to Administrador
	@OneToMany(mappedBy="empleado")
	private List<Administrador> administradors;

	//bi-directional many-to-one association to Almacenista
	@OneToMany(mappedBy="empleado")
	private List<Almacenista> almacenistas;

	//bi-directional many-to-one association to IngResidente
	@OneToMany(mappedBy="empleado")
	private List<IngResidente> ingResidentes;

	public Empleado() {
	}

	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Administrador> getAdministradors() {
		return this.administradors;
	}

	public void setAdministradors(List<Administrador> administradors) {
		this.administradors = administradors;
	}

	public Administrador addAdministrador(Administrador administrador) {
		getAdministradors().add(administrador);
		administrador.setEmpleado(this);

		return administrador;
	}

	public Administrador removeAdministrador(Administrador administrador) {
		getAdministradors().remove(administrador);
		administrador.setEmpleado(null);

		return administrador;
	}

	public List<Almacenista> getAlmacenistas() {
		return this.almacenistas;
	}

	public void setAlmacenistas(List<Almacenista> almacenistas) {
		this.almacenistas = almacenistas;
	}

	public Almacenista addAlmacenista(Almacenista almacenista) {
		getAlmacenistas().add(almacenista);
		almacenista.setEmpleado(this);

		return almacenista;
	}

	public Almacenista removeAlmacenista(Almacenista almacenista) {
		getAlmacenistas().remove(almacenista);
		almacenista.setEmpleado(null);

		return almacenista;
	}

	public List<IngResidente> getIngResidentes() {
		return this.ingResidentes;
	}

	public void setIngResidentes(List<IngResidente> ingResidentes) {
		this.ingResidentes = ingResidentes;
	}

	public IngResidente addIngResidente(IngResidente ingResidente) {
		getIngResidentes().add(ingResidente);
		ingResidente.setEmpleado(this);

		return ingResidente;
	}

	public IngResidente removeIngResidente(IngResidente ingResidente) {
		getIngResidentes().remove(ingResidente);
		ingResidente.setEmpleado(null);

		return ingResidente;
	}
	public List<Empleado> ListarEmpleados()
	{
		System.out.println("ENTRO AQUI");
		EmpleadoDao eDao = new EmpleadoDao();
		return eDao.list();
	}
	
	

}