/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.rma;

import dom.cliente.Cliente;
import javax.jdo.annotations.Persistent;
import org.apache.isis.applib.DomainObjectContainer;
import org.joda.time.LocalDate;

/**
 *
 * @author Malgav5
 */
public class Pedido {
  
    @Persistent
    private String empresa;
    @Persistent
    private String telefono;
    @Persistent
    private String fax;
    @Persistent
    private String dni;
    @Persistent
    private String marca;
    @Persistent
    private String modelo;
    @Persistent
    private String numeroSerie;
    @Persistent
    private int cantidad;
    @Persistent
    private String accesorios;
    @Persistent
    private LocalDate fechaCompra;
    @Persistent
    private String descripcionAveria;
    @Persistent
    private Cliente cliente;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getDescripcionAveria() {
        return descripcionAveria;
    }

    public void setDescripcionAveria(String descripcionAveria) {
        this.descripcionAveria = descripcionAveria;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DomainObjectContainer getContainer() {
        return container;
    }

    public void setContainer(DomainObjectContainer container) {
        this.container = container;
    }
    
    
    
    
    @SuppressWarnings("unused")
    private DomainObjectContainer container;
    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
}
