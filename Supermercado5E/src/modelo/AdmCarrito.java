package modelo;

import java.util.ArrayList;
import java.util.List;

public class AdmCarrito {
	public List<Carrito> lstCarrito;
	
	public AdmCarrito() {
		this.lstCarrito = new ArrayList<>();
	}
	
	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}
}
