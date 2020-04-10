package entities;

import java.io.Serializable;
import javax.persistence.*;

import services.AlmacenDao;
import services.AlmacenistaDao;

import java.util.List;


/**
 * The persistent class for the almacen database table.
 * 
 */
@Entity
@Table(name="almacen")
@NamedQuery(name="Almacen.findAll", query="SELECT a FROM Almacen a")
public class Almacen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_almacen")
	private int idAlmacen;

	private String direccion;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Almacenista
	@ManyToOne
	@JoinColumn(name="id_almacenista")
	private Almacenista almacenista;

	//bi-directional many-to-one association to Obra
	@ManyToOne
	@JoinColumn(name="id_obra")
	private Obra obra;

	//bi-directional many-to-one association to ObjetoAlmacen
	@OneToMany(mappedBy="almacen")
	private List<ObjetoAlmacen> objetoAlmacens;

	//bi-directional many-to-one association to Prestamo
	@OneToMany(mappedBy="almacen1")
	private List<Prestamo> prestamos1;

	//bi-directional many-to-one association to Prestamo
	@OneToMany(mappedBy="almacen2")
	private List<Prestamo> prestamos2;

	public Almacen() {
	}

	public int getIdAlmacen() {
		return this.idAlmacen;
	}

	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Almacenista getAlmacenista() {
		return this.almacenista;
	}

	public void setAlmacenista(Almacenista almacenista) {
		this.almacenista = almacenista;
	}

	public Obra getObra() {
		return this.obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public List<ObjetoAlmacen> getObjetoAlmacens() {
		return this.objetoAlmacens;
	}

	public void setObjetoAlmacens(List<ObjetoAlmacen> objetoAlmacens) {
		this.objetoAlmacens = objetoAlmacens;
	}

	public ObjetoAlmacen addObjetoAlmacen(ObjetoAlmacen objetoAlmacen) {
		getObjetoAlmacens().add(objetoAlmacen);
		objetoAlmacen.setAlmacen(this);

		return objetoAlmacen;
	}

	public ObjetoAlmacen removeObjetoAlmacen(ObjetoAlmacen objetoAlmacen) {
		getObjetoAlmacens().remove(objetoAlmacen);
		objetoAlmacen.setAlmacen(null);

		return objetoAlmacen;
	}

	public List<Prestamo> getPrestamos1() {
		return this.prestamos1;
	}

	public void setPrestamos1(List<Prestamo> prestamos1) {
		this.prestamos1 = prestamos1;
	}

	public Prestamo addPrestamos1(Prestamo prestamos1) {
		getPrestamos1().add(prestamos1);
		prestamos1.setAlmacen1(this);

		return prestamos1;
	}

	public Prestamo removePrestamos1(Prestamo prestamos1) {
		getPrestamos1().remove(prestamos1);
		prestamos1.setAlmacen1(null);

		return prestamos1;
	}

	public List<Prestamo> getPrestamos2() {
		return this.prestamos2;
	}

	public void setPrestamos2(List<Prestamo> prestamos2) {
		this.prestamos2 = prestamos2;
	}

	public Prestamo addPrestamos2(Prestamo prestamos2) {
		getPrestamos2().add(prestamos2);
		prestamos2.setAlmacen2(this);

		return prestamos2;
	}

	public Prestamo removePrestamos2(Prestamo prestamos2) {
		getPrestamos2().remove(prestamos2);
		prestamos2.setAlmacen2(null);

		return prestamos2;
	}
	
	public Almacen(String direccion, String nombre, String telefono, Almacenista almacenista, Obra obra) {
		super();
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono = telefono;
		this.almacenista = almacenista;
		this.obra = obra;
	}
	public void registrar() {

		AlmacenDao aDao = new AlmacenDao();
		aDao.insert(this);

		AlmacenistaDao almacenistaDao = new AlmacenistaDao();

		almacenistaDao.find(almacenista.getIdAlmacenista()).setEstado("Ocupado");

		almacenistaDao.update(almacenista);
	}

}