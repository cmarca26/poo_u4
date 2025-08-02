package utils;

import java.util.Scanner;
import model.Actor;

public class InputActor {
    public static Actor solicitarActor(Scanner scanner) {
        String nombre = solicitarTexto(scanner, "Nombre del actor");
        int edad = solicitarNumero(scanner, "Edad");
        String nacionalidad = solicitarTexto(scanner, "Nacionalidad");
        String personaje = solicitarTexto(scanner, "Personaje");
        return new Actor(nombre, edad, nacionalidad, personaje);
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
