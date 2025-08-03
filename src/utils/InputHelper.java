package utils;

import java.util.Scanner;

public class InputHelper {

    /**
     * Solicita un texto al usuario y lo valida.
     *
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     * @param campo   El nombre del campo que se está solicitando.
     * @return El texto ingresado por el usuario.
     */
    public static String solicitarTexto(Scanner scanner, String campo) {
        while (true) {
            System.out.print(campo + ": ");
            String texto = scanner.nextLine().trim();

            try {
                Validador.validarTexto(texto, campo);
                return texto;
            } catch (IllegalArgumentException e) {
                System.out.println("Entrada inválida: " + e.getMessage());
                System.out.println("Por favor, intente nuevamente.");
            }
        }
    }

    /*
     * Solicita un número entero positivo al usuario y lo valida.
     * 
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     * @param campo   El nombre del campo que se está solicitando.
     * @return El número entero positivo ingresado por el usuario.
     * @throws IllegalArgumentException si el número ingresado no es válido.
     */
    public static int solicitarNumero(Scanner scanner, String campo) {
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
