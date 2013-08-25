/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.empleado;


import java.util.List;
import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;


/**
 *
 * @author Malgav5
 */

@Named("Empleado")
public class EmpleadosRepo extends  AbstractFactoryAndRepository {
   
    @MemberOrder(sequence = "1")
    public Empleado newEmpleado(
            @Named("Apellido") String apellido, 
            @Named("Nombre") String nombre,
            @Named("Dni") String dni,
            @Named("telefono") String telefono,
            @Named("NroLegajo") String NroLegajo,
            @Named("activo") Boolean activo) {
        
        return addEmpleado(apellido,nombre,dni,telefono,NroLegajo,activo);
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
    public Empleado addEmpleado(String apellido, String nombre,String Dni,
    String Telefono,String NroLegajo,Boolean activo) {
        
        final Empleado empleado = newTransientInstance(Empleado.class);
        empleado.setApellido(apellido);
        empleado.setNombre(nombre);
        empleado.setDni(Dni);

        empleado.setNroLegajo(NroLegajo);

        empleado.setActivo(activo);
        persist(empleado);
        return empleado;
    }

    @ActionSemantics(ActionSemantics.Of.SAFE)
    @MemberOrder(sequence = "4")
    public List<Empleado> allEmpleados() {
    	
    	 final List<Empleado> empleados;
        empleados = allInstances(Empleado.class);
		 return empleados; 
       
    }

}