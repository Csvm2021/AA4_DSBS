package certus.edu.pe.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper=false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="carrito")
@NamedQueries({
	@NamedQuery(name="Carrito.findAll", query ="SELECT o FROM Carrito o")
	,@NamedQuery(name ="Carrito.findByIdCarrito", query = "SELECT o FROM Carrito o WHERE o.idcarrito = :idcarrito")
	,@NamedQuery(name = "Carrito.findByCantidad", query = "SELECT o FROM Carrito o WHERE o.cantidad = :cantidad")})

public class Carrito implements Serializable{
	private static final long serialVersionUID=1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="idcarrito")
	private Integer idcarrito;
	
	@JoinColumn(name = "clientesid", referencedColumnName = "idCliente")
	@ManyToOne(optional = false)
	private Clientes clientesid;
	
	@JoinColumn(name = "productosid", referencedColumnName = "idProducto")
	@ManyToOne(optional = false)
	private Productos productosid;
	
	@Basic(optional = false)
	@Column(name="cantidad")
	private Integer cantidad;
}
