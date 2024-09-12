package test;

import modelo.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class TestSupermercado {

	public static void main(String[] args) {
		Supermercado supermercado = new Supermercado();
		
		supermercado.agregarProducto("Fideos secos 500g", 980.5f);
		supermercado.agregarProducto("Shampoo 500ml", 2220.45f);
		
		System.out.println(supermercado);
		System.out.println(supermercado.traerProducto(1));
		System.out.println("8 fue modificado (no existe): " + supermercado.modificarProducto(8, "vacio", 222.2f));
		System.out.println("2 fue modificado: " + supermercado.modificarProducto(2, "Acondicionador 500ml", 2542.20f));
		System.out.println(supermercado);
		System.out.println("10 fue eliminado: " + supermercado.eliminarProducto(10));
		//System.out.println("1 fue eliminado: " + supermercado.eliminarProducto(1));
		System.out.println(supermercado);
		System.out.println("");
		/*
		Carrito carrito = new Carrito(1, LocalDate.now(), LocalTime.now());
		carrito.agregarItem(supermercado.traerProducto(2), 3);
		carrito.agregarItem(supermercado.traerProducto(2), 3);
		carrito.agregarItem(supermercado.traerProducto(1), 5);
		
		
		System.out.println(carrito);

		System.out.println("Subtotal: " + carrito.calcularSubTotal());
		*/
	}

}
