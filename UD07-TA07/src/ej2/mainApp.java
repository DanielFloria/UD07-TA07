package ej2;

import java.util.Iterator;
import java.util.Scanner;

public class mainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion = 1;
		Carrito carrito = new Carrito();
		double precio_total_sin_iva = 0;
		double precio_total_con_iva = 0;
		double iva = 0;
		double cantidad_pagada;
		
		System.out.println("Empieza a pasar artículos por la caja.");
		while(opcion != 2) {
			System.out.println("Nombre del artículo:");
			String nombre_articulo = sc.nextLine();
			System.out.println("Precio del artículo:");
			double precio_articulo = sc.nextDouble();
			sc.nextLine();
			
			Articulo articulo = new Articulo(nombre_articulo, precio_articulo);
			carrito.getCarrito().add(articulo);
			
			System.out.println("Elegir opción:\n1)Seguir comprando  2)Pagar");
			opcion = sc.nextInt();
			sc.nextLine();
			if(opcion == 2) {
				break;
			}
		}
		
		Iterator<Articulo> it = carrito.getCarrito().iterator();
		
		while(it.hasNext()) {
			precio_total_sin_iva += it.next().getPrecio();
		}
		
		System.out.println("Elegir IVA:\n1)4% 2)21%");
		int tipo_de_iva = sc.nextInt();
		
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

		precio_total_con_iva = (precio_total_sin_iva * iva);
		
		System.out.println("La cantidad total a pagar es " +  String.format("%.02f", precio_total_con_iva) + "€. Introducir cantidad de la que se dispone:");
		cantidad_pagada = sc.nextDouble();
		
		System.out.println("IVA: " + ((iva * 100) % 100) + "%");
		System.out.println("Precio total sin IVA: " + String.format("%.02f", precio_total_sin_iva) + "€");
		System.out.println("Precio total con IVA: " + String.format("%.02f", precio_total_con_iva) + "€");
		System.out.println("Número de artículos comprados: " + carrito.getCarrito().size());
		System.out.println("Cantidad pagada: " + String.format("%.02f", cantidad_pagada) + "€");
		
		if(cantidad_pagada > precio_total_con_iva) {
			System.out.println("Se devolverán " + String.format("%.02f", (cantidad_pagada - precio_total_con_iva)) + "€");
		}
		
		sc.close();
	}
}