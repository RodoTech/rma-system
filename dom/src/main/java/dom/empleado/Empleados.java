package dom.empleado;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;




@Named("Empleados")
public interface Empleados {
	 @MemberOrder(sequence="1")
	    public Empleado newEmpleado(
	        @Named("Apellido") String apellido,
	        @Named("Nombre") String nombre,
	        @Named("DNI") String dni,
	        @Named("Legajo") String legajo,
	        @Named("Fecha Ingreso") Date fechaingreso,
	        @Named("Fecha Baja") Date fechabaja,
	        @Named("Activo") Boolean activo
	    		
	    		);
	 @MemberOrder(sequence="2")
	    public List<Empleado> allEmpleados();
	Empleado deleteEmpleado( 
			@Named("Apellido")String apellido, 
			 @Named("Nombre")String nombre, 
			 @Named("DNI")String dni,
			 @Named("Legajo")String legajo, 
			 @Named("Fecha Ingreso")Date fechaingreso, 
			 @Named("Fecha Baja")Date fechabaja, 
			 @Named("Activo")Boolean activo); 	 

}