/**
 * Paquete view
 */
package co.edu.unbosque.view;

import java.util.Scanner;

/**
 * @author Santiado Acevedo Rodriguez, Jhoan Ricardo Cuevas Patiño, Robinson
 *         José Gutierrez Solano.
 *
 */
public class Vista {

	private Scanner sc;

	/**
	 * Constructor vacio
	 */
	public Vista() {
		sc = new Scanner(System.in);
	}

	/**
	 * Este metodo se encarga de leer los datos ingresados por el usuario.
	 * 
	 * @return retorna el dato ingresado por el usuario.
	 */
	public String leerDato(String mensaje) {
		System.out.println(mensaje);
		return sc.nextLine();
	}

	/**
	 * Este metodo se encarga de mostrar un mensaje en consola.
	 * 
	 * @param mensaje, mensaje a mostrar en consola.
	 */
	public void imprimirDato(String mensaje) {
		System.out.println(mensaje);
	}

	/**
	 * @return the sc
	 */
	public Scanner getSc() {
		return sc;
	}

	/**
	 * @param sc the sc to set
	 */
	public void setSc(Scanner sc) {
		this.sc = sc;
	}

}
