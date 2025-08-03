package utils;

import java.util.Scanner;
import model.Documental;

public class InputDocumental {

    /**
     * Solicita los datos necesarios para crear un Documental.
     *
     * @param scanner Scanner para leer la entrada del usuario.
     * @return Un objeto Documental con los datos ingresados.
     */
    public static Documental solicitarDocumental(Scanner scanner) {
        String titulo = InputHelper.solicitarTexto(scanner, "Título");
        int duracion = InputHelper.solicitarNumero(scanner, "Duración en minutos");
        String genero = InputHelper.solicitarTexto(scanner, "Género");
        String tema = InputHelper.solicitarTexto(scanner, "Tema");
        return new Documental(titulo, duracion, genero, tema);
    }
}
