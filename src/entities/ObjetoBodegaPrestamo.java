package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the objeto_bodega_prestamo database table.
 * 
 */
@Entity
@Table(name="objeto_bodega_prestamo")
@NamedQuery(name="ObjetoBodegaPrestamo.findAll", query="SELECT o FROM ObjetoBodegaPrestamo o")
public class ObjetoBodegaPrestamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_objeto_bodega_prestamo")
	private int idObjetoBodegaPrestamo;

	private int cantidad;

	//bi-directional many-to-one association to ObjetoBodega
	@ManyToOne
	@JoinColumn(name="id_objeto_bodega")
	private ObjetoBodega objetoBodega;

	//bi-directional many-to-one association to Prestamo
	@ManyToOne
	@JoinColumn(name="id_prestamo")
	private Prestamo prestamo;

	public ObjetoBodegaPrestamo() {
	}

	public int getIdObjetoBodegaPrestamo() {
		return this.idObjetoBodegaPrestamo;
	}

	public void setIdObjetoBodegaPrestamo(int idObjetoBodegaPrestamo) {
		this.idObjetoBodegaPrestamo = idObjetoBodegaPrestamo;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ObjetoBodega getObjetoBodega() {
		return this.objetoBodega;
	}

	public void setObjetoBodega(ObjetoBodega objetoBodega) {
		this.objetoBodega = objetoBodega;
	}

	public Prestamo getPrestamo() {
		return this.prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

}