package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the control_objeto_almacen database table.
 * 
 */
@Entity
@Table(name="control_objeto_almacen")
@NamedQuery(name="ControlObjetoAlmacen.findAll", query="SELECT c FROM ControlObjetoAlmacen c")
public class ControlObjetoAlmacen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_control_objeto_almacen")
	private int idControlObjetoAlmacen;

	@Column(name="cantidad_entrada")
	private int cantidadEntrada;

	@Column(name="cantidad_saldo")
	private int cantidadSaldo;

	@Column(name="cantidad_salida")
	private int cantidadSalida;

	@Column(name="destino_salida")
	private int destinoSalida;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String observacion;

	@Column(name="remision_entrada")
	private String remisionEntrada;

	@Column(name="unidad_entrada")
	private String unidadEntrada;

	@Column(name="unidad_saldo")
	private String unidadSaldo;

	@Column(name="unidad_salida")
	private String unidadSalida;

	//bi-directional many-to-one association to ObjetoAlmacen
	@ManyToOne
	@JoinColumn(name="id_objeto_almacen")
	private ObjetoAlmacen objetoAlmacen;

	public ControlObjetoAlmacen() {
	}

	public int getIdControlObjetoAlmacen() {
		return this.idControlObjetoAlmacen;
	}

	public void setIdControlObjetoAlmacen(int idControlObjetoAlmacen) {
		this.idControlObjetoAlmacen = idControlObjetoAlmacen;
	}

	public int getCantidadEntrada() {
		return this.cantidadEntrada;
	}

	public void setCantidadEntrada(int cantidadEntrada) {
		this.cantidadEntrada = cantidadEntrada;
	}

	public int getCantidadSaldo() {
		return this.cantidadSaldo;
	}

	public void setCantidadSaldo(int cantidadSaldo) {
		this.cantidadSaldo = cantidadSaldo;
	}

	public int getCantidadSalida() {
		return this.cantidadSalida;
	}

	public void setCantidadSalida(int cantidadSalida) {
		this.cantidadSalida = cantidadSalida;
	}

	public int getDestinoSalida() {
		return this.destinoSalida;
	}

	public void setDestinoSalida(int destinoSalida) {
		this.destinoSalida = destinoSalida;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getRemisionEntrada() {
		return this.remisionEntrada;
	}

	public void setRemisionEntrada(String remisionEntrada) {
		this.remisionEntrada = remisionEntrada;
	}

	public String getUnidadEntrada() {
		return this.unidadEntrada;
	}

	public void setUnidadEntrada(String unidadEntrada) {
		this.unidadEntrada = unidadEntrada;
	}

	public String getUnidadSaldo() {
		return this.unidadSaldo;
	}

	public void setUnidadSaldo(String unidadSaldo) {
		this.unidadSaldo = unidadSaldo;
	}

	public String getUnidadSalida() {
		return this.unidadSalida;
	}

	public void setUnidadSalida(String unidadSalida) {
		this.unidadSalida = unidadSalida;
	}

	public ObjetoAlmacen getObjetoAlmacen() {
		return this.objetoAlmacen;
	}

	public void setObjetoAlmacen(ObjetoAlmacen objetoAlmacen) {
		this.objetoAlmacen = objetoAlmacen;
	}

}