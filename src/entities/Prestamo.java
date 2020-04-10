package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the prestamo database table.
 * 
 */
@Entity
@Table(name="prestamo")
@NamedQuery(name="Prestamo.findAll", query="SELECT p FROM Prestamo p")
public class Prestamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prestamo")
	private int idPrestamo;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String hora;

	@Column(name="id_bodega_origen")
	private int idBodegaOrigen;

	@Column(name="nombre_conductor")
	private String nombreConductor;

	@Column(name="placa_vehiculo")
	private String placaVehiculo;

	//bi-directional one-to-one association to Bodega
	@OneToOne(mappedBy="prestamo")
	private Bodega bodega1;

	//bi-directional many-to-one association to ObjetoAlmacenPrestamo
	@OneToMany(mappedBy="prestamo")
	private List<ObjetoAlmacenPrestamo> objetoAlmacenPrestamos;

	//bi-directional many-to-one association to ObjetoBodegaPrestamo
	@OneToMany(mappedBy="prestamo")
	private List<ObjetoBodegaPrestamo> objetoBodegaPrestamos;

	//bi-directional many-to-one association to Almacen
	@ManyToOne
	@JoinColumn(name="id_almacen_origen")
	private Almacen almacen1;

	//bi-directional many-to-one association to Almacen
	@ManyToOne
	@JoinColumn(name="id_almacen_destino")
	private Almacen almacen2;

	//bi-directional many-to-one association to Almacenista
	@ManyToOne
	@JoinColumn(name="id_almacenista")
	private Almacenista almacenista;

	//bi-directional many-to-one association to Bodega
	@ManyToOne
	@JoinColumn(name="id_bodega_destino")
	private Bodega bodega2;

	public Prestamo() {
	}

	public int getIdPrestamo() {
		return this.idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getIdBodegaOrigen() {
		return this.idBodegaOrigen;
	}

	public void setIdBodegaOrigen(int idBodegaOrigen) {
		this.idBodegaOrigen = idBodegaOrigen;
	}

	public String getNombreConductor() {
		return this.nombreConductor;
	}

	public void setNombreConductor(String nombreConductor) {
		this.nombreConductor = nombreConductor;
	}

	public String getPlacaVehiculo() {
		return this.placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public Bodega getBodega1() {
		return this.bodega1;
	}

	public void setBodega1(Bodega bodega1) {
		this.bodega1 = bodega1;
	}

	public List<ObjetoAlmacenPrestamo> getObjetoAlmacenPrestamos() {
		return this.objetoAlmacenPrestamos;
	}

	public void setObjetoAlmacenPrestamos(List<ObjetoAlmacenPrestamo> objetoAlmacenPrestamos) {
		this.objetoAlmacenPrestamos = objetoAlmacenPrestamos;
	}

	public ObjetoAlmacenPrestamo addObjetoAlmacenPrestamo(ObjetoAlmacenPrestamo objetoAlmacenPrestamo) {
		getObjetoAlmacenPrestamos().add(objetoAlmacenPrestamo);
		objetoAlmacenPrestamo.setPrestamo(this);

		return objetoAlmacenPrestamo;
	}

	public ObjetoAlmacenPrestamo removeObjetoAlmacenPrestamo(ObjetoAlmacenPrestamo objetoAlmacenPrestamo) {
		getObjetoAlmacenPrestamos().remove(objetoAlmacenPrestamo);
		objetoAlmacenPrestamo.setPrestamo(null);

		return objetoAlmacenPrestamo;
	}

	public List<ObjetoBodegaPrestamo> getObjetoBodegaPrestamos() {
		return this.objetoBodegaPrestamos;
	}

	public void setObjetoBodegaPrestamos(List<ObjetoBodegaPrestamo> objetoBodegaPrestamos) {
		this.objetoBodegaPrestamos = objetoBodegaPrestamos;
	}

	public ObjetoBodegaPrestamo addObjetoBodegaPrestamo(ObjetoBodegaPrestamo objetoBodegaPrestamo) {
		getObjetoBodegaPrestamos().add(objetoBodegaPrestamo);
		objetoBodegaPrestamo.setPrestamo(this);

		return objetoBodegaPrestamo;
	}

	public ObjetoBodegaPrestamo removeObjetoBodegaPrestamo(ObjetoBodegaPrestamo objetoBodegaPrestamo) {
		getObjetoBodegaPrestamos().remove(objetoBodegaPrestamo);
		objetoBodegaPrestamo.setPrestamo(null);

		return objetoBodegaPrestamo;
	}

	public Almacen getAlmacen1() {
		return this.almacen1;
	}

	public void setAlmacen1(Almacen almacen1) {
		this.almacen1 = almacen1;
	}

	public Almacen getAlmacen2() {
		return this.almacen2;
	}

	public void setAlmacen2(Almacen almacen2) {
		this.almacen2 = almacen2;
	}

	public Almacenista getAlmacenista() {
		return this.almacenista;
	}

	public void setAlmacenista(Almacenista almacenista) {
		this.almacenista = almacenista;
	}

	public Bodega getBodega2() {
		return this.bodega2;
	}

	public void setBodega2(Bodega bodega2) {
		this.bodega2 = bodega2;
	}

}