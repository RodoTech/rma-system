package dom.rma;

import dom.cliente.Cliente;
import java.util.List;
import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.joda.time.LocalDate;


public class Pedidos extends  AbstractFactoryAndRepository {
    
    @MemberOrder(sequence = "1")
    public Pedido newPedido(
            @Named("Nombre Producto") String producto,
            @Named("Marca") String marca, 
            @Named("Modelo") String modelo,
            @Named("Numero Serie") String numeroSerie,
            @Named("Averia") String descripcionAveria,
            @Named("Cantidad") int cantidad,
            @Named("Accesorios") String accesorios,
            @Named("Fecha Compra") LocalDate fechaCompra,
            @Named("Cliente") Cliente cliente ) {
        return addPedido(producto,marca,modelo,numeroSerie,descripcionAveria,cantidad,accesorios,fechaCompra,cliente);   
    }

    @Hidden
    public Pedido addPedido(String producto,String marca,String modelo,String descripcionAveria,String numeroSerie,int cantidad,String accesorios,LocalDate fechaCompra,Cliente cliente) {
        
        final Pedido pedido = newTransientInstance(Pedido.class);
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
        pedido.setEstado(EstadosPedido.UNKNOW);
        persist(pedido);
        return pedido;
    }
    
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "2")
    public List<Pedido> listaPedidos() {
    	
    	 final List<Pedido> Pedidos;
        Pedidos = allInstances(Pedido.class);
		 return Pedidos; 
       
    }
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "3")
    public List<Pedido> listaPedidosRecibidos() {
       
    
        final List<Pedido> items = allMatches(Pedido.class, Pedido.allByState(EstadosPedido.RECIBIDO));
        //Collections.sort(items);
        return items;
    }
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "4")
    public List<Pedido> listaPedidosRechazados() {
        final List<Pedido> items = allMatches(Pedido.class, Pedido.allByState(EstadosPedido.RECHAZADO));
        //Collections.sort(items);
        return items;
    }
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "6")
    public List<Pedido> listaPedidosEnviados() {
        final List<Pedido> items = allMatches(Pedido.class, Pedido.allByState(EstadosPedido.ENVIANDOCE));
        //Collections.sort(items);
        return items;
    }
        @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "5")
    public List<Pedido> listaPedidosEnReparacion() {
        final List<Pedido> items = allMatches(Pedido.class, Pedido.allByState(EstadosPedido.REPARANDOCE));
        //Collections.sort(items);
        return items;
    }
        
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "7")
    public List<Pedido> listaPedidosPorLlegar() {
        final List<Pedido> items = allMatches(Pedido.class, Pedido.allByState(EstadosPedido.UNKNOW));
        //Collections.sort(items);
        return items;
    }
}