package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bodega database table.
 * 
 */
@Entity
@Table(name="bodega")
@NamedQuery(name="Bodega.findAll", query="SELECT b FROM Bodega b")
public class Bodega implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_bodega")
	private int idBodega;

	private String direccion;

	private String nombre;

	private String telefono;

	//bi-directional one-to-one association to Prestamo
	@OneToOne
	@JoinColumn(name="id_bodega")
	private Prestamo prestamo;

	//bi-directional many-to-one association to ObjetoBodega
	@OneToMany(mappedBy="bodega")
	private List<ObjetoBodega> objetoBodegas;

	//bi-directional many-to-one association to Prestamo
	@OneToMany(mappedBy="bodega2")
	private List<Prestamo> prestamos;

	public Bodega() {
	}

	public int getIdBodega() {
		return this.idBodega;
	}

	public void setIdBodega(int idBodega) {
		this.idBodega = idBodega;
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

	public Prestamo getPrestamo() {
		return this.prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public List<ObjetoBodega> getObjetoBodegas() {
		return this.objetoBodegas;
	}

	public void setObjetoBodegas(List<ObjetoBodega> objetoBodegas) {
		this.objetoBodegas = objetoBodegas;
	}

	public ObjetoBodega addObjetoBodega(ObjetoBodega objetoBodega) {
		getObjetoBodegas().add(objetoBodega);
		objetoBodega.setBodega(this);

		return objetoBodega;
	}

	public ObjetoBodega removeObjetoBodega(ObjetoBodega objetoBodega) {
		getObjetoBodegas().remove(objetoBodega);
		objetoBodega.setBodega(null);

		return objetoBodega;
	}

	public List<Prestamo> getPrestamos() {
		return this.prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public Prestamo addPrestamo(Prestamo prestamo) {
		getPrestamos().add(prestamo);
		prestamo.setBodega2(this);

		return prestamo;
	}

	public Prestamo removePrestamo(Prestamo prestamo) {
		getPrestamos().remove(prestamo);
		prestamo.setBodega2(null);

		return prestamo;
	}

}