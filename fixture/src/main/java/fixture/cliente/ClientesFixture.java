package fixture.cliente;

import org.apache.isis.applib.fixtures.AbstractFixture;

import dom.cliente.Cliente;
import dom.cliente.Clientes;


public class ClientesFixture extends AbstractFixture {
	
	
	 @Override
	    public void install() {
		 createCliente("Aguirre","Eduardo","32225478","Perito Moreno 115","298-4453116","eaguirre@dityc.com.ar");
		 createCliente("Carrasco","Jessica","33919816","Chacra 74","299-4123807","jessica_carrasco22@hotmail.com");
		 createCliente("Chrobak","Mario Alejandro","25548796","Int.Mariani 986","298-1234567","mchrobak@gmail.com");
	    }
	    
	    private Cliente createCliente(String apellido,String nombre, String dni, String direccion,String telefono, String email) {
	        return clientes.newCliente(apellido,nombre,dni,direccion,telefono,email);
	    }

	    
	    private Clientes clientes;
	    public void setClienteRepository(Clientes clientes) {
	        this.clientes = clientes;
	    }

}
