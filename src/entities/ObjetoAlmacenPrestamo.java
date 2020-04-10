package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the objeto_almacen_prestamo database table.
 * 
 */
@Entity
@Table(name="objeto_almacen_prestamo")
@NamedQuery(name="ObjetoAlmacenPrestamo.findAll", query="SELECT o FROM ObjetoAlmacenPrestamo o")
public class ObjetoAlmacenPrestamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_objeto_almacen_prestamo")
	private int idObjetoAlmacenPrestamo;

	private int cantidad;

	//bi-directional many-to-one association to ObjetoAlmacen
	@ManyToOne
	@JoinColumn(name="id_objeto_almacen")
	private ObjetoAlmacen objetoAlmacen;

	//bi-directional many-to-one association to Prestamo
	@ManyToOne
	@JoinColumn(name="id_prestamo")
	private Prestamo prestamo;

	public ObjetoAlmacenPrestamo() {
	}

	public int getIdObjetoAlmacenPrestamo() {
		return this.idObjetoAlmacenPrestamo;
	}

	public void setIdObjetoAlmacenPrestamo(int idObjetoAlmacenPrestamo) {
		this.idObjetoAlmacenPrestamo = idObjetoAlmacenPrestamo;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ObjetoAlmacen getObjetoAlmacen() {
		return this.objetoAlmacen;
	}

	public void setObjetoAlmacen(ObjetoAlmacen objetoAlmacen) {
		this.objetoAlmacen = objetoAlmacen;
	}

	public Prestamo getPrestamo() {
		return this.prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

}