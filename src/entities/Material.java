package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the material database table.
 * 
 */
@Entity
@Table(name="material")
@NamedQuery(name="Material.findAll", query="SELECT m FROM Material m")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_material")
	private int idMaterial;

	//bi-directional many-to-one association to Objeto
	@ManyToOne
	@JoinColumn(name="id_objeto")
	private Objeto objeto;

	public Material() {
	}

	public int getIdMaterial() {
		return this.idMaterial;
	}

	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}

	public Objeto getObjeto() {
		return this.objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

}