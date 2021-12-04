/**
 * paquete modelo
 */
package co.edu.unbosque.model;
/**
 * 
 * @author Santiado Acevedo Rodriguez, Jhoan Ricardo Cuevas Patiño, Robinson
 *         José Gutierrez Solano.
 */
public class Comida {
 
	private String nombre;
    private int beneficio;
    /**
     * Metodo constructor de la clase con instancias de la clase
     * @param nombre nombre del plato
     * @param beneficio calorias de beneficio del plato
     */
    public Comida(String nombre, int beneficio) {
        this.beneficio = beneficio;
        this.nombre = nombre;
    }

  
    /**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo que verifica calorias de los platos
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
        final Comida other = (Comida) obj;
        if (this.beneficio != other.beneficio) {
            return false;
        }
        return true;
    }
	/**
	 * Metodo toString por defecto de la clase
	 */
    @Override
    public String toString(){
        return "Nombre:"+nombre+","+" beneficio:"+beneficio;
    }


	/**
	 * @return the beneficio
	 */
	public int getBeneficio() {
		return beneficio;
	}


	/**
	 * @param beneficio the beneficio to set
	 */
	public void setBeneficio(int beneficio) {
		this.beneficio = beneficio;
	}
    
    
    
    
}
