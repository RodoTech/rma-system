package dom.persona;

import javax.jdo.annotations.*;


import org.apache.isis.applib.AbstractDomainObject;

import org.apache.isis.applib.annotation.MemberOrder;



/**
 *
 * @author Malgav5
 */
@PersistenceCapable
@Inheritance(strategy= InheritanceStrategy.SUBCLASS_TABLE)
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY)
@Version(strategy=VersionStrategy.VERSION_NUMBER, column="VERSION")
public abstract class Persona extends AbstractDomainObject{
	@Persistent
    private String apellido;
	@Persistent
	private String nombre;
	@Persistent
    private String dni;
	@Persistent
    private String direccion;
	@Persistent
    private String telefono;
	 
	public String getApellido() {
	        return apellido;
	}
	
	@MemberOrder(name = "General", sequence = "2")
	public void setApellido(String apellido) {
	    this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}
	
	@MemberOrder(name = "General", sequence = "3")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
		
	public String getDni() {
		return dni;
	}
	
	@MemberOrder(name = "General", sequence = "4")
	public void setDni(String dni) {
		this.dni = dni;
	}
	 
	public String getDireccion() {
		return direccion;
	}
	
	@MemberOrder(name = "General", sequence = "5")
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
		
	public String getTelefono() {
		return telefono;
	}

	@MemberOrder(name = "General", sequence = "6")
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
