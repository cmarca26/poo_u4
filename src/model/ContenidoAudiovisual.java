package model;

/**
 * Clase abstracta que representa un contenido audiovisual.
 * Implementa la interfaz Visualizable.
 */
public abstract class ContenidoAudiovisual implements Visualizable, CSVSerializable {
    private static int contar = 0;
    private String titulo;
    private int duracionEnMinutos;
    private String genero;
    private int id;

    public ContenidoAudiovisual(String titulo, int duracionEnMinutos, String genero) {
        this.id = contar++;
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.genero = genero;
    }

    // Getter y Setter para el campo 'titulo'
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getter y Setter para el campo 'duracionEnMinutos'
    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    // Getter y Setter para el campo 'genero'
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Getter para el campo 'id' (no se proporciona el Setter ya que 'id' se asigna
    // en el constructor y parece ser inmutable)
    public int getId() {
        return id;
    }

    public abstract void mostrarDetalles();

    /**
     * Convierte el contenido audiovisual a un formato CSV.
     */
    @Override
    public String[] toCSV() {
        // Serializa los atributos base
        return new String[] {
            String.valueOf(id),
            titulo,
            String.valueOf(duracionEnMinutos),
            genero
        };
    }

    /**
     * Deserializa los datos desde un formato CSV.
     * 
     * @param data Datos en formato CSV.
     */
    @Override
    public void fromCSV(String[] data) {
        // Deserializa los atributos base
        // El id normalmente es gestionado por el sistema, pero puedes asignarlo si lo necesitas
        if (data.length > 0) {
            this.titulo = data[1];
            this.duracionEnMinutos = Integer.parseInt(data[2]);
            this.genero = data[3];
        }
    }
}