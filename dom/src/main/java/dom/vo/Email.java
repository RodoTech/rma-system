package dom.vo;

import javax.jdo.annotations.Persistent;
import org.apache.isis.applib.DomainObjectContainer;
import javax.jdo.annotations.PersistenceCapable;

/**
 *
 * @author Malgav5
 */

@PersistenceCapable 
public class Email {

   
    @Persistent
    private String direccion;
  
    public String getDireccion() {
            return direccion;
    }
  
    public void setDireccion(String Direccion) {
            this.direccion = Direccion;
    }
	
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
	
    public String title()
    {
    	return this.direccion;
    }
 

}
