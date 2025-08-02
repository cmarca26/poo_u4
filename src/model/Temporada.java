package model;

/**
 * Clase que representa una temporada de una serie de TV.
 */
public class Temporada {
    // Número de la temporada
    private int numero;
    // Cantidad de episodios en la temporada
    private int episodios;
    // Año de estreno de la temporada
    private int añoEstreno;     
    // Sinopsis de la temporada
    private String sinopsis;   

    /**
     * Constructor de la clase Temporada
     * @param numero Número de la temporada
     * @param episodios Cantidad de episodios
     * @param añoEstreno Año de estreno
     * @param sinopsis Sinopsis de la temporada
     */
    public Temporada(int numero, int episodios, int añoEstreno, String sinopsis) {
        this.numero = numero;
        this.episodios = episodios;
        this.añoEstreno = añoEstreno;
        this.sinopsis = sinopsis;
    }

    // Getter para numero
    public int getNumero() {
        return numero;
    }

    // Setter para numero
    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Getter para episodios
    public int getEpisodios() {
        return episodios;
    }

    // Setter para episodios
    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    // Getter para añoEstreno
    public int getAñoEstreno() {
        return añoEstreno;
    }

    // Setter para añoEstreno
    public void setAñoEstreno(int añoEstreno) {
        this.añoEstreno = añoEstreno;
    }

    // Getter para sinopsis
    public String getSinopsis() {
        return sinopsis;
    }

    // Setter para sinopsis
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    /**
     * Devuelve una representación en cadena de la temporada
     */
    @Override
    public String toString() {
        return "T" + numero + " (" + añoEstreno + "): " + episodios + " episodios - " + sinopsis;
    }
}