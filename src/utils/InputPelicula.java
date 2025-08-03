package utils;

import java.util.Scanner;
import model.Pelicula;

public class InputPelicula {

    /**
     * Solicita los datos de una película al usuario.
     *
     * @param scanner Scanner para leer la entrada del usuario.
     * @return Un objeto Pelicula con los datos ingresados.
     */
    public static Pelicula solicitarPelicula(Scanner scanner) {
        String titulo = InputHelper.solicitarTexto(scanner, "Título");
        int duracion = InputHelper.solicitarNumero(scanner, "Duración en minutos");
        String genero = InputHelper.solicitarTexto(scanner, "Género");
        String estudio = InputHelper.solicitarTexto(scanner, "Estudio");
        return new Pelicula(titulo, duracion, genero, estudio);
    }
}
