/**
 * Paquete controller
 */
package co.edu.unbosque.controller;

import co.edu.unbosque.model.Modelo;
import co.edu.unbosque.view.Vista;

/**
 * @author ROBINSON
 *
 */
public class Controller {

	private Vista vista;
	private Modelo modelo;

	/**
	 * Constructor vacio
	 */
	public Controller() {
		vista = new Vista();
		modelo = new Modelo();
		iniciar();
	}

	public void iniciar() {
		String opcion = "";
		String seguir = "";
		do {
			opcion = vista.leerDato(
					"Ingrese la opción que desea realizar\n1.Nutricionista\n2.Liga de fútbol\n3.Saltos de conejo");
			switch (opcion) {
			case "1":
				vista.imprimirDato("Opcion1");
				break;
			case "2":
				vista.imprimirDato("Opcion2");
				break;
			case "3":
				vista.imprimirDato("Opcion4");
				break;
			default:
				vista.imprimirDato("Default");
				break;
			}
			seguir = vista.leerDato("Desea seguir (S/N)");
			seguir.toUpperCase();
			while (!seguir.equals("N") || !seguir.equals("S")) {
				seguir = vista.leerDato("Ingrese un dato valido (S/N)");
			}

		} while (seguir.equals("S"));

	}
}
