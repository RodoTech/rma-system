/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.rma;
import com.google.common.base.Objects;
import dom.cliente.Cliente;
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
import org.apache.isis.applib.annotation.MemberGroups;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.PublishedAction;
import org.apache.isis.applib.filter.Filter;
import org.apache.isis.applib.value.Money;
import org.joda.time.LocalDate;

/**
 *
 * @author Malgav5
 */

@PersistenceCapable(identityType=IdentityType.DATASTORE)
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY)
@Version(strategy=VersionStrategy.VERSION_NUMBER, column="VERSION")
@ObjectType("PEDIDO")
@AutoComplete(repository=PedidosRepo.class, action="autoComplete")
@MemberGroups({"Datos Pedido"})
public class Pedido  extends AbstractDomainObject{
  @Named("Pedido")
  public String title(){
      return  this.getMarca()+"-"+this.getNumeroSerie();
  }
  @Persistent
  private String marca;
  @Persistent
  private String modelo;
  @Persistent
  private String numeroSerie;
  @Persistent
  private int cantidad;
  @Persistent
  private String accesorios;
  @Persistent
  private LocalDate fechaCompra;
  @Persistent
  private String descripcionAveria;
  @Persistent
  private Cliente cliente;
  @Persistent
  private Recepcion recepcion;
  @Persistent
  private Reparacion reparacion;
  public Reparacion getReparacion() {
	  return reparacion;
  }
  public void setReparacion(Reparacion reparacion) {
	  this.reparacion = reparacion;
  } 
  
  public Recepcion getRecepcion() {
    return recepcion;
  }
  public void setRecepcion(Recepcion recepcion) {
    this.recepcion = recepcion;
  }
  private EstadosPedido estado;
  public EstadosPedido getEstado() {
       return estado;
  }
  public void setEstado(EstadosPedido estado) {
       this.estado = estado;
  }
  public String getMarca() {
       return marca;
  }
  public void setMarca(String marca) {
       this.marca = marca;
  }
  public String getModelo() {
       return modelo;
  }
  public void setModelo(String modelo) {
       this.modelo = modelo;
  }
  public String getNumeroSerie() {
       return numeroSerie;
  }
  public void setNumeroSerie(String numeroSerie) {
       this.numeroSerie = numeroSerie;
  }
  public int getCantidad() {
       return cantidad;
  }
  public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
  }
  public String getAccesorios() {
        return accesorios;
  }
  public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
  }
  public LocalDate getFechaCompra() {
        return fechaCompra;
  }
  public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
  }
  public String getDescripcionAveria() {
        return descripcionAveria;
  }
  public void setDescripcionAveria(String descripcionAveria) {
        this.descripcionAveria = descripcionAveria;
  }
  public Cliente getCliente() {
        return cliente;
  }
  public void setCliente(Cliente cliente) {
        this.cliente = cliente;
  }
  public static Filter<Pedido> allByState(final EstadosPedido estado) {
       return new Filter<Pedido>() {
            @Override
            public boolean accept(final Pedido pedido) {
                return Objects.equal(pedido.getEstado(), estado);
            }
        };
   }
  /**
   *
   * @author Malgav5
   * Permite asignar una recepcion al pedido , además cambia el estado del pedido a "Recibido"
   * Refactorizar para respetar normas
   */
  @PublishedAction
  public Pedido agregarRecepcion(String observacinones, LocalDate fechaIngreso, LocalDate fechaDespacho, Boolean paqueteCorrecto, Boolean aceptado) {
       Recepcion datos=newTransientInstance(Recepcion.class);
       if(getRecepcion()==null){
           datos  = newTransientInstance(Recepcion.class);}else
       {
            datos=getRecepcion();
       }
       datos.setAceptado(aceptado);
       datos.setFechaDespacho(fechaDespacho);
       datos.setFechaIngreso(fechaIngreso);
       datos.setObservacinones(observacinones);
       datos.setPaqueteCorrecto(paqueteCorrecto);
       this.setEstado(EstadosPedido.RECIBIDO);
       setRecepcion(datos);
       return this;
   } 
  
  @PublishedAction
  public Pedido agregarReparacion(@Named("Detalles")String detalleReparacion, @Named("Fecha ingreso Taller")LocalDate fechaIngreso, @Named("Fecha Reparacion")LocalDate fechaReparacion,@Named("Monto Reparación")Money montoReparacion,@Named("Observaciones")String observaciones,@Named("Reparacion Existosa")@Optional Boolean reparacionExistosa,@Named("Reparacion Terminada") Boolean terminado) {
       Reparacion datos;
       if(getReparacion()==null){
           datos  = newTransientInstance(Reparacion.class);}else
       {
            datos=getReparacion();
       }
       datos.setDetalleReparacion(detalleReparacion);
       datos.setFechaIngreso(fechaIngreso);
       datos.setFechaReparacion(fechaReparacion);
       datos.setMontoReparacion(montoReparacion);
       datos.setObservaciones(observaciones);
       datos.setReparacionExistosa(reparacionExistosa);
       datos.setTerminado(terminado);
       this.setReparacion(datos);
      
       return this;
   } 
  public DomainObjectContainer getContainer() {
        return container;
  }
  public void setContainer(DomainObjectContainer container) {
        this.container = container;
  }
  @SuppressWarnings("unused")
  private DomainObjectContainer container;
  public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
  }
}


