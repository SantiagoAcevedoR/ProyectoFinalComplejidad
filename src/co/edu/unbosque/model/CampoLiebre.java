/**
 * Paquete model
 */
package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * 
 * @author Santiado Acevedo Rodriguez, Jhoan Ricardo Cuevas Patiño, Robinson
 *         José Gutierrez Solano.
 */
public class CampoLiebre {

	/**
	 * Constructor vacio
	 */
	public CampoLiebre() {

	}

	/**
	 * Este metodo se encarga de encontrar el minimo de saltos posibles para llegar
	 * de un punto (x,y) a otro punto (u,v)
	 * 
	 * @param numeroFilas,    numero de filas del campo o matriz
	 * @param numeroColumnas, numero de columnas del campo o matriz
	 * @param incioX,         coordenada x del punto de partida
	 * @param inicioY,        coordenada y del punto de partida
	 * @param finX,           coordenada x del punto de llegada
	 * @param finY,           coordenada y del punto de llegada
	 * @param pCamino,        p camino posibles
	 * @param qCaminos,       q caminos posibles @return, retorna el numero de
	 *                        saltos minimos, y la ruta por cual la libre hizo el
	 *                        recorrido
	 */

	public String buscarSaltosLiebre(int numeroFilas, int numeroColumnas, int incioX, int inicioY, int finX, int finY,
			int pCamino, int qCaminos) {
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

		Campo laberinto = new Campo(tablero);
		camino.add(tablero[incioX][inicioY]);

		rellenarCaminosV2(laberinto, tablero[incioX][inicioY], camino, p, q, anterior, "q");

		return laberinto.mostrarCaminos();
	}

	/**
	 * Este metodo se encarga de rellenar los caminos posibles por donde pasará la
	 * liebre.
	 * 
	 * @param laberinto,     es el campo por el cual se ira buscando el camino
	 * @param casillaActual, casilla x,y en la que se encuentra la liebre
	 * @param camino,        todas las posibles rutas
	 * @param p,             numero de p movimientos disponibles
	 * @param q,             numero de q movimiento disponibles
	 * @param anterior,      movimiento anterior
	 * @param saber,         ultimo movimiento realizdo, ya sea arriba, abajo,
	 *                       izquieda o derecha
	 */
	public void rellenarCaminosV2(Campo laberinto, Casilla casillaActual, ArrayList<Casilla> camino, int p, int q,
			int anterior, String saber) {

		if (casillaActual.isFin()) {

			if (camino.size() <= laberinto.getCaminos().size() && laberinto.getCaminos().size() != 0) {
				laberinto.añadirCamino((ArrayList<Casilla>) camino.clone());
			} else {
				laberinto.añadirCamino((ArrayList<Casilla>) camino.clone());
			}

		} else {

			if (p != 0 && saber.equals("q")) {
				p--;
				int[][] movimientos = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
				caminos(laberinto, casillaActual, camino, p, q, anterior, "p", movimientos);
			}

			if (q != 0 && saber.equals("p")) {
				q--;
				if (anterior == 0 || anterior == 2) {

					int[][] movimientos = { { 0, 1 }, { 0, -1 } };
					caminos(laberinto, casillaActual, camino, p, q, anterior, "q", movimientos);
				} else {

					int[][] movimientos = { { -1, 0 }, { 1, 0 }, };

					caminos(laberinto, casillaActual, camino, p, q, anterior, "q", movimientos);
				}

			}

		}
	}

	/**
	 * Este metodo se encarga de encontrar los caminos
	 * 
	 * @param laberinto,     es el campor por el cual se buscaran los caminos
	 * @param casillaActual, casilla x,y en la que se encuentra la liebre
	 * @param camino,        todos los posibles caminos
	 * @param p,             numero de p movimineto disponibles
	 * @param q,             numero de q movimiento disponibles
	 * @param anterior,      movimiento anterior
	 * @param saber,         ultimo movimiento realizdo, ya sea arriba, abajo,
	 *                       izquieda o derecha
	 * @param movimientos,   se encarga de determinar el siguiente movimiento de la
	 *                       liebre
	 */
	public void caminos(Campo laberinto, Casilla casillaActual, ArrayList<Casilla> camino, int p, int q,
			int anterior, String saber, int[][] movimientos) {

		int posXnueva, posYnueva;
		Casilla aux;
		boolean accesible = false;

		for (int i = 0; i < movimientos.length; i++) {

			posXnueva = casillaActual.getPosX() + movimientos[i][0];
			posYnueva = casillaActual.getPosY() + movimientos[i][1];
			aux = laberinto.getCasillaAt(posXnueva, posYnueva);

			switch (i) {
			case 0:
				accesible = laberinto.arribaDisponible(casillaActual, aux);
				break;
			case 1:
				accesible = laberinto.derechaDisponible(casillaActual, aux);
				break;
			case 2:
				accesible = laberinto.abajoDisponible(casillaActual, aux);
				break;
			case 3:
				accesible = laberinto.izquierdaDisponible(casillaActual, aux);
				break;
			}

			if (accesible) {

				camino.add(aux);
				casillaActual.setVisitado(true);
				rellenarCaminosV2(laberinto, aux, camino, p, q, i, saber);
				casillaActual.setVisitado(false);
				camino.remove(aux);
			}

		}

	}

}
