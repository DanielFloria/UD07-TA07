package ej3;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		menu();

	}

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		int opcion;
		boolean salir = false;
		
		Stock stock = new Stock();
		
		do {
			System.out.println("1)A�adir nuevo art�culo\n2)Buscar art�culo\n3)Mostrar todos los art�culos\n"
					+ "4)Modificar un art�culo\n5)Eliminar un art�culo\n6)Salir");
			opcion = sc.nextInt();
			sc.nextLine();
			switch(opcion) {
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
				salir = true;
				break;
			default:
				System.out.println("Esa opci�n no es v�lida.");
				break;
			}
		} while (salir != true);
		
		sc.close();
	}
}
