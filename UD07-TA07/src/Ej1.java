import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ej1 {

	public static void main(String[] args) {
		Hashtable<String, String> notas_alumnos = new Hashtable<String, String>();
		int cantidad_alumnos = Integer.parseInt(JOptionPane.showInputDialog("Escribir la cantidad de alumnos:"));
		
		while(cantidad_alumnos > 0) {
			guardar_alumno(notas_alumnos);
			cantidad_alumnos--;
		}
		
		System.out.println("El Hashtable resultante es el siguiente:\n" + notas_alumnos.toString());
	}

	public static String calcular_nota_media() {
		ArrayList<Double> notas = new ArrayList<Double>();
		int cantidad_notas = Integer.parseInt(JOptionPane.showInputDialog("Escribir la cantidad de notas del alumno:"));
		double suma_notas = 0;
		String nota_media;
		
		for(int i = 0; i < cantidad_notas; i++) {
			double nota = Double.parseDouble(JOptionPane.showInputDialog("Escribir nota:"));
			notas.add(nota);
			suma_notas += nota;
		}
		nota_media = "" + (suma_notas / cantidad_notas);
		
		return nota_media;
	}
	
	public static void guardar_alumno(Hashtable<String, String> notas_alumnos) {
		String nombre_alumno = JOptionPane.showInputDialog("Escribir el nombre y apellidos del alumno:");
		String nota_media = calcular_nota_media();
		
		notas_alumnos.put(nombre_alumno, nota_media);
	}
}
