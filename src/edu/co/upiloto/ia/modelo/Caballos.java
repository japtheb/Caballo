package edu.co.upiloto.ia.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Caballos {

    private static boolean isSolution(Estado estado) {
        for (int i = 0; i < estado.tablero.length; i++) {
            for (int j = 0; j < estado.tablero.length; j++) {
                if (estado.tablero[i][j] == -1) {
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

        int[][] tableroInicial = new int[8][8];
        for (int i = 0; i < tableroInicial.length; i++) {
            for (int j = 0; j < tableroInicial.length; j++) {
                tableroInicial[i][j] = -1;
            }
        }
        Punto puntoInicial = new Punto(initI, initJ);
        tableroInicial[initI][initJ] = 0;
        Estado initState = new Estado(tableroInicial, puntoInicial);

        List<Estado> activeStates = new LinkedList<Estado>();
        // se a�ade el estado inicial a la lista de estados activos
        activeStates.add(initState);
        Estado actualState = initState;

        while (!isSolution(actualState)) {
            activeStates.remove(0);
            List<Estado> childStates = actualState.obtenerHijos();
            for (Estado child : childStates) {
                activeStates.add(0, child);
            }
            // si no hay estados viables no hay solucion
            if (activeStates.size() > 0) {
                actualState = activeStates.get(0);
            } else {
                System.out.println("No hay Solucion viable");
                System.exit(0);
            }
            // System.out.println(actualState);
        }

        System.out.println("Solucion encontrada");
        System.out.println(actualState);
    }
}
