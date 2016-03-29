package edu.co.upiloto.ia.modelo;

import java.util.ArrayList;
import java.util.List;

public class Estado {
	final int[][] tablero;
	final Punto actual;

	public Estado(int[][] tablero, Punto actual) {
		super();
		this.tablero = tablero;
		this.actual = actual;
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
					result += "- ";
				else
					result += tablero[i][j] + " ";
			}
		}
		return result;
	}

	private boolean esAlcanzable(Punto punto) {
		return punto.i >= 0 && punto.i < tablero.length && punto.j >= 0
				&& punto.j < tablero[0].length
				&& tablero[punto.i][punto.j] == -1;
	}

}
