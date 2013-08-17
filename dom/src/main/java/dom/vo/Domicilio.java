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
public class Domicilio {
    

    @Persistent
    private String barrio;
    @Persistent
    private String calle;
    @Persistent
    private String altura;
    
    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    
  
	
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
	
    public String title()
    {
    	return this.getBarrio() + ""+ this.getCalle() + "" + this.getAltura();
    }
 

}
