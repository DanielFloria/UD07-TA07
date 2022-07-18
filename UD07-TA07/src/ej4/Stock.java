package ej4;

import java.util.ArrayList;
import java.util.Scanner;

public class Stock {
	private ArrayList<Item> stock;
	
	public Stock() {
		stock = new ArrayList<Item>();
	}
	
	public ArrayList<Item> getStock() {
		return stock;
	}
	
	// Pide valores para instanciar un objeto de la clase Item y a�ade este objeto a la arraylist
	public void create(Scanner sc) {
		System.out.println("Escribe el nombre del art�culo:");
		String name = sc.nextLine();
		System.out.println("Escribe el precio del art�culo:");
		double price = sc.nextDouble();
		sc.nextLine();
		System.out.println("Escribe la cantidad:");
		int quantity = sc.nextInt();
		sc.nextLine();
		
		Item item = new Item(name, price, quantity);
		this.getStock().add(item);
	}
	
	// Pasa por todos los elementos de la arraylist e imprime los valores de sus atributos
	public void readAll() {
		System.out.println("Listado de art�culos en stock:");
		for(Item item : this.getStock()) {
			System.out.println("Nombre: " + item.getName()
					// Se formata el String para que el valor solamente tenga dos decimales
					+ ", precio: " + String.format("%.02f", item.getPrice()) + "�" 
					+ ", cantidad: " + item.getQuantity());
		}
	}
	
	// Busca por nombre un art�culo en la arraylist e imprime los valores de sus atributos
	public void read(Scanner sc) {
		System.out.println("Escribe el nombre del art�culo:");
		String item_name = sc.nextLine();
		for(Item item : this.getStock()) {
			if(item.getName().equals(item_name)) {
				System.out.println("Nombre: " + item.getName() 
						+ ", precio: " + String.format("%.02f", item.getPrice()) + "�" 
						+ ", cantidad: " + item.getQuantity());
			}
		}
		//Si no se encuentra el nombre del art�culo en el stream de objetos Item devuelve false
		boolean is_in_arraylist = this.getStock().stream().anyMatch(o -> o.getName().equals(item_name));
		if(!is_in_arraylist) System.out.println("El art�culo no se encuentra en stock.");
	}
	/* Pide el valor del nombre de un objeto Item y atributo que se quiere modificar, 
	se busca el objeto por nombre en la arraylist y se modifica el atributo deseado */
	public void update(Scanner sc) {
		System.out.println("Escribe el nombre del art�culo:");
		String item_name = sc.nextLine();
		System.out.println("Elige el n�mero de opci�n a modificar:\n1)Nombre 2)Precio 3)Cantidad");
		int attribute = sc.nextInt();
		sc.nextLine();
		switch(attribute) {
		case 1:
			for(Item item : this.getStock()) {
				if(item.getName().equals(item_name)) {
					System.out.println("Escribe el nuevo nombre del art�culo:");
					String new_name = sc.nextLine();
					item.setName(new_name);
					
					System.out.println("Nombre modificado.");
					System.out.println("Nombre: " + item.getName() 
					+ ", precio: " + String.format("%.02f", item.getPrice()) + "�" 
					+ ", cantidad: " + item.getQuantity());
					break;
				}
			}
			break;
		case 2:
			for(Item item : this.getStock()) {
				if(item.getName().equals(item_name)) {
					System.out.println("Escribe el nuevo precio del art�culo:");
					double new_price = sc.nextDouble();
					item.setPrice(new_price);
					
					System.out.println("Precio modificado.");
					System.out.println("Nombre: " + item.getName() 
					+ ", precio: " + String.format("%.02f", item.getPrice()) + "�" 
					+ ", cantidad: " + item.getQuantity());
					break;
				}
			}
			break;
		case 3:
			for(Item item : this.getStock()) {
				if(item.getName().equals(item_name)) {
					System.out.println("Escribe la nueva cantidad del art�culo:");
					int new_quantity = sc.nextInt();
					item.setPrice(new_quantity);
					
					System.out.println("Cantidad modificada.");
					System.out.println("Nombre: " + item.getName() 
					+ ", precio: " + String.format("%.02f", item.getPrice()) + "�" 
					+ ", cantidad: " + item.getQuantity());
					break;
				}
			}
			break;
		default:
			System.out.println("La opci�n elegida no es v�lida.");
			break;
		}
	}

	/* Busca por nombre en la arraylist por nombre el objecto Item y si lo encuentra lo quita de la arraylist */
	public void delete(Scanner sc) {
		System.out.println("Escribe el nombre del art�culo:");
		String item_name = sc.nextLine();
		for(Item item : this.getStock()) {
			if(item.getName().equals(item_name)) {
				System.out.println("�Est� seguro de borrar este art�culo? s/n");
				String choice = sc.nextLine();
				sc.nextLine();
				switch(choice) {
				case "s":
					this.getStock().remove(item);
					System.out.println("Art�culo borrado.");
					break;
				case "n":
					System.out.println("No se ha borrado ning�n art�culo.");
					break;
				default:
					System.out.println("La opci�n elegida no es v�lida.");
					break;
				}
				break;
			}
		}
	}
}

