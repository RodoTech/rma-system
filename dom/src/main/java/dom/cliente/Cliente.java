package dom.cliente;

import com.google.common.base.Objects;
import dom.persona.Persona;
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
import dom.vo.DatosContacto;
import dom.vo.Domicilio;
import java.util.ArrayList;
import javax.jdo.annotations.Queries;
import javax.jdo.annotations.Query;
import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.PublishedAction;
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
@AutoComplete(repository=Cliente.class, action="autoComplete")
@MemberGroups({"Datos CLiente"})
public class Cliente extends  Persona  {

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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
  
    private  List<DatosContacto> datosContactos = new ArrayList<DatosContacto>();
  
    private  List<Domicilio> domicilios = new ArrayList<Domicilio>();
  
    /**
     *
     * @return
     */
    @Disabled
    @MemberOrder(sequence = "1")
    
    public List <DatosContacto> getDatosContacto() {
        return datosContactos;
    }
    
    private void setDatosContactos(List<DatosContacto> datosContactos) { 
        this.datosContactos = datosContactos;
    }
    
    @PublishedAction
    public void agregarDomicilio(@Named("Barrio")String Barrio,@Named("Calle")String Calle, @Named("Altura")String Altura) 
    {
      final  Domicilio domicilio = newTransientInstance(Domicilio.class);
        domicilio.setAltura(Altura);
        domicilio.setBarrio(Barrio);
        domicilio.setCalle(Calle);
        
        getDomicilios().add(domicilio);
      //  return this;
    }
    
    public List <Domicilio> getDomicilios() {
        return domicilios;
    }
    
    private void setDomicilios(List<Domicilio> Domicilios) { 
        this.domicilios = Domicilios;
    }
    
    @PublishedAction
    public Cliente addCorreo(@Named("Telefono")String Telefono,@Named("Fax")String Fax,@Named("Email")String email) {
        DatosContacto datos  = newTransientInstance(DatosContacto.class);
    datos.setEmail(email);
    datos.setFax(Fax);
    datos.setTelefono(Telefono);
        getDatosContacto().add(datos);
        return this;
    } 
    
    public Cliente()
    {
    }
    
   
    public String getNroCliente() {
            return nroCliente;
    }

    public void setNroCliente(String nroCliente) {
            this.nroCliente = nroCliente;
    }
    

    public Boolean getActivo() {
            return activo;
    }
    

    public void setActivo(Boolean activo) {
            this.activo = activo;
    }
    
    // {{ injected: DomainObjectContainer
    @SuppressWarnings("unused")
    private DomainObjectContainer container;
    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
    
    private ClientesRepo clientesRepo;
    public void injectClientesRepo(final ClientesRepo clientesRepo) {
        this.clientesRepo = clientesRepo;
    }
 
    public static Filter<Cliente> allActivos(final Boolean activo) {
        return new Filter<Cliente>() {
            @Override
            public boolean accept(final Cliente cliente) {
                return Objects.equal(cliente.getActivo(), activo);
            }

        };
    }
}
