package utils;

import java.util.Scanner;
import model.Temporada;

public class InputTemporada {
    public static Temporada solicitarTemporada(Scanner scanner) {
        int numero = solicitarNumero(scanner, "Número de temporada");
        int episodios = solicitarNumero(scanner, "Cantidad de episodios");
        int añoEstreno = solicitarNumero(scanner, "Año de estreno");
        String sinopsis = solicitarTexto(scanner, "Sinopsis");
        return new Temporada(numero, episodios, añoEstreno, sinopsis);
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
