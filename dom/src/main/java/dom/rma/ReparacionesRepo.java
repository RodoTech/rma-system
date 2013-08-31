/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.rma;

import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.value.Money;
import org.joda.time.LocalDate;

/**
 *
 * @author Malgav5
 */
public class ReparacionesRepo extends  AbstractFactoryAndRepository {
     @MemberOrder(sequence = "1")
    public Reparacion newReparacion(
            @Named("Pedido") Pedido pedido, 
            @Named("Fecha Ingreso REcepcion") LocalDate fechaIngreso,
            @Named("Fecha Ingreso fechaReparacion") LocalDate fechaReparacion,
            @Named("Paquete String") String observaciones,
            @Named("terminado") Boolean terminado,
            @Named("reparacionExistosa") Boolean reparacionExistosa,
            @Named("Paquete detalleReparacion") String detalleReparacion,
            @Named("Paquete montoReparacion") Money montoReparacion) {
        return addReparacion(pedido,fechaIngreso,fechaReparacion,observaciones,terminado,reparacionExistosa,detalleReparacion,montoReparacion);   

    }

    @ActionSemantics(ActionSemantics.Of.SAFE)
    @MemberOrder(sequence = "4")
    public List<Reparacion> allReparaciones() {
    	
    	 final List<Reparacion> reparaciones;
        reparaciones = allInstances(Reparacion.class);
		 return reparaciones; 
       
    }
    @Hidden
    private Reparacion addReparacion(Pedido pedido, LocalDate fechaIngreso, LocalDate fechaReparacion, String observaciones, Boolean terminado, Boolean reparacionExistosa, String detalleReparacion, Money montoReparacion) {
  
        final Reparacion reparacion = newTransientInstance(Reparacion.class);
            reparacion.setPedido(pedido);
            reparacion.setFechaIngreso(fechaIngreso);
            reparacion.setFechaReparacion(fechaReparacion);
            reparacion.setObservaciones(observaciones);
            reparacion.setTerminado(terminado);
            reparacion.setReparacionExistosa(reparacionExistosa);
            reparacion.setDetalleReparacion(detalleReparacion);
            reparacion.setMontoReparacion(montoReparacion);
            persist(reparacion);
        return reparacion;
    }

}
