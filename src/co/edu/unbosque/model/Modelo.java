/**
 * Paquete model
 */
package co.edu.unbosque.model;

/**
 * 
 * @author Santiado Acevedo Rodriguez, Jhoan Ricardo Cuevas Patiño, Robinson
 *         José Gutierrez Solano.
 */
public class Modelo {

	private CampoLiebre campoLibre;
	private MenuOptimo menuOptimo;

	/**
	 * Contructor vacio
	 */
	public Modelo() {
		campoLibre = new CampoLiebre();
		menuOptimo = new MenuOptimo();
	}

	/**
	 * Se encarga de verificar si un dato tipo string contine solo numeros
	 * 
	 * @param numero
	 * @return
	 */
	public boolean soloNumeros(String numero) {
		for (int i = 0; i < numero.length(); i++) {
			char aux = numero.charAt(i);
			int digito = aux - '0';
			if (digito > 9 || digito < 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Este metodo se encarga de capturar los String que contengan caracteres
	 * diferentes a los numeros
	 * 
	 * @param numero, String a verificar @return, retorna el mensaje de error
	 *                indicando lo que debera hacer
	 * @throws ExceptionNumero, si el el mensaje contiene numero o es menor a cero.
	 */
	public String verificarNumero(String numero) throws ExceptionNumero {
		String resultado = "";
		try {
			if (numero.length() == 0) {
				throw new ExceptionNumero("Por favor algun dato");
			} else if (!soloNumeros(numero)) {
				throw new ExceptionNumero("Caracter no permitido en campo numérico");
			} else {
				if (Integer.parseInt(numero) <= 0) {
					throw new ExceptionNumero("Ingrese una cantidad minimo de uno");
				}
			}
		} catch (ExceptionNumero e) {
			resultado = e.getMessage();
		}
		return resultado;
	}

	/**
	 * @return the campoLibre
	 */
	public CampoLiebre getCampoLibre() {
		return campoLibre;
	}

	/**
	 * @param campoLibre the campoLibre to set
	 */
	public void setCampoLibre(CampoLiebre campoLibre) {
		this.campoLibre = campoLibre;
	}

	/**
	 * @return the menuOptimo
	 */
	public MenuOptimo getMenuOptimo() {
		return menuOptimo;
	}

	/**
	 * @param menuOptimo the menuOptimo to set
	 */
	public void setMenuOptimo(MenuOptimo menuOptimo) {
		this.menuOptimo = menuOptimo;
	}
}
