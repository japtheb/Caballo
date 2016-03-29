package edu.co.upiloto.ia.modelo;

import java.util.Scanner;

public class UsaCaballo

{ // Abre UsaCaballo

	public static void main(String args[]) { // Abre main
		Caballo miObjeto = new Caballo();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese el i para el punto inicial");
		int x = scanner.nextInt();
		System.out.println("Ingrese el j para el punto inicial");
		int y = scanner.nextInt();
		miObjeto.Recibe(x, y);

	} // Cierra main

} // Cierra UsaCaballo