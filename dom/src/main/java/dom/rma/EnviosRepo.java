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
import dom.rma.EmpresasTransporte;
/**
 *
 * @author Malgav5
 */
public class EnviosRepo extends  AbstractFactoryAndRepository {
    /*
       @Persistent
    private String observaciones;
    @Persistent
    private LocalDate fechaIgreso;
    @Persistent
    private LocalDate fechaDespacho;
    @Persistent 
    private Pedido pedido;
    @Persistent
    private EmpresasTransporte  empresa;
    @Persistent 
    private String nroGuiaEnvio;
     */
       /**
     *
     * @param observaciones
     * @param fechaIgreso
     * @param fechaDespacho
     * @param pedido
     * @param empresa
     * @param nroGuiaEnvio
     * @return
     */
    @MemberOrder(sequence = "1")
    public Envio newEnvio(
            @Named("Observaciones") String observaciones, 
            @Named("Fecha Ingreso REcepcion") LocalDate fechaIgreso,
            @Named("Fecha Ingreso fechaReparacion") LocalDate fechaDespacho,
            @Named("Pedido") Pedido pedido,
            @Named("terminado") EmpresasTransporte empresa,
            @Named("nroGuiaEnvio") String nroGuiaEnvio) {
        return addEnvio(observaciones,fechaIgreso,fechaDespacho,empresa,pedido,nroGuiaEnvio);   
       }
    @Hidden
    private Envio addEnvio(String observaciones,LocalDate fechaIgreso,LocalDate fechaDespacho,EmpresasTransporte empresa ,Pedido pedido,String nroGuiaEnvio)
    {
      final Envio envio = newTransientInstance(Envio.class);
        envio.setFechaDespacho(fechaDespacho);
        envio.setFechaIgreso(fechaIgreso);
        envio.setNroGuiaEnvio(nroGuiaEnvio);
        envio.setObservaciones(observaciones);
        envio.setPedido(pedido);
            persist(envio);
        return envio;
    }
}
