package edu.co.upiloto.ia.modelo;

import java.util.Random;
import java.util.Scanner;

public class Caballo { // Abre clase Caballo
	private int x ; // El caballo inicia en la casilla superior izquierda
	private int y ;
	private int tamano = 8; // El arreglo es de ocho x ocho
	private int contador = 1; // Esta variable lleva la cuenta de las casillas
								// recorridas
	int ciclos = 0; // Esta variable cuenta los ciclos que se inten
					// tan antes de determinar que ya no hay lugares
					// a los cuales ir
	int intentos_fallidos = 0; // Esta variable cuenta cuantos ciclos se inte
	// tan antes de obtener el que pidio el usuario para 64 pueden ser varios
	// millones

	Scanner entrada = new Scanner(System.in);

	public void Recibe(int x, int y) { // Abre Recibe
		this.x=x;
		this.y=y;
		Random aleatorio = new Random();

		int Arreglo[][] = new int[tamano + 1][tamano + 1];
		// Se define el arreglo de 9*9 para evitar el 0
		Arreglo[1][1] = 1;
		int dado1;
		int dado2;
		int casillas_requeridas = 0;

		System.out
				.println("\nCuantas casillas quiere que recorra por lo menos?");
		System.out
				.printf("\nAdvertencia: Si pide mas de %d el programa no terminara nunca:\n",
						tamano * tamano);
		casillas_requeridas = entrada.nextInt();

		// Debido a que se usara la fuerza bruta de la computacion para
		// encontrar un
		// recorrido completo se anade este while

		while (contador < casillas_requeridas) {
			intentos_fallidos++; // Se incrementa cada que inicia un intento
			contador = 1; // Dado que ya se ha colocado al caballo en (1,1), se
							// inicia el contador en 1
			int ciclos = 0; // Se inicia con 0 ciclos o lanzamientos de dados
							// infructuosos
			// Cada vez que se aborta un intento han de limipiarse las casillas,
			// con el siguiente
			// par de ciclos se establecen a 0 nuevamente.

			for (int s = 0; s <= tamano; s++) { // Abre for
				for (int t = 0; t <= tamano; t++)
					Arreglo[s][t] = 0;
			} // cierra for

			// Se ha de colocar el caballo en la esquina superior izquierda cada
			// vez
			// desde luego se puede poner en cualquier parte
			Arreglo[1][1] = 1;
			// Mientras no se encuentre un lugar para poner al caballo

			while (1000 != ciclos)
			// Este ciclo while basicamente hace el PASO 3 del algoritmo
			{ // Abre while
				ciclos++;
				dado1 = 1 + aleatorio.nextInt(8);
				dado2 = 1 + aleatorio.nextInt(8);

				if (Math.abs(Math.abs(x) - Math.abs(dado1)) == 2) { // Abre if
					if (Math.abs(Math.abs(y) - Math.abs(dado2)) == 1)

						if (0 == Arreglo[dado1][dado2]) { // Abre if
							Arreglo[dado1][dado2] = ++contador;
							x = dado1;
							y = dado2;
							ciclos = 0;
						} // Cierra if
				} // Cierra if

				if (Math.abs(Math.abs(x) - Math.abs(dado1)) == 1) { // abre if
					if (Math.abs(Math.abs(y) - Math.abs(dado2)) == 2)
						if (0 == Arreglo[dado1][dado2]) { // Abre if
							Arreglo[dado1][dado2] = ++contador;
							x = dado1;
							y = dado2;
							ciclos = 0;
						} // Cierra if
				} // Cierra if

			} // Cierra while anidado
		} // Cierra while

		System.out.println("\nLISTO!");
		System.out.printf("\nSe recorrieron %d casillas.\n", contador);
		System.out
				.printf("\nSe intentaron %d circuitos antes de obtener el requerido.\n",
						intentos_fallidos);
		Imprime(Arreglo);

	} // Cierra Recibe

	/* El metodo siguiente despliega el tablero de ajedrez */

	// ////////////////////////////////////////
	// Imprime
	// /////////////////////////////////////////

	public void Imprime(int B[][]) { // Abre imprime
		for (int k = 1; k <= 8; k++) {
			for (int j = 1; j <= 8; j++) {
				System.out.printf("%5d", B[k][j]);

			}
			System.out.println("\n");
		}
	} // Cierra imprime
} // Cierra clase Caballo
