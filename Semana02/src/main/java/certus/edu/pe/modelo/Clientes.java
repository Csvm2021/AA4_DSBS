package certus.edu.pe.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name ="clientes")
@NamedQueries({
	@NamedQuery(name="Clientes.findAll", query ="SELECT c FROM Clientes c")
	,@NamedQuery(name ="Clientes.findByIdCliente", query = "SELECT c FROM Clientes c WHERE c.idcliente = :idcliente")
	,@NamedQuery(name = "Clientes.findByNombre", query = "SELECT c FROM Clientes c WHERE c.nombre = :nombre")
	,@NamedQuery(name = "Clientes.findByApellido", query = "SELECT c FROM Clientes c WHERE c.apellido = :apellido")
	,@NamedQuery(name = "Clientes.findByDireccion", query = "SELECT c FROM Clientes c WHERE c.direccion = :direccion")
	,@NamedQuery(name = "Clientes.findByTelefono", query = "SELECT c FROM Clientes c WHERE c.telefono = :telefono")
	,@NamedQuery(name = "Clientes.findByMetodoPago", query = "SELECT c FROM Clientes c WHERE c.metodopago = :metodopago")})

public class Clientes implements Serializable{
	private static final long serialVersionUID=1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="idcliente")
	private Integer idcliente;
	
	@Basic(optional = false)
	@Column(name="nombre")
	private String nombre;
	
	@Basic(optional = false)
	@Column(name="apellido")
	private String apellido;
	
	@Basic(optional = false)
	@Column(name="direccion")
	private String direccion;
	
	@Basic(optional = false)
	@Column(name="telefono")
	private String telefono;
	
	@Basic(optional = false)
	@Column(name="metodopago")
	private String metodopago;
}
