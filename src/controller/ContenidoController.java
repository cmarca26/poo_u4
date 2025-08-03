package controller;

import model.*;
import java.util.ArrayList;
import java.util.List;
import utils.CSVManager;

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

    // Guarda todos los contenidos en un archivo CSV
    public void guardarContenidos(String rutaArchivo) throws Exception {
        List<String[]> datos = new ArrayList<>();
        for (ContenidoAudiovisual contenido : contenidos) {
            String tipo = "";
            if (contenido instanceof Pelicula) tipo = "Pelicula";
            else if (contenido instanceof SerieDeTV) tipo = "SerieDeTV";
            else if (contenido instanceof Documental) tipo = "Documental";
            String[] registro = contenido.toCSV();
            // Prepend tipo al registro
            String[] registroCompleto = new String[registro.length + 1];
            registroCompleto[0] = tipo;
            System.arraycopy(registro, 0, registroCompleto, 1, registro.length);
            datos.add(registroCompleto);
        }
        CSVManager.writeCSV(rutaArchivo, datos);
    }

    // Carga los contenidos desde un archivo CSV
    public void cargarContenidos(String rutaArchivo) throws Exception {
        contenidos.clear();
        List<String[]> datos = utils.CSVManager.readCSV(rutaArchivo);
        for (String[] fila : datos) {
            if (fila.length > 1) {
                String tipo = fila[0];
                String[] datosContenido = new String[fila.length - 1];
                System.arraycopy(fila, 1, datosContenido, 0, datosContenido.length);
                if ("Pelicula".equalsIgnoreCase(tipo)) {
                    Pelicula peli = new Pelicula("", 0, "", "");
                    peli.fromCSV(datosContenido);
                    contenidos.add(peli);
                } else if ("SerieDeTV".equalsIgnoreCase(tipo)) {
                    SerieDeTV serie = new SerieDeTV("", 0, "", 0);
                    serie.fromCSV(datosContenido);
                    contenidos.add(serie);
                } else if ("Documental".equalsIgnoreCase(tipo)) {
                    Documental doc = new Documental("", 0, "", "");
                    doc.fromCSV(datosContenido);
                    contenidos.add(doc);
                }
            }
        }
    }
}
