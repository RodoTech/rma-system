package objstore.dflt.empleado;

import java.util.Date;
import java.util.List;
import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import dom.empleado.Empleado;
import dom.empleado.Empleados;


public class EmpleadosDefault extends AbstractFactoryAndRepository implements Empleados {
	  // {{ Id, iconName
    @Override
    public String getId() {
        return "empleados";
    }

    public String iconName() {
        return "Empleado";
    }
    // }}


	@Override
	@MemberOrder(sequence = "2")
	public List<Empleado> allEmpleados() {
		// TODO Auto-generated method stub
		return allInstances(Empleado.class);
	}

	@Override
	@MemberOrder(sequence = "1")
	public Empleado newEmpleado(@Named("Apellido") String apellido,
			@Named("Nombre") String nombre, 
			@Named("DNI") String dni,
		
			@Named("Legajo") String legajo,
			@Named("Fecha Ingreso") Date fechaingreso,
			@Named("Fecha Baja") Date fechabaja,
			@Named("Activo") Boolean activo) {
		
		Empleado empleado = newTransientInstance(Empleado.class);
		empleado.setApellido(apellido);
		empleado.setNombre(nombre);
		empleado.setDni(dni);
		empleado.setLegajo(legajo);
		empleado.setFechaingreso(fechaingreso);
		empleado.setFechabaja(fechabaja);
		empleado.setActivo(activo);
		persist(empleado);
		return empleado;
	}
	
	@Override
	@MemberOrder(sequence = "2")
	public Empleado deleteEmpleado(@Named("Apellido") String apellido,
			@Named("Nombre") String nombre, 
			@Named("DNI") String dni,
			@Named("Legajo") String legajo,
			@Named("Fecha Ingreso") Date fechaingreso,
			@Named("Fecha Baja") Date fechabaja,
			@Named("Activo") Boolean activo) {
		
		Empleado empleado = newTransientInstance(Empleado.class);
		empleado.setApellido(apellido);
		empleado.setNombre(nombre);
		empleado.setDni(dni);
		empleado.setLegajo(legajo);
		empleado.setFechaingreso(fechaingreso);
		empleado.setFechabaja(fechabaja);
		empleado.setActivo(activo);
		//delete(empleado);// (apellido, nombre, dni, legajo, fechaingreso, fechabaja, activo)(empleado);
		return empleado;
	}



}
