package controller;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class ContenidoController {
    private List<ContenidoAudiovisual> contenidos;

    public ContenidoController() {
        contenidos = new ArrayList<>();
    }

    public void agregarPelicula(Pelicula pelicula) {
        contenidos.add(pelicula);
    }

    public void agregarSerie(SerieDeTV serie) {
        contenidos.add(serie);
    }

    public void agregarDocumental(Documental documental) {
        contenidos.add(documental);
    }

    public List<ContenidoAudiovisual> getContenidos() {
        return contenidos;
    }
}
