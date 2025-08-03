package utils;

import java.util.Scanner;
import model.Investigador;

public class InputInvestigador {

    /**
     * Solicita los datos de un investigador al usuario.
     *
     * @param scanner Scanner para leer la entrada del usuario.
     * @return Un objeto Investigador con los datos ingresados.
     */
    public static Investigador solicitarInvestigador(Scanner scanner) {
        String nombre = InputHelper.solicitarTexto(scanner, "Nombre del investigador");
        String institucion = InputHelper.solicitarTexto(scanner, "Institución");
        String especialidad = InputHelper.solicitarTexto(scanner, "Especialidad");
        int años = InputHelper.solicitarNumero(scanner, "Años de experiencia");
        return new Investigador(nombre, institucion, especialidad, años);
    }
}
