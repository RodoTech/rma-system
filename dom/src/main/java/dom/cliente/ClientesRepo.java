package dom.cliente;

import java.util.List;


import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ActionSemantics.Of;

@Named("Cliente")
public class ClientesRepo extends  AbstractFactoryAndRepository {
   
    @MemberOrder(sequence = "1")
    public Cliente nuevoCliente(
            @Named("Apellido") String apellido, 
            @Named("Nombre") String nombre,
            @Named("Dni") String dni,
            @Named("telefono") String telefono,
            @Named("nrocliente") String nroCliente,

            @Named("activo") Boolean activo) {
        
        return addCliente(apellido,nombre,dni,telefono,nroCliente,activo);
    }

    /**
     *
     * @param apellido
     * @param nombre
     * @param Dni
     * @param Telefono
     * @param NroCliente
     * @param activo
     * @return
     */
    @Hidden
    public Cliente addCliente(String apellido, String nombre,String Dni,
    String Telefono,String NroCliente,Boolean activo) {
        
        final Cliente cliente = newTransientInstance(Cliente.class);
        cliente.setApellido(apellido);
        cliente.setNombre(nombre);
        cliente.setDni(Dni);
       
        cliente.setNroCliente(NroCliente);
        cliente.setActivo(activo);
        persist(cliente);
        return cliente;
    }

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "2")
    public List<Cliente> listaClientes() {
    	
    	 final List<Cliente> clientes;
        clientes = allInstances(Cliente.class);
		 return clientes; 
       
    }
   
    @MemberOrder(sequence = "3")
    public List<Cliente> listaClientesActivos() {
       
    
        final List<Cliente> items = allMatches(Cliente.class, Cliente.allActivos(Boolean.TRUE));
        //Collections.sort(items);
        return items;
    }
        
    @MemberOrder(sequence = "4")
    public List<Cliente> listaClientesInactivos() {
        final List<Cliente> items = allMatches(Cliente.class, Cliente.allActivos(Boolean.FALSE));
        //Collections.sort(items);
        return items;
    }
     
    
}
