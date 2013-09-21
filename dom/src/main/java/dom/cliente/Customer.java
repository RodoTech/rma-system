package dom.cliente;

import com.google.common.base.Objects;
import dom.persona.Person;
import java.util.List;
import javax.jdo.annotations.DatastoreIdentity;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Version;
import javax.jdo.annotations.VersionStrategy;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.MemberGroups;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ObjectType;
import dom.vo.ContactDetails;
import dom.vo.Address;
import java.util.ArrayList;
import javax.jdo.annotations.Queries;
import javax.jdo.annotations.Query;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.PublishedAction;
import org.apache.isis.applib.annotation.RegEx;
import org.apache.isis.applib.filter.Filter;


/**
 *
 * @author Malgav5
 */
@PersistenceCapable(identityType=IdentityType.DATASTORE)
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY)
@Version(strategy=VersionStrategy.VERSION_NUMBER, column="VERSION")
@ObjectType("CLIENTE")
@Queries( {
    @Query(
            name="cliente_all", language="JDOQL",  
            value="SELECT FROM dom.cliente.Cliente ")
})
@AutoComplete(repository=Customers.class, action="autoComplete")
@MemberGroups({"Datos CLiente"})
public class Customer extends  Person  {

    @Named("Cliente")
    public String title(){
        return this.getApellido()+","+this.getNombre();
    }
    @Persistent
    private String nroCliente;
    @Persistent
    private Boolean activo;
    @Persistent
    private String empresa;
    @MemberOrder(name = "General", sequence = "4")  
    public String getEmpresa() {
        return empresa;
    }
    @MemberOrder(name = "General", sequence = "4")
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
  
    private  List<ContactDetails> datosContactos = new ArrayList<ContactDetails>();
    private  List<Address> domicilios = new ArrayList<Address>();
  
    @Disabled
    @MemberOrder(sequence = "1")
    public List <ContactDetails> getDatosContacto() {
        return datosContactos;
    }
    @MemberOrder(name = "General", sequence = "3")
    private void setDatosContactos(List<ContactDetails> datosContactos) { 
        this.datosContactos = datosContactos;
    }
    
    @PublishedAction
    @MemberOrder(sequence = "1")
    public Customer agregarDomicilio(@Named("Barrio")@Optional String Barrio,@Named("Calle")String Calle, @Named("Altura") @Optional String Altura) 
    {
        final  Address domicilio = newTransientInstance(Address.class);
        domicilio.setAltura(Altura);
        domicilio.setBarrio(Barrio);
        domicilio.setCalle(Calle);
        getDomicilios().add(domicilio);
        return this;
    }
    
    public List <Address> getDomicilios() {
        return domicilios;
    }
    @MemberOrder(name = "General", sequence = "3")
    private void setDomicilios(List<Address> Domicilios) { 
        this.domicilios = Domicilios;
    }
    
    @PublishedAction
    @MemberOrder(sequence = "2")
    public Customer agregarDatosContacto(@Named("Telefono")@Optional String Telefono,@Named("Fax")@Optional String Fax,@RegEx(validation = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+")@Named("Email")String email) {
        ContactDetails datos  = newTransientInstance(ContactDetails.class);
        datos.setEmail(email);
        datos.setFax(Fax);
        datos.setTelefono(Telefono);
        getDatosContacto().add(datos);
        return this;
    } 
    @RegEx(validation = "^([0-9])+$")
    @MemberOrder(name = "General", sequence = "5")
    public String getNroCliente() {
        return nroCliente;
    }
    @RegEx(validation = "^([0-9])+$")
    @MemberOrder(name = "General", sequence = "5")
    public void setNroCliente(String nroCliente) {
        this.nroCliente = nroCliente;
    }
    @MemberOrder(name = "General", sequence = "6")
    public Boolean getActivo() {
        return activo;
    }
    @MemberOrder(name = "General", sequence = "6")
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    // {{ injected: DomainObjectContainer
    @SuppressWarnings("unused")
    private DomainObjectContainer container;
    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
    
    private Customers clientesRepo;
    public void injectClientesRepo(final Customers clientesRepo) {
        this.clientesRepo = clientesRepo;
    }

    public static Filter<Customer> allActivos(final Boolean activo) {
        return new Filter<Customer>() {
            @Override
            public boolean accept(final Customer cliente) {
                return Objects.equal(cliente.getActivo(), activo);
            }

        };
    }
}
