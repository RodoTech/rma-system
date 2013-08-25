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
public class Recepcion {
    
    @Persistent
    private String observacinones;
    @Persistent
    private LocalDate fechaIngreso;
    @Persistent
    private LocalDate fechaDespacho;
    @Persistent
    private Boolean paqueteCorrecto;
    @Persistent
    private Boolean aceptado;
    @Persistent 
    private Pedido pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public String getObservacinones() {
        return observacinones;
    }

    public void setObservacinones(String observacinones) {
        this.observacinones = observacinones;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(LocalDate fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public Boolean getPaqueteCorrecto() {
        return paqueteCorrecto;
    }

    public void setPaqueteCorrecto(Boolean paqueteCorrecto) {
        this.paqueteCorrecto = paqueteCorrecto;
    }

    public Boolean getAceptado() {
        return aceptado;
    }

    public void setAceptado(Boolean aceptado) {
        this.aceptado = aceptado;
    }
    @SuppressWarnings("unused")
    private DomainObjectContainer container;
    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
 
    
}
