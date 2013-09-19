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
import org.joda.time.LocalDate;

/**
 *
 * @author Malgav5
 */
@PersistenceCapable(identityType=IdentityType.DATASTORE)
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY)
@Version(strategy=VersionStrategy.VERSION_NUMBER, column="VERSION")
@ObjectType("Recepcion")
@AutoComplete(repository=RecepcionesRepo.class, action="autoComplete")

@MemberGroups({"Datos Recepcion"})
public class Recepcion  extends AbstractDomainObject{

      @Named("Empleado")
    public String title(){
        return this.getFechaIngreso().toString()+"-"+this.getObservacinones();

    }
    
    
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

    @Hidden
    public Pedido getPedido() {
        return pedido;
    }
    @Hidden
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
