package modelo;

import java.util.List;
import java.util.ArrayList;

public class Supermercado {
	private List<Producto> gondola;
	
	public Supermercado() {
		this.gondola = new ArrayList<>();
	}
	
	public boolean agregarProducto(String producto, float precio) {
		boolean productoExiste = false;
		int tamGondola = gondola.size();
		int id = 1;
		
		if(tamGondola > 0) {
			int i = 0;
			
			while(i < tamGondola && !productoExiste) {
				Producto productoTemp = gondola.get(i);
				
				if(productoTemp.getProducto().equals(producto)) {
					productoExiste = true;
				}
				
				i++;
			}
			
			if(!productoExiste) {
				id = gondola.get(tamGondola - 1).getIdProducto() + 1;
			}

		}
		
		return productoExiste ? false : gondola.add(new Producto(id, producto, precio));
	}
	
	public Producto traerProducto(int idProducto) {
		Producto productoBuscado = null;
		Producto productoTemporal;
		
		int i = 0;
		
		while(i < gondola.size() && productoBuscado == null) {
			productoTemporal = gondola.get(i);
			
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
			productoFueEliminado = gondola.remove(productoBuscado);
		}
		
		return productoFueEliminado;
	}
	
	public List<Producto> getGondola() {
		return gondola;
	}

	@Override
	public String toString() {
		return "Supermercado [gondola=" + gondola + "]";
	}

}
