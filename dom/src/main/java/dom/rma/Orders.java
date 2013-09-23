package dom.rma;

import dom.customer.Customer;
import java.util.List;
import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Mask;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.joda.time.LocalDate;

@Named("Pedidos")
public class Orders extends  AbstractFactoryAndRepository {
    @Named("Nuevo Pedido")
    @MemberOrder(sequence = "1")
    public Order newPedido(
            @Named("Cliente")
            Customer cliente,
            @Named("Nombre Producto") String producto,
            @Named("Marca") String marca, 
            @Named("Modelo") String modelo,
            @Named("Numero Serie")@Mask("NNNNNN") String numeroSerie,
            @Named("Averia") String descripcionAveria,
            @Named("Cantidad") int cantidad,
            @Named("Accesorios") String accesorios,
            @Named("Fecha Compra") LocalDate fechaCompra
            ) {
        return addPedido(producto,marca,modelo,numeroSerie,descripcionAveria,cantidad,accesorios,fechaCompra,cliente);   
    }

    @Hidden
    public Order addPedido(String producto,String marca,String modelo,String descripcionAveria,String numeroSerie,int cantidad,String accesorios,LocalDate fechaCompra,Customer cliente) {
        
        final Order pedido = newTransientInstance(Order.class);
        pedido.setProducto(producto);
        pedido.setAccesorios(accesorios);
        pedido.setCantidad(cantidad);
        pedido.setCliente(cliente);
        pedido.setDescripcionAveria(descripcionAveria);
        pedido.setNumeroSerie(numeroSerie);
        pedido.setFechaCompra(fechaCompra);
        pedido.setMarca(marca);
        pedido.setFechaPedido(LocalDate.now());
        pedido.setModelo(modelo);
        pedido.setEstado(OrderStatus.UNKNOW);
        persist(pedido);
        return pedido;
    }
    
    @ActionSemantics(Of.SAFE)
    @Named("Lista pedidos")
    @MemberOrder(sequence = "2")
    public List<Order> listPedidos() {
    	
    	 final List<Order> Pedidos;
        Pedidos = allInstances(Order.class);
		 return Pedidos; 
       
    }
    @ActionSemantics(Of.SAFE)
    @Named("Pedidos Recibidos")
    @MemberOrder(sequence = "3")
    public List<Order> ordersReceived() {
       
    
        final List<Order> items = allMatches(Order.class, Order.allByState(OrderStatus.RECIBIDO));
        //Collections.sort(items);
        return items;
    }
    @ActionSemantics(Of.SAFE)
    @Named("Pedidos Rechazados")
    @MemberOrder(sequence = "4")
    public List<Order> OrdersRejected() {
        final List<Order> items = allMatches(Order.class, Order.allByState(OrderStatus.RECHAZADO));
        //Collections.sort(items);
        return items;
    }
    @ActionSemantics(Of.SAFE)
    @Named("Pedidos Rechazados")
    @MemberOrder(sequence = "6")
    public List<Order> ordersShipped() {
        final List<Order> items = allMatches(Order.class, Order.allByState(OrderStatus.ENVIANDOCE));
        //Collections.sort(items);
        return items;
    }
      @ActionSemantics(Of.SAFE)
    @Named("Pedidos en Reparación")
    @MemberOrder(sequence = "5")
    public List<Order> repairOders() {
        final List<Order> items = allMatches(Order.class, Order.allByState(OrderStatus.REPARANDOCE));
        //Collections.sort(items);
        return items;
    }
        
    @ActionSemantics(Of.SAFE)
        @Named("Pedidos en camino")
    @MemberOrder(sequence = "7")
    public List<Order> ordersOnTheWay() {
        final List<Order> items = allMatches(Order.class, Order.allByState(OrderStatus.UNKNOW));
        //Collections.sort(items);
        return items;
    }
}
