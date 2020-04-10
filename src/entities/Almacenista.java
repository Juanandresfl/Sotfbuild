package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the almacenista database table.
 * 
 */
@Entity
@Table(name="almacenista")
@NamedQuery(name="Almacenista.findAll", query="SELECT a FROM Almacenista a")
public class Almacenista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_almacenista")
	private int idAlmacenista;

	private String estado;

	//bi-directional many-to-one association to Almacen
	@OneToMany(mappedBy="almacenista")
	private List<Almacen> almacens;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="id_empleado")
	private Empleado empleado;

	//bi-directional many-to-one association to Prestamo
	@OneToMany(mappedBy="almacenista")
	private List<Prestamo> prestamos;

	public Almacenista() {
	}

	public int getIdAlmacenista() {
		return this.idAlmacenista;
	}

	public void setIdAlmacenista(int idAlmacenista) {
		this.idAlmacenista = idAlmacenista;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Almacen> getAlmacens() {
		return this.almacens;
	}

	public void setAlmacens(List<Almacen> almacens) {
		this.almacens = almacens;
	}

	public Almacen addAlmacen(Almacen almacen) {
		getAlmacens().add(almacen);
		almacen.setAlmacenista(this);

		return almacen;
	}

	public Almacen removeAlmacen(Almacen almacen) {
		getAlmacens().remove(almacen);
		almacen.setAlmacenista(null);

		return almacen;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Prestamo> getPrestamos() {
		return this.prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public Prestamo addPrestamo(Prestamo prestamo) {
		getPrestamos().add(prestamo);
		prestamo.setAlmacenista(this);

		return prestamo;
	}

	public Prestamo removePrestamo(Prestamo prestamo) {
		getPrestamos().remove(prestamo);
		prestamo.setAlmacenista(null);

		return prestamo;
	}

}