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

    @Override
    public String[] toCSV() {
        String temporadasStr = "";
        if (listaTemporadas != null && !listaTemporadas.isEmpty()) {
            List<String> datos = new ArrayList<>();
            for (Temporada temp : listaTemporadas) {
                datos.add(String.join(";", temp.toCSV()));
            }
            temporadasStr = String.join("|", datos);
        }
        return new String[] {
                String.valueOf(getId()),
                getTitulo(),
                String.valueOf(getDuracionEnMinutos()),
                getGenero(),
                String.valueOf(temporadas),
                temporadasStr
        };
    }

    @Override
    public void fromCSV(String[] data) {
        setTitulo(data[1]);
        setDuracionEnMinutos(Integer.parseInt(data[2]));
        setGenero(data[3]);
        setTemporadas(Integer.parseInt(data[4]));
        listaTemporadas = new ArrayList<>();
        if (data.length > 5 && !data[5].isEmpty()) {
            String[] registros = data[5].split("\\|");
            for (String registro : registros) {
                String[] campos = registro.split(";");
                Temporada temp = new Temporada(0, 0, 0, "");
                temp.fromCSV(campos);
                listaTemporadas.add(temp);
            }
        }
    }
}