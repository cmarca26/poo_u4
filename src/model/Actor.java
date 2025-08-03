package model;

/**
 * Clase que representa a un Actor en un contenido audiovisual.
 */
public class Actor implements CSVSerializable {
    // Nombre del actor
    private String nombre;
    // Edad del actor
    private int edad;
    // Nacionalidad del actor
    private String nacionalidad; 
    // Personaje interpretado por el actor
    private String personaje;    

    /**
     * Constructor de la clase Actor
     * @param nombre Nombre del actor
     * @param edad Edad del actor
     * @param nacionalidad Nacionalidad del actor
     * @param personaje Personaje interpretado
     */
    public Actor(String nombre, int edad, String nacionalidad, String personaje) {
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.personaje = personaje;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para edad
    public int getEdad() {
        return edad;
    }

    // Setter para edad
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Getter para nacionalidad
    public String getNacionalidad() {
        return nacionalidad;
    }

    // Setter para nacionalidad
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    // Getter para personaje
    public String getPersonaje() {
        return personaje;
    }

    // Setter para personaje
    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    /**
     * Devuelve una representación en cadena del actor
     */
    @Override
    public String toString() {
        return nombre + " (" + edad + " años) - " + personaje + " [" + nacionalidad + "]";
    }

    /**
     * Devuelve una representación en formato CSV del actor
     */
    @Override
    public String[] toCSV() {
        return new String[] {
                nombre,
                String.valueOf(edad),
                nacionalidad,
                personaje
        };
    }

    /**
     * Deserializa los datos desde un formato CSV
     * @param data Datos en formato CSV
     */
    @Override
    public void fromCSV(String[] data) {
        if (data.length != 4) {
            throw new IllegalArgumentException("Datos insuficientes para deserializar Actor");
        }
        this.nombre = data[0];
        this.edad = Integer.parseInt(data[1]);
        this.nacionalidad = data[2];
        this.personaje = data[3];
    }
}
