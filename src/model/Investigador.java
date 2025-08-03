package model;

/**
 * Clase que representa a un Investigador en un documental o contenido audiovisual.
 */
public class Investigador implements CSVSerializable {
    // Nombre del investigador
    private String nombre;
    // Institución a la que pertenece
    private String institucion;
    // Especialidad del investigador
    private String especialidad; 
    // Años de experiencia del investigador
    private int añosExperiencia; 

    /**
     * Constructor de la clase Investigador
     * @param nombre Nombre del investigador
     * @param institucion Institución a la que pertenece
     * @param especialidad Especialidad del investigador
     * @param añosExperiencia Años de experiencia
     */
    public Investigador(String nombre, String institucion, String especialidad, int añosExperiencia) {
        this.nombre = nombre;
        this.institucion = institucion;
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para institucion
    public String getInstitucion() {
        return institucion;
    }

    // Setter para institucion
    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    // Getter para especialidad
    public String getEspecialidad() {
        return especialidad;
    }

    // Setter para especialidad
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Getter para añosExperiencia
    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    // Setter para añosExperiencia
    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    /**
     * Devuelve una representación en cadena del investigador
     */
    @Override
    public String toString() {
        return nombre + " (" + especialidad + ", " + añosExperiencia + " años) - " + institucion;
    }

    /**
     * Convierte el investigador a un formato CSV.
     */
    @Override
    public String[] toCSV() {
        return new String[] {
                nombre,
                institucion,
                especialidad,
                String.valueOf(añosExperiencia)
        };
    }

    /**
     * Deserializa los datos desde un formato CSV.
     * @param data Datos en formato CSV.
     */
    @Override
    public void fromCSV(String[] data) {
        if (data.length < 4) {
            throw new IllegalArgumentException("Datos insuficientes para deserializar Investigador");
        }
        this.nombre = data[0];
        this.institucion = data[1];
        this.especialidad = data[2];
        this.añosExperiencia = Integer.parseInt(data[3]);
    }
}