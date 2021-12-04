/**
 * paquete modelo
 */
package co.edu.unbosque.model;

/**
 * 
 * @author Santiado Acevedo Rodriguez, Jhoan Ricardo Cuevas Patiño, Robinson
 *         José Gutierrez Solano.
 */
public class Casilla {

	private int posX;
	private int posY;
	private boolean visitado;
	private boolean fin;

	/**
	 * Metodo contructor con las instancias de la clase
	 * 
	 * @param posX posicion en x
	 * @param posY posicion en y
	 */
	public Casilla(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.visitado = false;
		this.fin = false;
	}

	/*
	 * El metodo retorna si el camino es el fin
	 */
	public boolean isFin() {
		return fin;
	}

	/**
	 * Verifica si el camino fue recorrido
	 * 
	 * @return si el camino ya se visito
	 */

	public boolean isVisitado() {
		return visitado;
	}

	/**
	 * Metodo de string de la clase
	 */

	@Override
	public String toString() {
		return "X=" + posX + ", Y=" + posY;
	}

	/**
	 * Metodo que verifica posiciones
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Casilla other = (Casilla) obj;
		if (this.posX != other.posX) {
			return false;
		}
		if (this.posY != other.posY) {
			return false;
		}
		return true;
	}

	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * @param visitado the visitado to set
	 */
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	/**
	 * @param fin the fin to set
	 */
	public void setFin(boolean fin) {
		this.fin = fin;
	}
	
	

}
