/**
 * Paquete model
 */
package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * 
 * @author Santiado Acevedo Rodriguez, Jhoan Ricardo Cuevas Patiño, Robinson
 *         José Gutierrez Solano.
 *
 */

public class Campo {

	private Casilla[][] tablero;

	private ArrayList<Casilla> caminos;

	/**
	 * Contructor de clase con instancias de clase
	 * 
	 * @param tablero arreglo del campo
	 */

	public Campo(Casilla[][] tablero) {
		this.tablero = tablero;
		caminos = new ArrayList<>();
	}

	/**
	 * El metodo verifica si en la casilla de arriba es posible hacer un movimiento
	 * 
	 * @param casillaActual  la posicion en la que se encuentra
	 * @param casillaDestino posicion a la que quiere llegar
	 * @return si es posible o no moverse
	 */
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

	/**
	 * El metodo verifica si en la casilla de la derecha es posible hacer un
	 * movimiento
	 * 
	 * @param casillaActual  la posicion en la que se encuentra
	 * @param casillaDestino posicion a la que quiere llegar
	 * @return si es posible o no moverse
	 */
	public boolean derechaDisponible(Casilla casillaActual, Casilla casillaDestino) {

		if (casillaDestino != null && !casillaDestino.isVisitado()) {
			return true;
		}

		return false;
	}

	/**
	 * El metodo verifica si en la casilla de abajo es posible hacer un movimiento
	 * 
	 * @param casillaActual  la posicion en la que se encuentra
	 * @param casillaDestino posicion a la que quiere llegar
	 * @return si es posible o no moverse
	 */
	public boolean abajoDisponible(Casilla casillaActual, Casilla casillaDestino) {

		if (casillaDestino != null && !casillaDestino.isVisitado()) {
			return true;
		}

		return false;
	}

	/**
	 * El metodo verifica si en la casilla de la ixquierda es posible hacer un
	 * movimiento
	 * 
	 * @param casillaActual  la posicion en la que se encuentra
	 * @param casillaDestino posicion a la que quiere llegar
	 * @return si es posible o no moverse
	 */
	public boolean izquierdaDisponible(Casilla casillaActual, Casilla casillaDestino) {

		if (casillaDestino != null && !casillaDestino.isVisitado()) {
			return true;
		}

		return false;
	}

	/**
	 * Llama al metodo dentroDelLimite para saber el limite
	 * 
	 * @param x posicion en el eje x
	 * @param y posicion en el eje y
	 * @return null o la casilla en el limite
	 */

	public Casilla getCasillaAt(int x, int y) {
		if (dentroDelLimite(x, y)) {
			return tablero[x][y];
		}
		return null;
	}

	/**
	 * EL metodo verifica que este dentro del limite
	 * 
	 * @param x es la posicion en el eje x
	 * @param y es la posicion en el eje y
	 * @return verdadero falso si esta en el limite
	 */

	public boolean dentroDelLimite(int x, int y) {

		return (x > 0 && x < (tablero.length - 1)) && (y > 0 && y < (tablero[0].length - 1));

	}

	/**
	 * El emtodo añade un nuevo camino optimo
	 * @param camino las casillas del camino optimo
	 */
	public void añadirCamino(ArrayList<Casilla> camino) {
		if (camino != null && !camino.isEmpty()) {
			caminos = camino;
		}
	}

	/**
	 * Muestra el camino optimo
	 * @return el camino valido con los saltos
	 */
	public String mostrarCaminos() {
		String camino = "";
		camino += "Minimo de saltos: " + (caminos.size() - 1);
		for (Casilla c : caminos) {
			camino += "\n" + c;
		}
		return camino;

	}

}
