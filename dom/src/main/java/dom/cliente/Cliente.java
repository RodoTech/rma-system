package dom.cliente;



import org.apache.isis.applib.annotation.Hidden;

import dom.persona.Persona;

public class Cliente extends Persona {
	
	
	private String nrocliente;
	private Boolean activo;
	public String getNrocliente() {
		return nrocliente;
	}
	//Not visible for viewer
	@Hidden
	public void setNrocliente(String nrocliente) {
		this.nrocliente = nrocliente;
	}
	@Hidden
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
}
