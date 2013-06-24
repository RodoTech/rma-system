package objstore.dflt.cliente;


import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.Mask;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

import dom.cliente.Cliente;
import dom.cliente.Clientes;
import dom.pedido.Pedido;


public class ClientesDefault extends AbstractFactoryAndRepository implements Clientes {
	  // {{ Id, iconName
    @Override
    public String getId() {
        return "clientes";
    }

    public String iconName() {
        return "Cliente";
    }
    // }}


	@Override
	@MemberOrder(sequence = "2")
	public List<Cliente> allClientes() {
		// TODO Auto-generated method stub
		return  allInstances(Cliente.class);
	}

	@Override
	@MemberOrder(sequence = "1")
	public Cliente newCliente(
			
			@Named("Apellido") String apellido,
			@Named("Nombre") String nombre, @Named("DNI") String dni,
			@Named("Direccion") String direccion,
			@Named("E-Mail") String email,
			@Mask("(NNN)NNN-NNNN")@Named("Telefono") String telefono) {
		Cliente cliente = newTransientInstance(Cliente.class);
		cliente.setApellido(apellido);
		cliente.setNombre(nombre);
		cliente.setEmail(email);
		cliente.setDireccion(direccion);
		cliente.setTelefono(telefono);
		cliente.setDni(dni);
	
		persist(cliente);
		
		return cliente;
	}


	


}
