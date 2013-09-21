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
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.MemberGroups;
import org.apache.isis.applib.annotation.ObjectType;
import org.joda.time.LocalDate;
import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Named;
/**
 *
 * @author Malgav5
 */
@PersistenceCapable(identityType=IdentityType.DATASTORE)
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY)
@Version(strategy=VersionStrategy.VERSION_NUMBER, column="VERSION")
@ObjectType("Envio")
@AutoComplete(repository=Envios.class, action="autoComplete")
@MemberGroups({"Datos Envio"})
public class Envio  extends AbstractDomainObject{
    @Named("Envio")
    public String title(){
        return this.getPedido().getProducto() + "-"  +  this.getFechaIgreso().toString();

    }
    @Persistent
    private String observaciones;
    @Persistent
    private LocalDate fechaIgreso;
    @Persistent
    private LocalDate fechaDespacho;
    @Persistent 
    private Pedido pedido;
    @Persistent
    private EmpresasTransporte  empresa;

    public EmpresasTransporte getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresasTransporte empresa) {
        this.empresa = empresa;
    }
    @Persistent 
    private String nroGuiaEnvio;

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

    public LocalDate getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(LocalDate fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getNroGuiaEnvio() {
        return nroGuiaEnvio;
    }

    public void setNroGuiaEnvio(String nroGuiaEnvio) {
        this.nroGuiaEnvio = nroGuiaEnvio;
    }

    @SuppressWarnings("unused")
    private DomainObjectContainer container;
    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
}