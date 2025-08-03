package utils;

import java.util.Scanner;
import model.SerieDeTV;

public class InputSerieDeTV {

    /**
     * Solicita los datos necesarios para crear una Serie de TV.
     *
     * @param scanner Scanner para leer la entrada del usuario.
     * @return Un objeto SerieDeTV con los datos ingresados.
     */
    public static SerieDeTV solicitarSerieDeTV(Scanner scanner) {
        String titulo = InputHelper.solicitarTexto(scanner, "Título");
        int duracion = InputHelper.solicitarNumero(scanner, "Duración en minutos");
        String genero = InputHelper.solicitarTexto(scanner, "Género");
        return new SerieDeTV(titulo, duracion, genero, 0);
    }
}
