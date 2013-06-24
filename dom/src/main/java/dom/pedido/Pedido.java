package dom.pedido;

import java.util.Date;

import org.apache.isis.applib.AbstractDomainObject;


import dom.cliente.Cliente;



public class Pedido extends AbstractDomainObject {
	
	private Cliente cliente;
	private String nrocaso;
	private String nroserieproducto;
	private String marca;
	private String modelo;
	private Integer cantidad;
	private String accesorios;
	private Date fechacompra;
	private String averia;
	
	
	 // {{ Title
    public String title() {
        return this.cliente.getApellido() +","+ this.cliente.getNombre() +"-Pedido:"+ this.getNrocaso() ;
    }
    // }}
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNrocaso() {
		return nrocaso;
	}
	public void setNrocaso(String nrocaso) {
		this.nrocaso = nrocaso;
	}
	public String getNroserieproducto() {
		return nroserieproducto;
	}
	public void setNroserieproducto(String nroserieproducto) {
		this.nroserieproducto = nroserieproducto;
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
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getAccesorios() {
		return accesorios;
	}
	public void setAccesorios(String accesorios) {
		this.accesorios = accesorios;
	}
	public Date getFechacompra() {
		return fechacompra;
	}
	public void setFechacompra(Date fechacompra) {
		this.fechacompra = fechacompra;
	}
	public String getAveria() {
		return averia;
	}
	public void setAveria(String averia) {
		this.averia = averia;
	}
	
	
	
	
	

}
