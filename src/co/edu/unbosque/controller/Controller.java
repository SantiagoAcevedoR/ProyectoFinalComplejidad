/**
 * Paquete controller
 */
package co.edu.unbosque.controller;

import co.edu.unbosque.model.Modelo;
import co.edu.unbosque.model.ExceptionNumero;
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
			try {
				opcion = vista.leerDato(
						"Ingrese la opción que desea realizar\n1.Nutricionista\n2.Liga de fútbol\n3.Saltos de conejo");
				switch (opcion) {
				case "1":
					String numeroPlatos = "";
					String nombrePlato = "";
					String numeroCalorias = "";
					String minimoCalorias = "";
					numeroPlatos = vista.leerDato("Ingrese el numero de platos");
					minimoCalorias = vista.leerDato("Ingrese el minimo de calorias");
					String[][] platos = new String[Integer.parseInt(numeroPlatos)][2];
					for (int i = 0; i < Integer.parseInt(numeroPlatos); i++) {
						nombrePlato = vista.leerDato("Ingrese el nombre del plato numero " + (i + 1));
						numeroCalorias = vista.leerDato("Ingrese el numero de calorias del plato numero " + (i + 1));
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
					numeroFilas = vista.leerDato("Ingrese el número de filas del campo");
					modelo.verificarNumero(numeroFilas);
					numeroColumnas = vista.leerDato("Ingrese el número de columnas del campo");
					modelo.verificarNumero(numeroColumnas);
					inicioX = vista.leerDato("Ingrese la cordenada x del punto de partia de la liebre");
					modelo.verificarNumero(inicioX);
					inicioY = vista.leerDato("Ingrese la cordenada y del punto de partia de la liebre");
					modelo.verificarNumero(inicioY);
					finX = vista.leerDato("Ingrese la cordenada x del punto de llegada de la liebre");
					modelo.verificarNumero(finX);
					finY = vista.leerDato("Ingrese la cordenada y del punto de llegada de la liebre");
					modelo.verificarNumero(finY);
					caminosP = vista.leerDato("Ingrese el numero de caminos P");
					modelo.verificarNumero(caminosP);
					caminosQ = vista.leerDato("Ingrese el numero de caminos Q");
					modelo.verificarNumero(caminosQ);
					modelo.getLaberintoLiebre().buscarSaltosLiebre(Integer.parseInt(numeroFilas), Integer.parseInt(numeroColumnas),
							Integer.parseInt(inicioX), Integer.parseInt(inicioY), Integer.parseInt(finX),
							Integer.parseInt(finY), Integer.parseInt(caminosP), Integer.parseInt(caminosQ));

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
