package dom.rma;
import com.google.common.base.Objects;
import dom.cliente.Customer;
import java.util.ArrayList;
import java.util.List;
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
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.PublishedAction;
import org.apache.isis.applib.annotation.RegEx;
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
@AutoComplete(repository=Orders.class, action="autoComplete")
@MemberGroups({"Datos Pedido"})
public class Order  extends AbstractDomainObject{
  @Named("Pedido")
  public String title(){
      return this.getCliente().getNroCliente() + " | " + this.getFechaPedido().toString()+" | " + this.getProducto() + "-" + this.getMarca() + "-" + this.getNumeroSerie();
  }
  @Persistent
  private String producto;

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
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
  private LocalDate fechaPedido;

  @Hidden
  public LocalDate getFechaPedido() {
      return fechaPedido;
  }

  public void setFechaPedido(LocalDate fechaPedido) {
      this.fechaPedido = fechaPedido;
  }
  
  @Persistent
  private String descripcionAveria;
  @Persistent
  private Customer cliente;
  @Persistent
  private Reception recepcion;
  @Persistent
  private Repair reparacion;
  
  private  List<Shipping> envios = new ArrayList<Shipping>();

  
  @MemberOrder(sequence = "2")
  public List<Shipping> getEnvios() {
     return envios;
  }

  public void setEnvios(List<Shipping> envios) {
     this.envios = envios;
  }
  
  public Repair getReparacion() {
      return reparacion;
  }
 
  public void setReparacion(Repair reparacion) {
	  this.reparacion = reparacion;
  } 
  
  public Reception getRecepcion() {
    return recepcion;
  }
  public void setRecepcion(Reception recepcion) {
    this.recepcion = recepcion;
  }
  private OrderStatus estado;
  
  public OrderStatus getEstado() {
       return estado;
  }
  public void setEstado(OrderStatus estado) {
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
  @RegEx(validation = "^([0-9])+$")
  public int getCantidad() {
       return cantidad;
  }
  @RegEx(validation = "^([0-9])+$")
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
  public Customer getCliente() {
        return cliente;
  }
  public void setCliente(Customer cliente) {
        this.cliente = cliente;
  }
  public static Filter<Order> allByState(final OrderStatus estado) {
       return new Filter<Order>() {
            @Override
            public boolean accept(final Order pedido) {
                return Objects.equal(pedido.getEstado(), estado);
            }
        };
   }
  
  @PublishedAction
  @MemberOrder(sequence = "1")
  public Order agregarRecepcion(@Named("Fecha Ingreso al sector")  LocalDate fechaIngreso,@Named("Observaciones") String observacinones,@Named("Paquete en perfecto estado")  Boolean paqueteCorrecto,@Named("Paquete aceptado")  Boolean aceptado,@Named("Fecha verificacion")  LocalDate fechaDespacho) {
       Reception datos;
       if(getRecepcion()==null){
           datos  = newTransientInstance(Reception.class);}else
       {
            datos=getRecepcion();
       }
       datos.setAceptado(aceptado);
       datos.setFechaDespacho(fechaDespacho);
       datos.setFechaIngreso(fechaIngreso);
       datos.setObservacinones(observacinones);
       datos.setPaqueteCorrecto(paqueteCorrecto);
       this.setEstado(OrderStatus.RECIBIDO);
       setRecepcion(datos);
       return this;
   } 
  
  @PublishedAction
  @MemberOrder(sequence = "2")
  public Order agregarReparacion(@Named("Detalles")String detalleReparacion, @Named("Fecha ingreso Taller")LocalDate fechaIngreso, @Named("Fecha Reparacion")LocalDate fechaReparacion,@Named("Monto Reparación")Money montoReparacion,@Named("Observaciones")String observaciones,@Named("Reparacion Existosa")@Optional Boolean reparacionExistosa,@Named("Reparacion Terminada") Boolean terminado) {
       Repair datos;
       if(getReparacion()==null){
           datos  = newTransientInstance(Repair.class);}else
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
  @PublishedAction
  @MemberOrder(sequence = "3")
  public Order agregarEnvio(@Named("Fechaingreso área")LocalDate fechaIgreso,@Named("Observaciones")String observaciones,@Named("Fecha despacho")@Optional LocalDate fechaDespacho,@Named("Empresa transporte")Carriers empresa,@Named("Nº GUIA Transporte")String nroGuiaEnvio) 
  {
      final  Shipping envio = newTransientInstance(Shipping.class);
      envio.setEmpresa(empresa);
      envio.setFechaDespacho(fechaDespacho);
      envio.setFechaIgreso(fechaIgreso);
      envio.setNroGuiaEnvio(nroGuiaEnvio);
      envio.setObservaciones(observaciones);
      getEnvios().add(envio);
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


