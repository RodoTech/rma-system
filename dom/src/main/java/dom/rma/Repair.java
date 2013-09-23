/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.rma;

import javax.jdo.annotations.DatastoreIdentity;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Version;
import javax.jdo.annotations.VersionStrategy;
import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberGroups;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.value.Money;
import org.joda.time.LocalDate;

/**
 *
 * @author Malgav5
 */
@PersistenceCapable(identityType=IdentityType.DATASTORE)
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY)
@Version(strategy=VersionStrategy.VERSION_NUMBER, column="VERSION")
@ObjectType("Reparacion")
@AutoComplete(repository=Repairs.class, action="autoComplete")
@MemberGroups({"Datos Reparaciones"})
public class Repair  extends AbstractDomainObject{
      @Named("Reparacion")
    public String title(){
        return this.getPedido().getProducto() +"-" +  this.getFechaIngreso().toString();

    }
    @Persistent
    private Order pedido;
    @Persistent
    private LocalDate fechaIngreso;
    @Persistent
    private LocalDate fechaReparacion;
    @Persistent
    private String observaciones;
    @Persistent
    private Boolean terminado;
    @Persistent
    private Boolean reparacionExistosa;
    @Persistent
    private String detalleReparacion;
    @Persistent 
    private Money montoReparacion;

    public Boolean getTerminado() {
        return terminado;
    }

    public void setTerminado(Boolean terminado) {
        this.terminado = terminado;
    }

    public Boolean getReparacionExistosa() {
        return reparacionExistosa;
    }

    public void setReparacionExistosa(Boolean reparacionExistosa) {
        this.reparacionExistosa = reparacionExistosa;
    }

    public String getDetalleReparacion() {
        return detalleReparacion;
    }

    public void setDetalleReparacion(String detalleReparacion) {
        this.detalleReparacion = detalleReparacion;
    }

    public Money getMontoReparacion() {
        return montoReparacion;
    }

    public void setMontoReparacion(Money montoReparacion) {
        this.montoReparacion = montoReparacion;
    }
    @Hidden
    public Order getPedido() {
        return pedido;
    }
    @Hidden
    public void setPedido(Order pedido) {
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