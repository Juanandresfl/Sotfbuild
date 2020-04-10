package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the objeto_bodega database table.
 * 
 */
@Entity
@Table(name="objeto_bodega")
@NamedQuery(name="ObjetoBodega.findAll", query="SELECT o FROM ObjetoBodega o")
public class ObjetoBodega implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_objeto_bodega")
	private int idObjetoBodega;

	private int cantidad;

	private String estado;

	private String observaciones;

	//bi-directional many-to-one association to Bodega
	@ManyToOne
	@JoinColumn(name="id_bodega")
	private Bodega bodega;

	//bi-directional many-to-one association to Objeto
	@ManyToOne
	@JoinColumn(name="id_objeto")
	private Objeto objeto;

	//bi-directional many-to-one association to ObjetoBodegaPrestamo
	@OneToMany(mappedBy="objetoBodega")
	private List<ObjetoBodegaPrestamo> objetoBodegaPrestamos;

	public ObjetoBodega() {
	}

	public int getIdObjetoBodega() {
		return this.idObjetoBodega;
	}

	public void setIdObjetoBodega(int idObjetoBodega) {
		this.idObjetoBodega = idObjetoBodega;
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

	public Bodega getBodega() {
		return this.bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public Objeto getObjeto() {
		return this.objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	public List<ObjetoBodegaPrestamo> getObjetoBodegaPrestamos() {
		return this.objetoBodegaPrestamos;
	}

	public void setObjetoBodegaPrestamos(List<ObjetoBodegaPrestamo> objetoBodegaPrestamos) {
		this.objetoBodegaPrestamos = objetoBodegaPrestamos;
	}

	public ObjetoBodegaPrestamo addObjetoBodegaPrestamo(ObjetoBodegaPrestamo objetoBodegaPrestamo) {
		getObjetoBodegaPrestamos().add(objetoBodegaPrestamo);
		objetoBodegaPrestamo.setObjetoBodega(this);

		return objetoBodegaPrestamo;
	}

	public ObjetoBodegaPrestamo removeObjetoBodegaPrestamo(ObjetoBodegaPrestamo objetoBodegaPrestamo) {
		getObjetoBodegaPrestamos().remove(objetoBodegaPrestamo);
		objetoBodegaPrestamo.setObjetoBodega(null);

		return objetoBodegaPrestamo;
	}

}