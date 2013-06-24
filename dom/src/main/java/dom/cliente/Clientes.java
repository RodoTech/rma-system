package dom.cliente;



import java.util.List;

import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;




@Named("Clientes")
public interface Clientes {
	 @MemberOrder(sequence="1")
	  public Cliente newCliente(
		        @Named("Apellido") String apellido,
		        @Named("Nombre") String nombre,
		        @Named("DNI") String dni,
		        @Named("Direccion") String direccion,
		        @Named("E-Mail") String email,
		        @Named("Telefono") String telefono
			  );
	 			
	 @MemberOrder(sequence="2")
	    public List<Cliente> allClientes(); 	

}
