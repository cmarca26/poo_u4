/**
 * Class Pelicula
 */
package model;

import java.util.ArrayList;
import java.util.List;

// Subclase Pelicula que extiende de ContenidoAudiovisual
public class Pelicula extends ContenidoAudiovisual {
    private String estudio;
    // Lista de actores (agregación)
    private List<Actor> actores;

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
        this.actores = new ArrayList<>();
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    // Métodos para manejar la lista de actores
    public List<Actor> getActores() {
        return actores;
    }

    public void agregarActor(Actor actor) {
        this.actores.add(actor);
    }

    public void eliminarActor(Actor actor) {
        this.actores.remove(actor);
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la película:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Estudio: " + estudio);
        System.out.println("Actores:");
        for (Actor actor : actores) {
            System.out.println("  - " + actor);
        }
        System.out.println();
    }

    @Override
    public String[] toCSV() {
        String actoresStr = "";
        if (actores != null && !actores.isEmpty()) {
            List<String> datos = new ArrayList<>();
            for (Actor actor : actores) {
                datos.add(String.join(";", actor.toCSV()));
            }
            actoresStr = String.join("|", datos);
        }
        return new String[] {
                String.valueOf(getId()),
                getTitulo(),
                String.valueOf(getDuracionEnMinutos()),
                getGenero(),
                estudio,
                actoresStr
        };
    }

    @Override
    public void fromCSV(String[] data) {
        setTitulo(data[1]);
        setDuracionEnMinutos(Integer.parseInt(data[2]));
        setGenero(data[3]);
        setEstudio(data[4]);
        actores = new ArrayList<>();
        if (data.length > 5 && !data[5].isEmpty()) {
            String[] registros = data[5].split("\\|");
            for (String registro : registros) {
                String[] campos = registro.split(";");
                Actor actor = new Actor("", 0, "", "");
                actor.fromCSV(campos);
                actores.add(actor);
            }
        }
    }
}