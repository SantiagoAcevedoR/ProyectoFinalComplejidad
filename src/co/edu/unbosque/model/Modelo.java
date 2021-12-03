/**
 * Paquete model
 */
package co.edu.unbosque.model;

import java.util.ArrayList;

public class Modelo {

	private LaberintoLiebre laberintoLiebre;

	public Modelo() {
		laberintoLiebre = new LaberintoLiebre();
	}

	public void buscarSaltosLiebre(int numeroFilas, int numeroColumnas, int incioX, int inicioY, int finX, int finY, int pCamino, int qCaminos) {
		Casilla[][] tablero = new Casilla[numeroFilas + 2][numeroColumnas + 2];

		for (int i = 1; i < (tablero.length - 1); i++) {
			for (int j = 1; j < (tablero.length - 1); j++) {
				tablero[i][j] = new Casilla(i, j);
			}
		}
		tablero[finX][finY].setFin(true);

		ArrayList<Casilla> camino = new ArrayList<>();
		int p = pCamino;
		int q = qCaminos;
		int anterior = 0;

		Laberinto laberinto = new Laberinto(tablero);
		camino.add(tablero[incioX][inicioY]);
		
		laberintoLiebre.rellenarCaminosV2(laberinto, tablero[incioX][inicioY], camino, p, q, anterior, "q");

		laberinto.mostrarCaminos();
	}
	
	public boolean soloNumeros(String numero) {
		for (int i = 0; i < numero.length(); i++) {
			char aux = numero.charAt(i);
			int digito = aux - '0';
			if (digito > 9 || digito < 0) {
				return false;
			}
		}
		return true;
	}
	
	public void verificarNumero(String numero) throws ExceptionNumero {
		if (!soloNumeros(numero)) {
			throw new ExceptionNumero("Caracter no permitido en campo numérico");
		} else {
			if (Integer.parseInt(numero) <= 0) {
				throw new ExceptionNumero("Ingrese una cantidad minimo de uno");
			}
		}
	}
}
