package utils;

public class Validador {
    public static void validarTexto(String texto, String campo) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo '" + campo + "' no puede estar vacío.");
        }
    }

    public static void validarNumeroPositivo(int numero, String campo) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El campo '" + campo + "' debe ser un número positivo.");
        }
    }
}
