package dom.empleado;


import dom.persona.Person;

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

@PersistenceCapable(identityType=IdentityType.DATASTORE)
@DatastoreIdentity(strategy=IdGeneratorStrategy.IDENTITY)
@Version(strategy=VersionStrategy.VERSION_NUMBER, column="VERSION")
@ObjectType("EMPLEADO")
@AutoComplete(repository=Staff.class, action="autoComplete")
@MemberGroups({"DATOS EMPLEADO"})
public class Employee extends Person {
    /**
     *
     * @return
     */
    @Named("Empleado")
    public String title(){
        return super.getApellido()+","+this.getNombre();

    }
    @Persistent
    private String nroLegajo;

    @Persistent
    private boolean activo;
    

    public String getNroLegajo() {
        return nroLegajo;
    }

    public void setNroLegajo(String nroLegajo) {
        this.nroLegajo = nroLegajo;
    }



    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

   
   /* 
    private  List<Email> emails = new ArrayList<Email>();
    private  List<Domicilio> domicilios = new ArrayList<Domicilio>();
    public List <Email> getEmails() {
        return emails;
    }
    
    private void setEmails(List<Email> emails) { 
        this.emails = emails;
    }
    
    @PublishedAction
    public Employee agregarDomicilio(@Named("Barrio")String Barrio,@Named("Calle")String Calle, @Named("Altura")String Altura) 
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
    public Employee addCorreo(String Email) {
        Email mail = new Email();
        mail.setDireccion(Email);
        getEmails().add(mail);
        return this;
    } 
    */
    // {{ injected: DomainObjectContainer
    @SuppressWarnings("unused")
    private DomainObjectContainer container;
    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
 
    private Staff empleadosRepo;
    public void injectEmpleadosRepo(final Staff empleadosRepo) {
        this.empleadosRepo = empleadosRepo;
    }
    
    
}
