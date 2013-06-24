package dom.pedido;

import java.util.Date;
import java.util.List;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

import dom.cliente.Cliente;


@Named("Pedidos")
public interface Pedidos {

	 @MemberOrder(sequence="1")
	  public Pedido newPedido(
	        @Named("Cliente") Cliente cliente,
	        @Named("nrocaso") String nrocaso,
	        @Named("nroserieproducto") String nroserieproducto,
	        @Named("marca") String marca,
	        @Named("modelo") String modelo,
	        @Named("cantidad") Integer cantidad,
	        @Named("accesorios") String accesorios,
	        @Named("fechacompra") Date fechacompra,
	        @Named("averia") String averia	
	    		);
	  @MemberOrder(sequence="2")
	    public List<Pedido> allPedidos(); 

}
