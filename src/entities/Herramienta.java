package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the herramienta database table.
 * 
 */
@Entity
@Table(name="herramienta")
@NamedQuery(name="Herramienta.findAll", query="SELECT h FROM Herramienta h")
public class Herramienta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_herramienta")
	private int idHerramienta;

	//bi-directional many-to-one association to Objeto
	@ManyToOne
	@JoinColumn(name="id_objeto")
	private Objeto objeto;

	public Herramienta() {
	}

	public int getIdHerramienta() {
		return this.idHerramienta;
	}

	public void setIdHerramienta(int idHerramienta) {
		this.idHerramienta = idHerramienta;
	}

	public Objeto getObjeto() {
		return this.objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

}