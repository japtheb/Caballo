package edu.co.upiloto.ia.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Caballos {

	private static boolean isSolution(Estado estado) {
		for (int i = 0; i < estado.tablero.length; i++) {
			for (int j = 0; j < estado.tablero.length; j++) {
				if (estado.tablero[i][j].equals("")) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese el i para el punto inicial");
		int initI = scanner.nextInt();
		System.out.println("Ingrese el j para el punto inicial");
		int initJ = scanner.nextInt();

		String[][] tableroInicial = new String[8][8];
		for (int i = 0; i < tableroInicial.length; i++) {
			for (int j = 0; j < tableroInicial.length; j++) {
				tableroInicial[i][j] = "";
			}
		}
		Punto puntoInicial = new Punto(initI, initJ);
		Estado initState = new Estado(tableroInicial, puntoInicial, null, "");

		List<Estado> activeStates = new ArrayList<Estado>();
		HashMap<String, Estado> visitedStates = new HashMap<String, Estado>();
		// se a–ade el estado inicial a la lista de estados activos
		activeStates.add(initState);
		Estado actualState = initState;
		//
		while (!isSolution(actualState)) {
			activeStates.remove(0);
			List<Estado> childStates = actualState.obtenerHijos();
			for (Estado child : childStates) {
				String childKey = child.toString();
				if (!visitedStates.containsKey(childKey)) {
					activeStates.add(0, child);
					visitedStates.put(childKey, child);
				}
			}
			// si no hay estados viables no hay solucion
			if (activeStates.size() > 0) {
				actualState = activeStates.get(0);
			} else {
				System.out.println("No hay Solucion viable");
				System.exit(0);
			}
		}

		System.out.println("Solucion encontrada");

		List<Estado> results = new ArrayList<Estado>();

		while (actualState != null) {
			results.add(actualState);
			actualState = actualState.padre;
		}

		for (int i = results.size() - 1; i >= 0; i--) {
			Estado state = results.get(i);
			System.out.println("->" + state.toString());
		}
	}
}
