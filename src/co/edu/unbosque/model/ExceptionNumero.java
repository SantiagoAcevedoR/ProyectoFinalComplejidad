/**
 * Paquete model
 */
package co.edu.unbosque.model;
/**
 * 
 * @author Santiado Acevedo Rodriguez, Jhoan Ricardo Cuevas Patiño, Robinson
 *         José Gutierrez Solano.
 */
public class ExceptionNumero extends Exception{
	/**
	 * Constructor de la exepcion
	 */
	public ExceptionNumero() {

	}
	/**
	 * Metodo que contempla la exepcion
	 * @param mensaje mensaje que saldra en la exepcion
	 */
	public ExceptionNumero(String mensaje) {
		super(mensaje);
	}
}
