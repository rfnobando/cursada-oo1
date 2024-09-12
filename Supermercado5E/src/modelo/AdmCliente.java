package modelo;

import java.util.ArrayList;
import java.util.List;

public class AdmCliente {
	public List<Cliente> lstCliente;
	
	public AdmCliente() {
		this.lstCliente = new ArrayList<>();
	}
	
	public List<Cliente> getLstCliente() {
		return lstCliente;
	}
}
