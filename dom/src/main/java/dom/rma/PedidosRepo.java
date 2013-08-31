/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Malgav5
 */
public class PedidosRepo extends  AbstractFactoryAndRepository {
    
    @MemberOrder(sequence = "1")
    public Pedido newPedido(
            @Named("Marca") String marca, 
            @Named("Modelo") String modelo,
            @Named("Numero Serie") String numeroSerie,
            @Named("Averia") String descripcionAveria,
            @Named("Cantidad") int cantidad,
            @Named("Accesorios") String accesorios,
            @Named("Fecha Compra") LocalDate fechaCompra,
            @Named("Cliente") Cliente cliente ) {
        return addPedido(marca,modelo,numeroSerie,descripcionAveria,cantidad,accesorios,fechaCompra,cliente);   
    }

    @Hidden
    public Pedido addPedido(String marca,String modelo,String descripcionAveria,String numeroSerie,int cantidad,String accesorios,LocalDate fechaCompra,Cliente cliente) {
        
        final Pedido pedido = newTransientInstance(Pedido.class);
        pedido.setAccesorios(accesorios);
        pedido.setCantidad(cantidad);
        pedido.setCliente(cliente);
        pedido.setDescripcionAveria(descripcionAveria);
        pedido.setNumeroSerie(numeroSerie);
        pedido.setFechaCompra(fechaCompra);
        pedido.setMarca(marca);
        pedido.setModelo(modelo);
        persist(pedido);
        return pedido;
    }
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "4")
    public List<Pedido> allPedidos() {
    	
    	 final List<Pedido> pedidos;
        pedidos = allInstances(Pedido.class);
		 return pedidos; 
       
    }

}