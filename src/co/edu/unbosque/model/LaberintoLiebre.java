package co.edu.unbosque.model;

import java.util.ArrayList;

public class LaberintoLiebre {
	
	public void LaberintoLiebre() {
		
	}

	public void rellenarCaminosV2(Laberinto laberinto, Casilla casillaActual, ArrayList<Casilla> camino, int p,
			int q, int anterior, String saber) {

		if (casillaActual.isFin()) {

			if (camino.size() <= laberinto.getCaminos().size() && laberinto.getCaminos().size() != 0) {
				laberinto.a�adirCamino((ArrayList<Casilla>) camino.clone());
			} else {
				laberinto.a�adirCamino((ArrayList<Casilla>) camino.clone());
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

	public void caminos(Laberinto laberinto, Casilla casillaActual, ArrayList<Casilla> camino, int p, int q,
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