package objstore.dflt.pedido;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.filter.Filter;

import dom.cliente.Cliente;
import dom.pedido.Pedido;
import dom.pedido.Pedidos;


public class PedidosDefault extends AbstractFactoryAndRepository implements Pedidos {
	  // {{ Id, iconName
    @Override
    public String getId() {
        return "pedidos";
    }

    public String iconName() {
        return "Pedido";
    }
    // }}
	@MemberOrder(sequence = "1")
	public Pedido newPedido(@Named("Cliente") Cliente cliente,
			@Named("nrocaso") String nrocaso,
			@Named("nroserieproducto") String nroserieproducto,
			@Named("marca") String marca,
			@Named("modelo") String modelo,
			@Named("cantidad") Integer cantidad,
			@Named("accesorios") String accesorios,
			@Named("fechacompra") Date fechacompra,
			@Named("averia") String averia) 
	
	{
		Pedido pedido = newTransientInstance(Pedido.class);
		pedido.setAccesorios(accesorios);
		pedido.setAveria(averia);
		pedido.setCantidad(cantidad);
		pedido.setCliente(cliente);
		pedido.setFechacompra(fechacompra);
		pedido.setMarca(marca);
		pedido.setModelo(modelo);
		pedido.setNrocaso(nrocaso);
		pedido.setNroserieproducto(nroserieproducto);
		
	    persist(pedido);
	    return pedido;
		
	}

	@Override
	@MemberOrder(sequence = "2")
	public List<Pedido> allPedidos() {
		 return allInstances(Pedido.class);
	}

}
