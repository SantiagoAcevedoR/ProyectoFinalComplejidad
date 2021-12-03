package co.edu.unbosque.model;

import java.util.ArrayList;

public class Laberinto {

	private Casilla[][] tablero;

	private ArrayList<Casilla> caminos;

	public Laberinto(Casilla[][] tablero) {
		this.tablero = tablero;
		caminos = new ArrayList<>();
	}

	public boolean arribaDisponible(Casilla casillaActual, Casilla casillaDestino) {

		if (casillaDestino != null && !casillaDestino.isVisitado()) {
			return true;
		}

		return false;
	}

	/**
	 * @return the tablero
	 */
	public Casilla[][] getTablero() {
		return tablero;
	}

	/**
	 * @param tablero the tablero to set
	 */
	public void setTablero(Casilla[][] tablero) {
		this.tablero = tablero;
	}

	/**
	 * @return the caminos
	 */
	public ArrayList<Casilla> getCaminos() {
		return caminos;
	}

	/**
	 * @param caminos the caminos to set
	 */
	public void setCaminos(ArrayList<Casilla> caminos) {
		this.caminos = caminos;
	}

	public boolean derechaDisponible(Casilla casillaActual, Casilla casillaDestino) {

		if (casillaDestino != null && !casillaDestino.isVisitado()) {
			return true;
		}

		return false;
	}

	public boolean abajoDisponible(Casilla casillaActual, Casilla casillaDestino) {

		if (casillaDestino != null && !casillaDestino.isVisitado()) {
			return true;
		}

		return false;
	}

	public boolean izquierdaDisponible(Casilla casillaActual, Casilla casillaDestino) {

		if (casillaDestino != null && !casillaDestino.isVisitado()) {
			return true;
		}

		return false;
	}

	public Casilla getCasillaAt(int x, int y) {
		if (dentroDelLimite(x, y)) {
			return tablero[x][y];
		}
		return null;
	}

	public boolean dentroDelLimite(int x, int y) {

		return (x > 0 && x < (tablero.length - 1)) && (y > 0 && y < (tablero[0].length - 1));

	}

	public void añadirCamino(ArrayList<Casilla> camino) {
		if (camino != null && !camino.isEmpty()) {
			caminos = camino;
		}
	}

	public void mostrarCaminos() {

		System.out.println("Camino: " + (caminos.size()-1));
		for (Casilla c : caminos) {
			System.out.println(c);
		}

	}

}
