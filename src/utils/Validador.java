package utils;

public class Validador {

    /**
     * Valida que el texto no sea nulo o vacío.
     *
     * @param texto El texto a validar.
     * @param campo El nombre del campo para el mensaje de error.
     * @throws IllegalArgumentException Si el texto es nulo o vacío.
     */
    public static void validarTexto(String texto, String campo) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo '" + campo + "' no puede estar vacío.");
        }
    }

    /**
     * Valida que el número sea positivo.
     *
     * @param numero El número a validar.
     * @param campo  El nombre del campo para el mensaje de error.
     * @throws IllegalArgumentException Si el número es menor o igual a cero.
     */
    public static void validarNumeroPositivo(int numero, String campo) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El campo '" + campo + "' debe ser un número positivo.");
        }
    }
}
