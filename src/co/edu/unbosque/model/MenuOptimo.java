/**
 * Paquete model
 */
package co.edu.unbosque.model;

/**
 * 
 * @author Santiado Acevedo Rodriguez, Jhoan Ricardo Cuevas Patiño, Robinson
 *         José Gutierrez Solano.
 */
public class MenuOptimo {

	/**
	 * Constructor vacio
	 */
	public MenuOptimo() {

	}

	/**
	 * Este metodo se encarga de calcular los menus posibles de tal manera que
	 * encuentre el menu mas optimo
	 * 
	 * @param platos,         son los platos disponibles del menu
	 * @param minimoCalorias, el minimo de calorias que quiere el usuario
	 */
	public void calcularMenuOptimo(String[][] platos, int minimoCalorias) {
		Comida[] elementos = new Comida[platos.length];

		for (int i = 0; i < platos.length; i++) {
			elementos[i] = new Comida(platos[i][0], Integer.parseInt(platos[i][1]));

		}
		Menu m_base = new Menu(minimoCalorias, elementos.length);
		Menu m_opt = new Menu(minimoCalorias, elementos.length);

		Menu menuOptimo = llenarMenu(m_base, elementos, false, m_opt);

		System.out.println(menuOptimo);
	}

	/**
	 * Este metodo se encarga de hallar el beneficio de calorias por medio de los
	 * platos dados hasta hallar el numero de calorias minimas
	 * 
	 * @param m_base,    menu base
	 * @param elementos, comidas
	 * @param llena,     verifica si el plato esta lleno, es decir si este ya
	 *                   contiene las calorias minimas
	 * @param m_opt,     es el plato optimo @return, retorna el plato optimo
	 */
	public Menu llenarMenu(Menu m_base, Comida[] elementos, boolean llena, Menu m_opt) {

		if (llena) {
			if (m_base.getBeneficio() > m_opt.getBeneficio()) {

				Comida[] elementosMochBase = m_base.getElementos();
				m_opt.clear();

				for (Comida e : elementosMochBase) {
					if (e != null) {
						m_opt.aniadirElemento(e);
					}

				}

			}

		} else {
			for (int i = 0; i < elementos.length; i++) {
				if (!m_base.existeElemento(elementos[i])) {
					if (m_base.getPesoMaximo() >= m_base.getBeneficio() + elementos[i].getBeneficio()) {
						m_base.aniadirElemento(elementos[i]);
						llenarMenu(m_base, elementos, false, m_opt);
						m_base.eliminarElemento(elementos[i]);
					} else {
						llenarMenu(m_base, elementos, true, m_opt);
					}
				}
			}
		}

		return m_opt;
	}
}
