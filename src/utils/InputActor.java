package utils;

import java.util.Scanner;
import model.Actor;

public class InputActor {

    /**
     * Solicita los datos de un actor al usuario.
     *
     * @param scanner Scanner para leer la entrada del usuario.
     * @return Un objeto Actor con los datos ingresados.
     */
    public static Actor solicitarActor(Scanner scanner) {
        String nombre = InputHelper.solicitarTexto(scanner, "Nombre del actor");
        int edad = InputHelper.solicitarNumero(scanner, "Edad");
        String nacionalidad = InputHelper.solicitarTexto(scanner, "Nacionalidad");
        String personaje = InputHelper.solicitarTexto(scanner, "Personaje");
        return new Actor(nombre, edad, nacionalidad, personaje);
    }
}
