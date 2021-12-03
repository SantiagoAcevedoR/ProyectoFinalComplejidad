
package co.edu.unbosque.model;

public class Comida {
 
	private String nombre;
    private int beneficio;

    public Comida(String nombre, int beneficio) {
        this.beneficio = beneficio;
        this.nombre = nombre;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
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

    @Override
    public String toString(){
        return "Nombre:"+nombre+","+" beneficio:"+beneficio;
    }
    
    
}
