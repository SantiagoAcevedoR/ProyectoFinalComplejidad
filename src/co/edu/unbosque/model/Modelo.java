/**
 * Paquete model
 */
package co.edu.unbosque.model;

public class Modelo {

	private LaberintoLiebre laberintoLiebre;

	private MenuOptimo menuOptimo;

	public Modelo() {
		laberintoLiebre = new LaberintoLiebre();
		menuOptimo = new MenuOptimo();
	}

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
	 * @return the laberintoLiebre
	 */
	public LaberintoLiebre getLaberintoLiebre() {
		return laberintoLiebre;
	}

	/**
	 * @param laberintoLiebre the laberintoLiebre to set
	 */
	public void setLaberintoLiebre(LaberintoLiebre laberintoLiebre) {
		this.laberintoLiebre = laberintoLiebre;
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
