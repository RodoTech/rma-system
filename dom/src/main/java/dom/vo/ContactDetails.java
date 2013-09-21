/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.vo;

import dom.cliente.Customer;
import javax.jdo.annotations.DatastoreIdentity;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Key;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Version;
import javax.jdo.annotations.VersionStrategy;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.RegEx;

/**
 *
 * @author Malgav5
 */
@PersistenceCapable
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY)
@Version(strategy=VersionStrategy.VERSION_NUMBER, column="VERSION")
@ObjectType("DATOSCONTACTO")
public class ContactDetails {



    public ContactDetails() {
    }

    public ContactDetails(String telefono, String fax, String email) {
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

    @MemberOrder(name = "Datos de contacto", sequence = "1")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    @MemberOrder(name = "Datos de contacto", sequence = "2")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    @MemberOrder(name = "Datos de contacto", sequence = "3")
    @RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")
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
