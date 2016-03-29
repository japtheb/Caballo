package edu.co.upiloto.ia.modelo;

import java.util.ArrayList;
import java.util.List;

public class Estado {
	final String[][] tablero;
	final Punto actual;
	final Estado padre;
	final String accion;

	public Estado(String[][] tablero, Punto actual, Estado padre, String accion) {
		super();
		this.tablero = tablero;
		this.actual = actual;
		this.padre = padre;
		this.accion = accion;
	}

	public List<Estado> obtenerHijos() {
		List<Estado> result = new ArrayList<Estado>();
		if (esAlcanzable(new Punto(this.actual.i - 2, this.actual.j + 1))) {
			result.add(mover2arriba1derecha(this));
		}
		if (esAlcanzable(new Punto(this.actual.i - 1, this.actual.j + 2))) {
			result.add(mover1arriba2derecha(this));
		}
		if (esAlcanzable(new Punto(this.actual.i + 1, this.actual.j + 2))) {
			result.add(mover1abajo2derecha(this));
		}
		if (esAlcanzable(new Punto(this.actual.i + 2, this.actual.j + 1))) {
			result.add(mover2abajo1derecha(this));
		}
		if (esAlcanzable(new Punto(this.actual.i + 2, this.actual.j - 1))) {
			result.add(mover2abajo1izquierda(this));
		}
		if (esAlcanzable(new Punto(this.actual.i + 1, this.actual.j - 2))) {
			result.add(mover1abajo2izquierda(this));
		}
		if (esAlcanzable(new Punto(this.actual.i - 1, this.actual.j - 2))) {
			result.add(mover1arriba2izquierda(this));

		}
		if (esAlcanzable(new Punto(this.actual.i - 2, this.actual.j - 1))) {
			result.add(mover2arriba11zquierda(this));
		}
		return result;
	}

	private Estado mover2arriba1derecha(Estado estado) {
		String[][] tableroModificado = new String[8][8];
		for (int i = 0; i < tableroModificado.length; i++) {
			for (int j = 0; j < tableroModificado.length; j++) {
				tableroModificado[i][j] = estado.tablero[i][j];
			}
		}
		Punto actualModificado = new Punto(estado.actual.i - 2,
				estado.actual.j + 1);
		tableroModificado[actualModificado.i][actualModificado.j] = "X";

		return new Estado(tableroModificado, actualModificado, estado,
				"mover 2 arriba 1 derecha");
	}

	private Estado mover1arriba2derecha(Estado estado) {
		String[][] tableroModificado = new String[8][8];
		for (int i = 0; i < tableroModificado.length; i++) {
			for (int j = 0; j < tableroModificado.length; j++) {
				tableroModificado[i][j] = estado.tablero[i][j];
			}
		}
		Punto actualModificado = new Punto(estado.actual.i - 1,
				estado.actual.j + 2);
		tableroModificado[actualModificado.i][actualModificado.j] = "X";

		return new Estado(tableroModificado, actualModificado, estado,
				"mover 1 arriba 2 derecha");
	}

	private Estado mover1abajo2derecha(Estado estado) {
		String[][] tableroModificado = new String[8][8];
		for (int i = 0; i < tableroModificado.length; i++) {
			for (int j = 0; j < tableroModificado.length; j++) {
				tableroModificado[i][j] = estado.tablero[i][j];
			}
		}
		Punto actualModificado = new Punto(estado.actual.i + 1,
				estado.actual.j + 2);
		tableroModificado[actualModificado.i][actualModificado.j] = "X";

		return new Estado(tableroModificado, actualModificado, estado,
				"mover 1 abajo 2 derecha");
	}

	private Estado mover2abajo1derecha(Estado estado) {
		String[][] tableroModificado = new String[8][8];
		for (int i = 0; i < tableroModificado.length; i++) {
			for (int j = 0; j < tableroModificado.length; j++) {
				tableroModificado[i][j] = estado.tablero[i][j];
			}
		}
		Punto actualModificado = new Punto(estado.actual.i + 2,
				estado.actual.j + 1);
		tableroModificado[actualModificado.i][actualModificado.j] = "X";

		return new Estado(tableroModificado, actualModificado, estado,
				"mover 2 abajo 1 derecha");
	}

	private Estado mover2abajo1izquierda(Estado estado) {
		String[][] tableroModificado = new String[8][8];
		for (int i = 0; i < tableroModificado.length; i++) {
			for (int j = 0; j < tableroModificado.length; j++) {
				tableroModificado[i][j] = estado.tablero[i][j];
			}
		}
		Punto actualModificado = new Punto(estado.actual.i + 2,
				estado.actual.j - 1);
		tableroModificado[actualModificado.i][actualModificado.j] = "X";

		return new Estado(tableroModificado, actualModificado, estado,
				"mover 2 abajo 1 Izquierda");
	}

	private Estado mover1abajo2izquierda(Estado estado) {
		String[][] tableroModificado = new String[8][8];
		for (int i = 0; i < tableroModificado.length; i++) {
			for (int j = 0; j < tableroModificado.length; j++) {
				tableroModificado[i][j] = estado.tablero[i][j];
			}
		}
		Punto actualModificado = new Punto(estado.actual.i + 1,
				estado.actual.j - 2);
		tableroModificado[actualModificado.i][actualModificado.j] = "X";

		return new Estado(tableroModificado, actualModificado, estado,
				"mover 1 abajo 2 Izquierda");
	}

	private Estado mover1arriba2izquierda(Estado estado) {
		String[][] tableroModificado = new String[8][8];
		for (int i = 0; i < tableroModificado.length; i++) {
			for (int j = 0; j < tableroModificado.length; j++) {
				tableroModificado[i][j] = estado.tablero[i][j];
			}
		}
		Punto actualModificado = new Punto(estado.actual.i - 1,
				estado.actual.j - 2);
		tableroModificado[actualModificado.i][actualModificado.j] = "X";

		return new Estado(tableroModificado, actualModificado, estado,
				"mover 1 arriba 2 Izquierda");
	}

	private Estado mover2arriba11zquierda(Estado estado) {
		String[][] tableroModificado = new String[8][8];
		for (int i = 0; i < tableroModificado.length; i++) {
			for (int j = 0; j < tableroModificado.length; j++) {
				tableroModificado[i][j] = estado.tablero[i][j];
			}
		}
		Punto actualModificado = new Punto(estado.actual.i - 2,
				estado.actual.j - 1);
		tableroModificado[actualModificado.i][actualModificado.j] = "X";

		return new Estado(tableroModificado, actualModificado, estado,
				"mover 2 arriba 1 Izquierda");
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (tablero[i][j].equals(""))
					result += "-";
				else
					result += tablero[i][j];
			}
		}
		return result;
	}

	private boolean esAlcanzable(Punto punto) {
		return punto.i >= 0 && punto.i < tablero.length && punto.j >= 0
				&& punto.j < tablero[0].length
				&& tablero[punto.i][punto.j].equals("");
	}

}
