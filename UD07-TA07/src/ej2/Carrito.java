package ej2;

import java.util.ArrayList;

public class Carrito {
	private ArrayList<Articulo> carrito;
	
	public Carrito() {
		carrito = new ArrayList<Articulo>();
	}
	
	public ArrayList<Articulo> getCarrito() {
		return carrito;
	}
}
