package entities;

import java.io.Serializable;
import javax.persistence.*;

import services.IngResidenteDao;
import services.ObraDao;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the obra database table.
 * 
 */
@Entity
@Table(name="obra")
@NamedQuery(name = "Obra.findAll", query = "SELECT o FROM Obra o")
public class Obra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_obra")
	private int idObra;

	private String direccion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio")
	private Date fechaInicio;

	private String nombre;

	private String telefono;

	// bi-directional many-to-one association to Almacen
	@OneToMany(mappedBy = "obra")
	private List<Almacen> almacens;

	// bi-directional many-to-one association to IngResidente
	@ManyToOne
	@JoinColumn(name = "id_ing_residente")
	private IngResidente ingResidente;

	public Obra() {
	}

	public Obra(String direccion, Date fechaFin, Date fechaInicio, String nombre, String telefono,
			IngResidente ingResidente) {
		super();
		this.direccion = direccion;
		this.fechaFin = null;
		this.fechaInicio = fechaInicio;
		this.nombre = nombre;
		this.telefono = telefono;
		this.ingResidente = ingResidente;
	}

	public int getIdObra() {
		return this.idObra;
	}

	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
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

	public List<Almacen> getAlmacens() {
		return this.almacens;
	}

	public void setAlmacens(List<Almacen> almacens) {
		this.almacens = almacens;
	}

	public Almacen addAlmacen(Almacen almacen) {
		getAlmacens().add(almacen);
		almacen.setObra(this);

		return almacen;
	}

	public Almacen removeAlmacen(Almacen almacen) {
		getAlmacens().remove(almacen);
		almacen.setObra(null);

		return almacen;
	}

	public IngResidente getIngResidente() {
		return this.ingResidente;
	}

	public void setIngResidente(IngResidente ingResidente) {
		this.ingResidente = ingResidente;
	}

	public void registrar() {
		
		ObraDao oDao = new ObraDao();
		oDao.insert(this);
		
		IngResidenteDao ingDao = new IngResidenteDao();
		
		ingDao.find(ingResidente.getIdIngResidente()).setEstado("Ocupado");
		
		ingDao.update(ingResidente);
	}

}