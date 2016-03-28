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
		if (this.actual.i + 2 < 8 && this.actual.j + 1 < 8) {
			result.add(mover2izquierda1abajot(this));
		}

		return result;
	}

	private Estado mover2izquierda1abajot(Estado state) {
		String[][] tableroModificado = new String[8][8];
		for (int i = 0; i < tableroModificado.length; i++) {
			for (int j = 0; j < tableroModificado.length; j++) {
				tableroModificado[i][j] = state.tablero[i][j];
			}

		}
		Punto actualModificado = new Punto(state.actual.i + 2,
				state.actual.j + 1);
		tablero[actualModificado.i][actualModificado.j] = "X";

		return new Estado(tableroModificado, actualModificado, state,
				"mover 2 izquierda 1 abajo");
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

}
