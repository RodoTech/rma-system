package dom.persona;

import java.lang.annotation.Target;

import org.apache.isis.applib.AbstractDomainObject;

import org.apache.isis.applib.annotation.Mask;
import org.apache.isis.applib.annotation.MaxLength;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.RegEx;

public class Persona extends AbstractDomainObject{
	 // {{ Title
    public String title() {
        return getApellido() + ", " + getNombre();
    }
    // }}
    private String apellido;
	private String nombre;
    private String dni;
    private String email;
    private String direccion;

    private String telefono;

    @MemberOrder(sequence = "1")
    public String getApellido() {
        return apellido;
    }
    @MaxLength(25)
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    // }}
    
	public String getNombre() {
		return nombre;
	}

	@MaxLength(25)
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}
	@RegEx(validation = "\\d+$")
	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}
	

	@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDireccion() {
		return direccion;
	}
	@MaxLength(150)
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	@Mask("###-#######")
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



}
