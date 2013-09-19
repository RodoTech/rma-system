/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.vo;

import dom.cliente.Cliente;
import javax.jdo.annotations.DatastoreIdentity;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Key;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Version;
import javax.jdo.annotations.VersionStrategy;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ObjectType;

/**
 *
 * @author Malgav5
 */
@PersistenceCapable
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY)
@Version(strategy=VersionStrategy.VERSION_NUMBER, column="VERSION")
@ObjectType("DATOSCONTACTO")
public class DatosContacto {



    public DatosContacto() {
    }

    public DatosContacto(String telefono, String fax, String email) {
        this.telefono = telefono;
        this.fax = fax;
        this.email = email;
    }
    

    @Persistent
    private String telefono;
    @Persistent
    private String fax;
    @Persistent 
    private String email;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
    public String title()
    {
    	return "Contacto: (tel) " + this.getTelefono() + "(fax)" + this.getFax() + " (email) " + this.getEmail();
    }
}
