package ej4;

import java.util.Iterator;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		menu();

	}
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		Stock stock = new Stock();
		boolean exit = false;
		boolean buying;
		ShoppingCart shopping_cart = new ShoppingCart();
		double total_without_taxes = 0;
		double total_with_taxes = 0;
		double iva = 0;
		double paid_quantity;
		int option;
		
		while(!exit) {
			System.out.println("Elegir opción:\n1)Caja de pagos 2)Control de stock 3)Salir");
			option = sc.nextInt();
			sc.nextLine();
			
			if(option == 1) {
				System.out.println("Empieza a pasar artículos por la caja.");
				buying = true;
				while(buying) {
					System.out.println("Nombre del artículo:");
					String item_name = sc.nextLine();
					System.out.println("Precio del artículo:");
					double item_price = sc.nextDouble();
					sc.nextLine();
					System.out.println("Cantidad del artículo:");
					int item_quantity = sc.nextInt();
					sc.nextLine();
					Item item = new Item(item_name, item_price, item_quantity);
					shopping_cart.getShoppingCart().add(item);

					System.out.println("Elegir opción:\n1)Seguir comprando  2)Pagar");
					int choice = sc.nextInt();
					sc.nextLine();
					if(choice == 2) {
						buying = false;
					}
				}

				Iterator<Item> it = shopping_cart.getShoppingCart().iterator();

				while(it.hasNext()) {
					total_without_taxes += it.next().getTotalWithTaxes();
				}

				System.out.println("Elegir IVA:\n1)4% 2)21%");
				int tipo_de_iva = sc.nextInt();
				sc.nextLine();

				switch(tipo_de_iva) {
				case 1:
					iva = 1.04;
					break;
				case 2:
					iva = 1.21;
					break;
				default:
					System.out.println("Esa opción no es correcta");
					break;
				}

				total_with_taxes = (total_without_taxes * iva);

				System.out.println("La cantidad total a pagar es " +  String.format("%.02f", total_with_taxes) + "€. Introducir cantidad de la que se dispone:");
				paid_quantity = sc.nextDouble();
				sc.nextLine();

				System.out.println("IVA: " + ((iva * 100) % 100) + "%");
				System.out.println("Precio total sin IVA: " + String.format("%.02f", total_without_taxes) + "€");
				System.out.println("Precio total con IVA: " + String.format("%.02f", total_with_taxes) + "€");
				System.out.println("Número de artículos comprados: " + shopping_cart.getShoppingCart().size());
				System.out.println("Cantidad pagada: " + String.format("%.02f", paid_quantity) + "€");

				if(paid_quantity > total_with_taxes) {
					System.out.println("Se devolverán " + String.format("%.02f", (paid_quantity - total_with_taxes)) + "€");
				}
				shopping_cart.getShoppingCart().clear();
				total_without_taxes = 0;
				total_with_taxes = 0;
				

			} else if(option == 2) {
				boolean exit_stock = false;
				do {
					System.out.println("1)Añadir nuevo artículo\n2)Buscar artículo\n3)Mostrar todos los artículos\n"
							+ "4)Modificar un artículo\n5)Eliminar un artículo\n6)Salir");
					option = sc.nextInt();
					sc.nextLine();
					switch(option) {
					case 1:
						stock.create(sc);
						break;
					case 2:
						stock.read(sc);
						break;
					case 3:
						stock.readAll();
						break;
					case 4:
						stock.update(sc);
						break;
					case 5:
						stock.delete(sc);
						break;
					case 6:
						exit_stock = true;
						break;
					default:
						System.out.println("Esa opción no es válida.");
						break;
					}
				} while (exit_stock != true);
			} else if(option == 3) {
				exit = true;
			} else {
				System.out.println("Esa opción no es válida");
			}
		}

		sc.close();
	}

}
