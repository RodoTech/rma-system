/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.rma;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.joda.time.LocalDate;
import org.apache.isis.applib.annotation.Hidden;
import dom.rma.Carriers;
/**
 *
 * @author Malgav5
 */
@Named("Envios")
public class Shipments extends  AbstractFactoryAndRepository {
  
    @MemberOrder(sequence = "1")
    public Shipping newEnvio(
            @Named("Observaciones") String observaciones, 
            @Named("Fecha Ingreso REcepcion") LocalDate fechaIgreso,
            @Named("Fecha Ingreso fechaReparacion") LocalDate fechaDespacho,
            @Named("Pedido") Order pedido,
            @Named("terminado") Carriers empresa,
            @Named("nroGuiaEnvio") String nroGuiaEnvio) {
        return addEnvio(observaciones,fechaIgreso,fechaDespacho,empresa,pedido,nroGuiaEnvio);   
       }
    @Hidden
    private Shipping addEnvio(String observaciones,LocalDate fechaIgreso,LocalDate fechaDespacho,Carriers empresa ,Order pedido,String nroGuiaEnvio)
    {
      final Shipping envio = newTransientInstance(Shipping.class);
        envio.setFechaDespacho(fechaDespacho);
        envio.setFechaIgreso(fechaIgreso);
        envio.setNroGuiaEnvio(nroGuiaEnvio);
        envio.setObservaciones(observaciones);
        envio.setPedido(pedido);
        persist(envio);
        return envio;
    }
}
