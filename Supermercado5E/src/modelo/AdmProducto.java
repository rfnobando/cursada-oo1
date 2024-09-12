package modelo;

import java.util.List;
import java.util.ArrayList;

public class AdmProducto {
	public List<Producto> lstProducto;
	
	public AdmProducto() {
		this.lstProducto = new ArrayList<>();
	}
	
	public boolean agregarProducto(String producto, float precio) {
		boolean productoExiste = false;
		int tamLstProducto = lstProducto.size();
		int id = 1;
		
		if(tamLstProducto > 0) {
			int i = 0;
			
			while(i < tamLstProducto && !productoExiste) {
				Producto productoTemp = lstProducto.get(i);
				
				if(productoTemp.getProducto().equals(producto)) {
					productoExiste = true;
				}
				
				i++;
			}
			
			if(!productoExiste) {
				id = lstProducto.get(tamLstProducto - 1).getIdProducto() + 1;
			}

		}
		
		return productoExiste ? false : lstProducto.add(new Producto(id, producto, precio));
	}
	
	public Producto traerProducto(int idProducto) {
		Producto productoBuscado = null;
		Producto productoTemporal;
		
		int i = 0;
		
		while(i < lstProducto.size() && productoBuscado == null) {
			productoTemporal = lstProducto.get(i);
			
			if(productoTemporal.getIdProducto() == idProducto) {
				productoBuscado = productoTemporal;
			}
			
			i++;
		}
		
		return productoBuscado;
	}
	
	public boolean modificarProducto(int idProducto, String producto, float precio) {
		Producto productoBuscado = traerProducto(idProducto);
		boolean productoFueModificado = false;
		
		if(productoBuscado != null) {
			productoBuscado.setProducto(producto);
			productoBuscado.setPrecio(precio);
			productoFueModificado = true;
		}
		
		return productoFueModificado;
	}
	
	public boolean eliminarProducto(int idProducto) {
		Producto productoBuscado = traerProducto(idProducto);
		boolean productoFueEliminado = false;
		
		if(productoBuscado != null) {
			productoFueEliminado = lstProducto.remove(productoBuscado);
		}
		
		return productoFueEliminado;
	}
	
	public List<Producto> getLstProducto() {
		return lstProducto;
	}
}
