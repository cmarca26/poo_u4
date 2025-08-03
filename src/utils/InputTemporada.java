package utils;

import java.util.Scanner;
import model.Temporada;

public class InputTemporada {

    /**
     * Solicita los datos de una temporada al usuario.
     *
     * @param scanner Scanner para leer la entrada del usuario.
     * @return Un objeto Temporada con los datos ingresados.
     */
    public static Temporada solicitarTemporada(Scanner scanner) {
        int numero = InputHelper.solicitarNumero(scanner, "Número de temporada");
        int episodios = InputHelper.solicitarNumero(scanner, "Cantidad de episodios");
        int añoEstreno = InputHelper.solicitarNumero(scanner, "Año de estreno");
        String sinopsis = InputHelper.solicitarTexto(scanner, "Sinopsis");
        return new Temporada(numero, episodios, añoEstreno, sinopsis);
    }
}
