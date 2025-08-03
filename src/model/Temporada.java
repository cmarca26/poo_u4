package model;

/**
 * Clase que representa una temporada de una serie de TV.
 */
public class Temporada implements CSVSerializable {
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

    /**
     * Convierte la temporada a un formato CSV.
     */
    @Override
    public String[] toCSV() {
        return new String[] {
            String.valueOf(numero),
            String.valueOf(episodios),
            String.valueOf(añoEstreno),
            sinopsis
        };
    }

    /**
     * Deserializa los datos de la temporada desde un formato CSV.
     */
    @Override
    public void fromCSV(String[] data) {
        if (data.length != 4) {
            throw new IllegalArgumentException("Datos insuficientes para deserializar Temporada");
        }
        this.numero = Integer.parseInt(data[0]);
        this.episodios = Integer.parseInt(data[1]);
        this.añoEstreno = Integer.parseInt(data[2]);
        this.sinopsis = data[3];
    }
}