package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the objeto database table.
 * 
 */
@Entity
@Table(name="objeto")
@NamedQuery(name="Objeto.findAll", query="SELECT o FROM Objeto o")
public class Objeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_objeto")
	private int idObjeto;

	private String descripcion;

	private String nombre;

	private String unidad;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="objeto")
	private List<Equipo> equipos;

	//bi-directional many-to-one association to Herramienta
	@OneToMany(mappedBy="objeto")
	private List<Herramienta> herramientas;

	//bi-directional many-to-one association to Material
	@OneToMany(mappedBy="objeto")
	private List<Material> materials;

	//bi-directional many-to-one association to ObjetoAlmacen
	@OneToMany(mappedBy="objeto")
	private List<ObjetoAlmacen> objetoAlmacens;

	//bi-directional many-to-one association to ObjetoBodega
	@OneToMany(mappedBy="objeto")
	private List<ObjetoBodega> objetoBodegas;

	public Objeto() {
	}

	public int getIdObjeto() {
		return this.idObjeto;
	}

	public void setIdObjeto(int idObjeto) {
		this.idObjeto = idObjeto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public List<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo addEquipo(Equipo equipo) {
		getEquipos().add(equipo);
		equipo.setObjeto(this);

		return equipo;
	}

	public Equipo removeEquipo(Equipo equipo) {
		getEquipos().remove(equipo);
		equipo.setObjeto(null);

		return equipo;
	}

	public List<Herramienta> getHerramientas() {
		return this.herramientas;
	}

	public void setHerramientas(List<Herramienta> herramientas) {
		this.herramientas = herramientas;
	}

	public Herramienta addHerramienta(Herramienta herramienta) {
		getHerramientas().add(herramienta);
		herramienta.setObjeto(this);

		return herramienta;
	}

	public Herramienta removeHerramienta(Herramienta herramienta) {
		getHerramientas().remove(herramienta);
		herramienta.setObjeto(null);

		return herramienta;
	}

	public List<Material> getMaterials() {
		return this.materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public Material addMaterial(Material material) {
		getMaterials().add(material);
		material.setObjeto(this);

		return material;
	}

	public Material removeMaterial(Material material) {
		getMaterials().remove(material);
		material.setObjeto(null);

		return material;
	}

	public List<ObjetoAlmacen> getObjetoAlmacens() {
		return this.objetoAlmacens;
	}

	public void setObjetoAlmacens(List<ObjetoAlmacen> objetoAlmacens) {
		this.objetoAlmacens = objetoAlmacens;
	}

	public ObjetoAlmacen addObjetoAlmacen(ObjetoAlmacen objetoAlmacen) {
		getObjetoAlmacens().add(objetoAlmacen);
		objetoAlmacen.setObjeto(this);

		return objetoAlmacen;
	}

	public ObjetoAlmacen removeObjetoAlmacen(ObjetoAlmacen objetoAlmacen) {
		getObjetoAlmacens().remove(objetoAlmacen);
		objetoAlmacen.setObjeto(null);

		return objetoAlmacen;
	}

	public List<ObjetoBodega> getObjetoBodegas() {
		return this.objetoBodegas;
	}

	public void setObjetoBodegas(List<ObjetoBodega> objetoBodegas) {
		this.objetoBodegas = objetoBodegas;
	}

	public ObjetoBodega addObjetoBodega(ObjetoBodega objetoBodega) {
		getObjetoBodegas().add(objetoBodega);
		objetoBodega.setObjeto(this);

		return objetoBodega;
	}

	public ObjetoBodega removeObjetoBodega(ObjetoBodega objetoBodega) {
		getObjetoBodegas().remove(objetoBodega);
		objetoBodega.setObjeto(null);

		return objetoBodega;
	}

}