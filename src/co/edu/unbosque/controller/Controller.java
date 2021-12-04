/**
 * Paquete controller
 */
package co.edu.unbosque.controller;

import co.edu.unbosque.model.Modelo;
import co.edu.unbosque.model.ExceptionNumero;
import co.edu.unbosque.view.Vista;

/**
 * @author Santiado Acevedo Rodriguez, Jhoan Ricardo Cuevas Patiño, Robinson
 *         José Gutierrez Solano.
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
	/**
	 * Metodo que hace correr las instancias del programa
	 */

	public void iniciar() {
		String opcion = "";
		String seguir = "";
		do {
			try {
				opcion = vista.leerDato(
						"Ingrese la opción que desea realizar\n1.Nutricionista\n2.Liga de fútbol\n3.Saltos de conejo");
				switch (opcion) {
				case "1":
					String numeroPlatos = "";
					String nombrePlato = "";
					String numeroCalorias = "";
					String minimoCalorias = "";
					String error = "";
					int k = 0;
					do {
						numeroPlatos = vista.leerDato("Ingrese el numero de platos");
						error = modelo.verificarNumero(numeroPlatos);
						if (error.length() == 0) {
							k = 1;
						} else {
							k = 0;
							vista.imprimirDato(error);
						}
					} while (k == 0);
					error = "";
					k = 0;
					do {
						minimoCalorias = vista.leerDato("Ingrese el minimo de calorias");
						error = modelo.verificarNumero(minimoCalorias);
						if (error.length() == 0) {
							k = 1;
						} else {
							k = 0;
							vista.imprimirDato(error);
						}
					} while (k == 0);
					error = "";
					k = 0;
					String[][] platos = new String[Integer.parseInt(numeroPlatos)][2];
					for (int i = 0; i < Integer.parseInt(numeroPlatos); i++) {
						nombrePlato = vista.leerDato("Ingrese el nombre del plato numero " + (i + 1));
						do {
							numeroCalorias = vista
									.leerDato("Ingrese el numero de calorias del plato numero " + (i + 1));
							error = modelo.verificarNumero(numeroCalorias);
							if (error.length() == 0) {
								k = 1;
							} else {
								k = 0;
								vista.imprimirDato(error);
							}
						} while (k == 0);
						platos[i][0] = nombrePlato;
						platos[i][1] = numeroCalorias;
					}
					modelo.getMenuOptimo().calcularMenuOptimo(platos, Integer.parseInt(minimoCalorias));
					break;
				case "2":
					vista.imprimirDato("Opcion2");
					break;
				case "3":
					String numeroFilas = "";
					String numeroColumnas = "";
					String inicioX = "";
					String inicioY = "";
					String finX = "";
					String finY = "";
					String caminosP = "";
					String caminosQ = "";
					error = "";
					k = 0;
					do {
						numeroFilas = vista.leerDato("Ingrese el numero de filas del campo");
						error = modelo.verificarNumero(numeroFilas);
						if (error.length() == 0) {
							k = 1;
						} else {
							k = 0;
							vista.imprimirDato(error);
						}
					} while (k == 0);
					error = "";
					k = 0;
					do {
						numeroColumnas = vista.leerDato("Ingrese el número de columnas del campo");
						error = modelo.verificarNumero(numeroColumnas);
						if (error.length() == 0) {
							k = 1;
						} else {
							k = 0;
							vista.imprimirDato(error);
						}
					} while (k == 0);
					error = "";
					k = 0;
					do {
						inicioX = vista.leerDato("Ingrese la coordenada x del punto de partia de la liebre");
						error = modelo.verificarNumero(inicioX);
						if (error.length() == 0) {
							if (Integer.parseInt(inicioX) > Integer.parseInt(numeroFilas)) {
								k = 0;
								vista.imprimirDato("El numero que está indicando sobrepasa los limites del campo");
							} else {
								k = 1;
							}
						} else {
							k = 0;
							vista.imprimirDato(error);
						}
					} while (k == 0);
					error = "";
					k = 0;
					do {
						inicioY = vista.leerDato("Ingrese la coordenada y del punto de partia de la liebre");
						error = modelo.verificarNumero(inicioY);
						if (error.length() == 0) {
							if (Integer.parseInt(inicioY) > Integer.parseInt(numeroColumnas)) {
								k = 0;
								vista.imprimirDato("El numero que está indicando sobrepasa los limites del campo");
							} else {
								k = 1;
							}
						} else {
							k = 0;
							vista.imprimirDato(error);
						}
					} while (k == 0);
					error = "";
					k = 0;
					do {
						finX = vista.leerDato("Ingrese la coordenada x del punto de llegada de la liebre");
						error = modelo.verificarNumero(finX);
						if (error.length() == 0) {
							if (Integer.parseInt(finX) > Integer.parseInt(numeroFilas)) {
								k = 0;
								vista.imprimirDato("El numero que está indicando sobrepasa los limites del campo");
							} else {
								k = 1;
							}
						} else {
							k = 0;
							vista.imprimirDato(error);
						}
					} while (k == 0);
					error = "";
					k = 0;
					do {
						finY = vista.leerDato("Ingrese la coordenada y del punto de llegada de la liebre");
						error = modelo.verificarNumero(finY);
						if (error.length() == 0) {
							if (Integer.parseInt(finY) > Integer.parseInt(numeroColumnas)) {
								k = 0;
								vista.imprimirDato("El numero que está indicando sobrepasa los limites del campo");
							} else {
								k = 1;
							}
						} else {
							k = 0;
							vista.imprimirDato(error);
						}
					} while (k == 0);
					error = "";
					k = 0;
					do {
						caminosP = vista.leerDato("Ingrese el numero de caminos P");
						error = modelo.verificarNumero(caminosP);
						if (error.length() == 0) {
							k = 1;
						} else {
							k = 0;
							vista.imprimirDato(error);
						}
					} while (k == 0);
					error = "";
					k = 0;
					do {
						caminosQ = vista.leerDato("Ingrese el numero de caminos Q");
						error = modelo.verificarNumero(caminosQ);
						if (error.length() == 0) {
							k = 1;
						} else {
							k = 0;
							vista.imprimirDato(error);
						}
					} while (k == 0);
					String camino = modelo.getCampoLibre().buscarSaltosLiebre(Integer.parseInt(numeroFilas),
							Integer.parseInt(numeroColumnas), Integer.parseInt(inicioX), Integer.parseInt(inicioY),
							Integer.parseInt(finX), Integer.parseInt(finY), Integer.parseInt(caminosP),
							Integer.parseInt(caminosQ));
					if (camino.length() == 0) {
						vista.imprimirDato("No es posible calcular el camino");
					}else if(camino.equals("Minimo de saltos: -1")) {
						vista.imprimirDato("No es posible calcular el camino");
					}else {
						vista.imprimirDato(camino);
					}
					break;
				default:
					vista.imprimirDato("Opción no valida");
					break;
				}
			} catch (ExceptionNumero e) {
				vista.imprimirDato(e.getMessage());
			}
			seguir = vista.leerDato("Desea seguir (S/N)");
			seguir.toUpperCase();
			int k = 0;
			do {
				if (seguir.equals("n") || seguir.equals("s")) {
					k = 0;
				} else {
					k = 1;
					seguir = vista.leerDato("Ingrese un dato valido (S/N)");
				}
			} while (k == 1);

		} while (seguir.equals("s"));

	}
}
