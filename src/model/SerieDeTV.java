/**
 * Class SerieDeTV
 */
package model;

import java.util.ArrayList;
import java.util.List;

// Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
    private int temporadas;
    // Lista de temporadas (composición)
    private List<Temporada> listaTemporadas;

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
        this.listaTemporadas = new ArrayList<>();
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    // Métodos para manejar la lista de temporadas
    public List<Temporada> getListaTemporadas() {
        return listaTemporadas;
    }

    public void agregarTemporada(Temporada temporada) {
        this.listaTemporadas.add(temporada);
        this.temporadas = listaTemporadas.size(); // Actualiza el número de temporadas
    }

    public void eliminarTemporada(Temporada temporada) {
        this.listaTemporadas.remove(temporada);
        this.temporadas = listaTemporadas.size();
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la serie de TV:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Temporadas: " + this.temporadas);
        System.out.println("Lista de temporadas:");
        for (Temporada temp : listaTemporadas) {
            System.out.println("  - " + temp);
        }
        System.out.println();
    }
}