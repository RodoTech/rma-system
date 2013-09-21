/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.rma;

import java.util.List;
import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.joda.time.LocalDate;

/**
 *
 * @author Malgav5
 */
@Named("Recepciones")
public class Receptions extends  AbstractFactoryAndRepository {
    @Hidden
    @MemberOrder(sequence = "1")
    public Reception newRecepcion(
            @Named("Observaciones") String observacinones, 
            @Named("Fecha Ingreso REcepcion") LocalDate fechaIngreso,
            @Named("Paquete correcto") Boolean paqueteCorrecto,
            @Named("Aceptado") Boolean aceptado,
            @Named("Aceptado") OrderStatus estado,
            @Named("Pedido") Order pedido ) {
        return addRecepcion(observacinones,fechaIngreso,paqueteCorrecto,aceptado,pedido,estado);   

    }

    @Hidden
    public Reception addRecepcion(String observacinones,LocalDate fechaIngreso,Boolean paqueteCorrecto,Boolean aceptado,Order pedido, OrderStatus estado) {
        
        final Reception recepcion = newTransientInstance(Reception.class);
        recepcion.setObservacinones(observacinones);
        recepcion.setFechaIngreso(fechaIngreso);
        recepcion.setPaqueteCorrecto(paqueteCorrecto);
        recepcion.setAceptado(aceptado);
        pedido.setEstado(estado);
        recepcion.setPedido(pedido);
        persist(recepcion);
        return recepcion;
    }
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "4")
    public List<Reception> allRecepciones() {
    	
    	 final List<Reception> recepciones;
        recepciones = allInstances(Reception.class);
		 return recepciones; 
       
    }

}
