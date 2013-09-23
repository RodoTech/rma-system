package dom.customer;

import java.util.List;
import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.RegEx;

@Named("Cliente")
public class Customers extends  AbstractFactoryAndRepository {
   
    @MemberOrder(sequence = "1")
    
    @Named("Nuevo Cliente")
    public Customer newCustomer(
            @Named("Apellido") String apellido, 
            @Named("Nombre") String nombre,
            @RegEx(validation = "^([0-9])+$")@Named("Dni") String dni,
            @Named("empresa") String empresa,
             @RegEx(validation = "^([0-9])+$")@Named("nrocliente") String nroCliente,

            @Named("activo") Boolean activo) {
        
        return addCustomer(apellido,nombre,dni,empresa,nroCliente,activo);
    }

    @Hidden
    public Customer addCustomer(String apellido, String nombre,String Dni,String empresa,String NroCliente,Boolean activo) {
        
        final Customer customer = newTransientInstance(Customer.class);
        customer.setApellido(apellido);
        customer.setNombre(nombre);
        customer.setDni(Dni);
        customer.setEmpresa(empresa);
        customer.setNroCliente(NroCliente);
        customer.setActivo(activo);
        persist(customer);
        return customer;
    }

    @ActionSemantics(Of.SAFE)
    @Named("Lista Clientes")
    @MemberOrder(sequence = "2")
    public List<Customer> listCustomers() {
        final List<Customer> clientes;
        clientes = allInstances(Customer.class);
	return clientes; 
       
    }
   
    @MemberOrder(sequence = "3")
    @Named("Clientes activos")
    public List<Customer> activeCustomers() {
       
    
        final List<Customer> items = allMatches(Customer.class, Customer.allActivos(Boolean.TRUE));
        //Collections.sort(items);
        return items;
    }
        
    @MemberOrder(sequence = "4")
    @Named("Clientes inactivos")
    public List<Customer> inactiveCustomers() {
        final List<Customer> items = allMatches(Customer.class, Customer.allActivos(Boolean.FALSE));
        //Collections.sort(items);
        return items;
    }
     
    
}
