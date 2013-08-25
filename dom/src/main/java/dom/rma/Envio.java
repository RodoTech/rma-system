/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.rma;

import javax.jdo.annotations.Persistent;
import org.apache.isis.applib.DomainObjectContainer;
import org.joda.time.LocalDate;

/**
 *
 * @author Malgav5
 */
public class Envio {
    
    @Persistent
    private String observaciones;
    @Persistent
    private LocalDate fechaIgreso;
    @Persistent
    private LocalDate fechaEnvio;
    @Persistent 
    private String nroGuiaEnvio;
    @Persistent
    private Pedido pedido;

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDate getFechaIgreso() {
        return fechaIgreso;
    }

    public void setFechaIgreso(LocalDate fechaIgreso) {
        this.fechaIgreso = fechaIgreso;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getNroGuiaEnvio() {
        return nroGuiaEnvio;
    }

    public void setNroGuiaEnvio(String nroGuiaEnvio) {
        this.nroGuiaEnvio = nroGuiaEnvio;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    
    
    @SuppressWarnings("unused")
    private DomainObjectContainer container;
    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
}
