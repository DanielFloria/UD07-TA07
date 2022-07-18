package ej4;

import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<Item> shopping_cart;
	
	public ShoppingCart() {
		shopping_cart = new ArrayList<Item>();
	}
	
	public ArrayList<Item> getShoppingCart() {
		return shopping_cart;
	}
}
