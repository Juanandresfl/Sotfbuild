package entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the ing_residente database table.
 * 
 */
@Entity
@Table(name = "ing_residente")
@NamedQuery(name = "IngResidente.findAll", query = "SELECT i FROM IngResidente i")
public class IngResidente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ing_residente")
	private int idIngResidente;

	private String estado;

	// bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name = "id_empleado")
	private Empleado empleado;

	// bi-directional many-to-one association to Obra
	@OneToMany(mappedBy = "ingResidente")
	private List<Obra> obras;

	public IngResidente() {
	}

	public IngResidente(Empleado e) {
		super();
		this.empleado = e;
	}

	public IngResidente(int idIngResidente, String estado, Empleado empleado, List<Obra> obras) {
		super();
		this.idIngResidente = idIngResidente;
		this.estado = estado;
		this.empleado = empleado;
		this.obras = obras;
	}

	public int getIdIngResidente() {
		return this.idIngResidente;
	}

	public void setIdIngResidente(int idIngResidente) {
		this.idIngResidente = idIngResidente;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Obra> getObras() {
		return this.obras;
	}

	public void setObras(List<Obra> obras) {
		this.obras = obras;
	}

	public Obra addObra(Obra obra) {
		getObras().add(obra);
		obra.setIngResidente(this);

		return obra;
	}

	public Obra removeObra(Obra obra) {
		getObras().remove(obra);
		obra.setIngResidente(null);

		return obra;
	}

}