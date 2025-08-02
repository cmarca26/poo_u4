package utils;

import java.util.Scanner;
import model.Investigador;

public class InputInvestigador {
    public static Investigador solicitarInvestigador(Scanner scanner) {
        String nombre = solicitarTexto(scanner, "Nombre del investigador");
        String institucion = solicitarTexto(scanner, "Institución");
        String especialidad = solicitarTexto(scanner, "Especialidad");
        int años = solicitarNumero(scanner, "Años de experiencia");
        return new Investigador(nombre, institucion, especialidad, años);
    }

    private static String solicitarTexto(Scanner scanner, String campo) {
        System.out.print(campo + ": ");
        String texto = scanner.nextLine();
        Validador.validarTexto(texto, campo);
        return texto;
    }

    private static int solicitarNumero(Scanner scanner, String campo) {
        System.out.print(campo + ": ");
        while (true) {
            try {
                int numero = Integer.parseInt(scanner.nextLine());
                Validador.validarNumeroPositivo(numero, campo);
                return numero;
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Intente de nuevo: ");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
