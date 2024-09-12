package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;

public class Carrito {
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> lstItem;
	private Cliente cliente;
	
	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora, Cliente cliente) {
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.hora = hora;
		this.lstItem = new ArrayList<>();
		this.cliente = cliente;
	}
	
	public boolean agregarItem(Producto producto, int cantidad) {
		int tamLista = lstItem.size();
		boolean productoExiste = false;
		boolean itemFueAgregado = false;
		int id = 1;
		
		if(tamLista > 0) {
			int i = 0;
			
			while(i < tamLista && !productoExiste) {
				if(lstItem.get(i).getProducto().getProducto().equals(producto.getProducto())) {
					productoExiste = true;
				}
				
				i++;
			}
			
			if(productoExiste) {
				lstItem.get(i - 1).setCantidad(lstItem.get(i - 1).getCantidad() + cantidad);
				itemFueAgregado = true;
			} else {
				id = lstItem.get(tamLista - 1).getIdItem() + 1;
			}
		
		}
		
		if(!itemFueAgregado) {
			itemFueAgregado = lstItem.add(new ItemCarrito(id, producto, cantidad));
		}
		
		return itemFueAgregado;
	}
	
	public boolean eliminarItem(Producto producto, int cantidad) {
		int tamLista = lstItem.size();
		boolean productoExiste = false;
		boolean itemFueEliminado = false;
		
		if(tamLista > 0) {
			int i = 0;
			
			while(i < tamLista && !productoExiste) {
				if(lstItem.get(i).getProducto().getProducto().equals(producto.getProducto())) {
					productoExiste = true;
				}
				
				i++;
			}
			
			if(productoExiste) {
				if(lstItem.get(i - 1).getCantidad() <= cantidad) {
					lstItem.remove(i - 1);
				} else {
					lstItem.get(i - 1).setCantidad(lstItem.get(i - 1).getCantidad() - cantidad);
				}
				itemFueEliminado = true;
			} else {
				// EXCEPCION
			}
			
		}
		
		return itemFueEliminado;
	}
	
	public float calcularSubTotal() {
		float subTotal = 0;
		
		for(ItemCarrito item : lstItem) {
			subTotal += item.getProducto().getPrecio() * item.getCantidad();
		}
		
		return subTotal;
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	public List<ItemCarrito> getLstItem() {
		return lstItem;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", fecha=" + fecha + ", hora=" + hora.truncatedTo(ChronoUnit.SECONDS)+ ", lstItem=" + lstItem + "]";
	}
	
}
