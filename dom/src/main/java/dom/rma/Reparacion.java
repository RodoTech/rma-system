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
public class Reparacion {
  
    @Persistent
    private Pedido pedido;
    @Persistent
    private LocalDate fechaIngreso;
    @Persistent
    private LocalDate fechaReparacion;
    @Persistent
    private String observaciones;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaReparacion() {
        return fechaReparacion;
    }

    public void setFechaReparacion(LocalDate fechaReparacion) {
        this.fechaReparacion = fechaReparacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
   
    
    
    @SuppressWarnings("unused")
    private DomainObjectContainer container;
    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
}
