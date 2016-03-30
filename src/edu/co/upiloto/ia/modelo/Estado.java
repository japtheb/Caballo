package edu.co.upiloto.ia.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Estado {
    final int[][] tablero;
    final Punto actual;
    final int numHijos;

    public Estado(int[][] tablero, Punto actual) {
        super();
        this.tablero = tablero;
        this.actual = actual;
        this.numHijos = numHijos();
    }

    public int numHijos() {
        int hijos = 0;
        Punto punto = new Punto(this.actual.i + 2, this.actual.j + 1);
        if (esAlcanzable(punto)) {
            hijos++;
        }

        punto = new Punto(this.actual.i + 2, this.actual.j - 1);
        if (esAlcanzable(punto)) {
            hijos++;
        }

        punto = new Punto(this.actual.i + 1, this.actual.j + 2);
        if (esAlcanzable(punto)) {
            hijos++;
        }

        punto = new Punto(this.actual.i + 1, this.actual.j - 2);
        if (esAlcanzable(punto)) {
            hijos++;
        }

        punto = new Punto(this.actual.i - 2, this.actual.j + 1);
        if (esAlcanzable(punto)) {
            hijos++;
        }

        punto = new Punto(this.actual.i - 2, this.actual.j - 1);
        if (esAlcanzable(punto)) {
            hijos++;
        }

        punto = new Punto(this.actual.i - 1, this.actual.j + 2);
        if (esAlcanzable(punto)) {
            hijos++;
        }

        punto = new Punto(this.actual.i - 1, this.actual.j - 2);
        if (esAlcanzable(punto)) {
            hijos++;
        }

        return hijos;
    }

    public List<Estado> obtenerHijos() {
        List<Estado> result = new ArrayList<Estado>();
        Punto punto = new Punto(this.actual.i + 2, this.actual.j + 1);
        if (esAlcanzable(punto)) {
            result.add(mover(this, punto));
        }

        punto = new Punto(this.actual.i + 2, this.actual.j - 1);
        if (esAlcanzable(punto)) {
            result.add(mover(this, punto));
        }

        punto = new Punto(this.actual.i + 1, this.actual.j + 2);
        if (esAlcanzable(punto)) {
            result.add(mover(this, punto));
        }

        punto = new Punto(this.actual.i + 1, this.actual.j - 2);
        if (esAlcanzable(punto)) {
            result.add(mover(this, punto));
        }

        punto = new Punto(this.actual.i - 2, this.actual.j + 1);
        if (esAlcanzable(punto)) {
            result.add(mover(this, punto));
        }

        punto = new Punto(this.actual.i - 2, this.actual.j - 1);
        if (esAlcanzable(punto)) {
            result.add(mover(this, punto));
        }

        punto = new Punto(this.actual.i - 1, this.actual.j + 2);
        if (esAlcanzable(punto)) {
            result.add(mover(this, punto));
        }

        punto = new Punto(this.actual.i - 1, this.actual.j - 2);
        if (esAlcanzable(punto)) {
            result.add(mover(this, punto));
        }

        Collections.sort(result, new Comparator<Estado>() {
            @Override
            public int compare(Estado o1, Estado o2) {
                if (o1.numHijos > o2.numHijos) return -1;
                return 1;
            }
        });
        return result;
    }

    private Estado mover(Estado estado, Punto punto) {
        int[][] tableroModificado = new int[estado.tablero.length][estado.tablero.length];
        for (int i = 0; i < tableroModificado.length; i++) {
            for (int j = 0; j < tableroModificado.length; j++) {
                tableroModificado[i][j] = estado.tablero[i][j];
            }
        }
        tableroModificado[punto.i][punto.j] = estado.tablero[estado.actual.i][estado.actual.j] + 1;

        return new Estado(tableroModificado, punto);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == -1)
                    result += "-\t";
                else
                    result += tablero[i][j] + "\t";
            }
            result += "\n";
        }
        return result;
    }

    private boolean esAlcanzable(Punto punto) {
        return punto.i >= 0 && punto.i < tablero.length && punto.j >= 0
                && punto.j < tablero[0].length
                && tablero[punto.i][punto.j] == -1;
    }

}
