/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.vo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import org.apache.isis.applib.DomainObjectContainer;

/**
 *
 * @author Malgav5
 */
@PersistenceCapable 
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
