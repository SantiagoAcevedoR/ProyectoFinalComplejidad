package co.edu.unbosque.model;

public class MenuOptimo {

	public MenuOptimo() {

	}

	public void calcularMenuOptimo(String[][] platos, int minimoCalorias) {
		Comida[] elementos = new Comida[platos.length];

		for (int i = 0; i < platos.length; i++) {
			elementos[i] = new Comida(platos[i][0], Integer.parseInt(platos[i][1]));

		}
		Menu m_base = new Menu(minimoCalorias, elementos.length);
		Menu m_opt = new Menu(minimoCalorias, elementos.length);

		Menu menuOptimo = llenarMochila(m_base, elementos, false, m_opt);

		System.out.println(menuOptimo);
	}

	public static Menu llenarMochila(Menu m_base, Comida[] elementos, boolean llena, Menu m_opt) {

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
						llenarMochila(m_base, elementos, false, m_opt);
						m_base.eliminarElemento(elementos[i]);
					} else {
						llenarMochila(m_base, elementos, true, m_opt);
					}
				}
			}
		}

		return m_opt;
	}
}
