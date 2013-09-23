package dom.person;

import javax.jdo.annotations.*;


import org.apache.isis.applib.AbstractDomainObject;

import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.RegEx;



/**
 *
 * @author Malgav5
 */
@PersistenceCapable
@Inheritance(strategy= InheritanceStrategy.SUBCLASS_TABLE)
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY)
@Version(strategy=VersionStrategy.VERSION_NUMBER, column="VERSION")
public abstract class Person extends AbstractDomainObject{
    @Persistent
    private String apellido;
    @Persistent
    private String nombre;
    @Persistent
    private String dni;
	
 @MemberOrder(name = "General", sequence = "1")
    public String getApellido() {
	        return apellido;
    }
	
    @MemberOrder(name = "General", sequence = "1")
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    @MemberOrder(name = "General", sequence = "2")
    public String getNombre() {
        return nombre;
    }
	
    @MemberOrder(name = "General", sequence = "2")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
   @RegEx(validation = "^([0-9])+$")
    @MemberOrder(name = "General", sequence = "3")
    public String getDni() {
        return dni;
    }
	
    @MemberOrder(name = "General", sequence = "3")
    public void setDni(String dni) {
        this.dni = dni;
    }

}
