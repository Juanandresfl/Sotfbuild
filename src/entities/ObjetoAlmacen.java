package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the objeto_almacen database table.
 * 
 */
@Entity
@Table(name="objeto_almacen")
@NamedQuery(name="ObjetoAlmacen.findAll", query="SELECT o FROM ObjetoAlmacen o")
public class ObjetoAlmacen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_objeto_almacen")
	private int idObjetoAlmacen;

	private int cantidad;

	private String estado;

	private String observaciones;

	@Column(name="propio_alquilado")
	private String propioAlquilado;

	//bi-directional many-to-one association to ControlObjetoAlmacen
	@OneToMany(mappedBy="objetoAlmacen")
	private List<ControlObjetoAlmacen> controlObjetoAlmacens;

	//bi-directional many-to-one association to Almacen
	@ManyToOne
	@JoinColumn(name="id_almacen")
	private Almacen almacen;

	//bi-directional many-to-one association to Objeto
	@ManyToOne
	@JoinColumn(name="id_objeto")
	private Objeto objeto;

	//bi-directional many-to-one association to ObjetoAlmacenPrestamo
	@OneToMany(mappedBy="objetoAlmacen")
	private List<ObjetoAlmacenPrestamo> objetoAlmacenPrestamos;

	public ObjetoAlmacen() {
	}

	public int getIdObjetoAlmacen() {
		return this.idObjetoAlmacen;
	}

	public void setIdObjetoAlmacen(int idObjetoAlmacen) {
		this.idObjetoAlmacen = idObjetoAlmacen;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPropioAlquilado() {
		return this.propioAlquilado;
	}

	public void setPropioAlquilado(String propioAlquilado) {
		this.propioAlquilado = propioAlquilado;
	}

	public List<ControlObjetoAlmacen> getControlObjetoAlmacens() {
		return this.controlObjetoAlmacens;
	}

	public void setControlObjetoAlmacens(List<ControlObjetoAlmacen> controlObjetoAlmacens) {
		this.controlObjetoAlmacens = controlObjetoAlmacens;
	}

	public ControlObjetoAlmacen addControlObjetoAlmacen(ControlObjetoAlmacen controlObjetoAlmacen) {
		getControlObjetoAlmacens().add(controlObjetoAlmacen);
		controlObjetoAlmacen.setObjetoAlmacen(this);

		return controlObjetoAlmacen;
	}

	public ControlObjetoAlmacen removeControlObjetoAlmacen(ControlObjetoAlmacen controlObjetoAlmacen) {
		getControlObjetoAlmacens().remove(controlObjetoAlmacen);
		controlObjetoAlmacen.setObjetoAlmacen(null);

		return controlObjetoAlmacen;
	}

	public Almacen getAlmacen() {
		return this.almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Objeto getObjeto() {
		return this.objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	public List<ObjetoAlmacenPrestamo> getObjetoAlmacenPrestamos() {
		return this.objetoAlmacenPrestamos;
	}

	public void setObjetoAlmacenPrestamos(List<ObjetoAlmacenPrestamo> objetoAlmacenPrestamos) {
		this.objetoAlmacenPrestamos = objetoAlmacenPrestamos;
	}

	public ObjetoAlmacenPrestamo addObjetoAlmacenPrestamo(ObjetoAlmacenPrestamo objetoAlmacenPrestamo) {
		getObjetoAlmacenPrestamos().add(objetoAlmacenPrestamo);
		objetoAlmacenPrestamo.setObjetoAlmacen(this);

		return objetoAlmacenPrestamo;
	}

	public ObjetoAlmacenPrestamo removeObjetoAlmacenPrestamo(ObjetoAlmacenPrestamo objetoAlmacenPrestamo) {
		getObjetoAlmacenPrestamos().remove(objetoAlmacenPrestamo);
		objetoAlmacenPrestamo.setObjetoAlmacen(null);

		return objetoAlmacenPrestamo;
	}

}