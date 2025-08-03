/**
 * Class Documental
 */
package model;

import java.util.ArrayList;
import java.util.List;

// Subclase Documental que extiende de ContenidoAudiovisual
public class Documental extends ContenidoAudiovisual {
    private String tema;
    // Lista de investigadores
    private List<Investigador> investigadores;

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigadores = new ArrayList<>();
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    // Métodos para manejar la lista de investigadores
    public List<Investigador> getInvestigadores() {
        return investigadores;
    }

    public void agregarInvestigador(Investigador investigador) {
        this.investigadores.add(investigador);
    }

    public void eliminarInvestigador(Investigador investigador) {
        this.investigadores.remove(investigador);
    }
    

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del documental:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + this.tema);
        System.out.println("Investigadores:");
        for (Investigador inv : investigadores) {
            System.out.println("  - " + inv);
        }
        System.out.println();
    }

    @Override
    public String[] toCSV() {
        String investigadoresStr = "";
        if (investigadores != null && !investigadores.isEmpty()) {
            List<String> datos = new ArrayList<>();
            for (Investigador inv : investigadores) {
                datos.add(String.join(";", inv.toCSV()));
            }
            investigadoresStr = String.join("|", datos);
        }
        return new String[] {
                String.valueOf(getId()),
                getTitulo(),
                String.valueOf(getDuracionEnMinutos()),
                getGenero(),
                tema,
                investigadoresStr
        };
    }

    @Override
    public void fromCSV(String[] data) {
        setTitulo(data[1]);
        setDuracionEnMinutos(Integer.parseInt(data[2]));
        setGenero(data[3]);
        setTema(data[4]);
        investigadores = new ArrayList<>();
        if (data.length > 5 && !data[5].isEmpty()) {
            String[] registros = data[5].split("\\|");
            for (String registro : registros) {
                String[] campos = registro.split(";");
                Investigador inv = new Investigador("", "", "", 0);
                inv.fromCSV(campos);
                investigadores.add(inv);
            }
        }
    }
}