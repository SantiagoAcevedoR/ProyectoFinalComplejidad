
package co.edu.unbosque.model;

public class Menu {

    private int pesoMaximo;
    private Comida[] elementos;
    private int beneficio;

    public Menu(int pesoMaximo, int numElementos) {
        this.pesoMaximo = pesoMaximo;
        this.elementos = new Comida[numElementos];
        this.beneficio = 0;
    }

    public Comida[] getElementos() {
        return elementos;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    /**
     * Añade un elemento a la mochila
     * @param e 
     */
    public void aniadirElemento(Comida e) {

        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] == null) {
                this.elementos[i] = e; //lo añade
                this.beneficio+=e.getBeneficio(); // aumenta el beneficio
                break;
            }
        }

    }

    /**
     * Vaciamos la mochila
     */
    public void clear() {
        this.beneficio=0;
        for (int i = 0; i < this.elementos.length; i++) {
            this.elementos[i] = null;
        }
    }

    /**
     * Elimina elemento dado
     * @param e 
     */
    public void eliminarElemento(Comida e) {
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i].equals(e)) {
                this.elementos[i] = null; //el elemento fuera
                this.beneficio-=e.getBeneficio(); // reduce el beneficio
                break;
            }
        }
    }
    
    /**
     * Indica si existe un elemento
     * @param e
     * @return 
     */
    public boolean existeElemento(Comida e) {
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] != null && this.elementos[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Muestra la mochila
     * @return 
     */
    public String toString() {
        String cadena="";
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] != null) {
                cadena+=elementos[i]+"\n";
            }
        }

        cadena+="Beneficio: " + getBeneficio()+"\n";
        return cadena;
    }

}
