package dom.cliente;

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
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ObjectType;

import dom.persona.Persona;
import dom.vo.Domicilio;
import dom.vo.Email;
import java.util.ArrayList;

import org.apache.isis.applib.annotation.PublishedAction;


/**
 *
 * @author Malgav5
 */
@PersistenceCapable(identityType=IdentityType.DATASTORE)
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY)
@Version(strategy=VersionStrategy.VERSION_NUMBER, column="VERSION")
@ObjectType("CLIENTE")
@AutoComplete(repository=Cliente.class, action="autoComplete")
@MemberGroups({"Datos CLiente"})
public class Cliente extends Persona  {
    @Named("Cliente")
    public String title(){
        return super.getApellido()+","+this.getNombre();

    }
    @Persistent
    private String nroCliente;
    @Persistent
    private Boolean activo;
    private  List<Email> emails = new ArrayList<Email>();
    private  List<Domicilio> domicilios = new ArrayList<Domicilio>();
    public List <Email> getEmails() {
        return emails;
    }
    
    private void setEmails(List<Email> emails) { 
        this.emails = emails;
    }
    
    @PublishedAction
    public Cliente agregarDomicilio(@Named("Barrio")String Barrio,@Named("Calle")String Calle, @Named("Altura")String Altura) 
    {
        Domicilio domicilio = new Domicilio();
        domicilio.setAltura(Altura);
        domicilio.setBarrio(Barrio);
        domicilio.setCalle(Calle);
        getDomicilios().add(domicilio);
        return this;
    }
    
    public List <Domicilio> getDomicilios() {
        return domicilios;
    }
    
    private void setDomicilios(List<Domicilio> Domicilios) { 
        this.domicilios = Domicilios;
    }
    
    @PublishedAction
    public Cliente addCorreo(String Email) {
        Email mail = new Email();
        mail.setDireccion(Email);
        getEmails().add(mail);
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
    

}
