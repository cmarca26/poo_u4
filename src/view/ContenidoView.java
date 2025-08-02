package view;

import controller.ContenidoController;
import model.*;
import utils.Validador;
import utils.InputActor;
import utils.InputTemporada;
import utils.InputInvestigador;
import java.util.Scanner;

public class ContenidoView {
    private final ContenidoController controller;
    private final Scanner scanner;

    public ContenidoView(ContenidoController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    private void mostrarMenu() {
        System.out.println("\n");
        System.out.println("--- Menú de Contenidos Audiovisuales ---");
        System.out.println("1. Agregar Película");
        System.out.println("2. Agregar Serie de TV");
        System.out.println("3. Agregar Documental");
        System.out.println("4. Mostrar todos los contenidos");
        System.out.println("0. Salir");
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = solicitarOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 0);
    }

    private int solicitarOpcion() {
        System.out.print("Seleccione una opción: ");
        return leerEntero();
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                agregarPelicula();
                break;
            case 2:
                agregarSerie();
                break;
            case 3:
                agregarDocumental();
                break;
            case 4:
                mostrarContenidos();
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private void agregarPelicula() {
        System.out.println("--- Agregar Película ---");
        try {
            Pelicula pelicula = crearPelicula();
            agregarActoresAPelicula(pelicula);
            controller.agregarPelicula(pelicula);
            System.out.println("Película agregada correctamente.\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private Pelicula crearPelicula() {
        String titulo = solicitarTexto("Título");
        int duracion = solicitarNumero("Duración en minutos");
        String genero = solicitarTexto("Género");
        String estudio = solicitarTexto("Estudio");
        return new Pelicula(titulo, duracion, genero, estudio);
    }

    private void agregarActoresAPelicula(Pelicula pelicula) {
        boolean agregarMas;
        do {
            System.out.print("¿Agregar actor? (s/n): ");
            agregarMas = scanner.nextLine().trim().equalsIgnoreCase("s");
            if (agregarMas) {
                Actor actor = InputActor.solicitarActor(scanner);
                pelicula.agregarActor(actor);
            }
        } while (agregarMas);
    }

    private void agregarSerie() {
        System.out.println("--- Agregar Serie de TV ---");
        try {
            SerieDeTV serie = crearSerie();
            agregarTemporadasASerie(serie);
            controller.agregarSerie(serie);
            System.out.println("Serie agregada correctamente.\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private SerieDeTV crearSerie() {
        String titulo = solicitarTexto("Título");
        int duracion = solicitarNumero("Duración en minutos");
        String genero = solicitarTexto("Género");
        return new SerieDeTV(titulo, duracion, genero, 0);
    }

    private void agregarTemporadasASerie(SerieDeTV serie) {
        boolean agregarMas;
        do {
            System.out.print("¿Agregar temporada? (s/n): ");
            agregarMas = scanner.nextLine().trim().equalsIgnoreCase("s");
            if (agregarMas) {
                Temporada temporada = InputTemporada.solicitarTemporada(scanner);
                serie.agregarTemporada(temporada);
            }
        } while (agregarMas);
    }

    private void agregarDocumental() {
        System.out.println("--- Agregar Documental ---");
        try {
            Documental documental = crearDocumental();
            agregarInvestigadoresADocumental(documental);
            controller.agregarDocumental(documental);
            System.out.println("Documental agregado correctamente.\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private Documental crearDocumental() {
        String titulo = solicitarTexto("Título");
        int duracion = solicitarNumero("Duración en minutos");
        String genero = solicitarTexto("Género");
        String tema = solicitarTexto("Tema");
        return new Documental(titulo, duracion, genero, tema);
    }

    private void agregarInvestigadoresADocumental(Documental documental) {
        boolean agregarMas;
        do {
            System.out.print("¿Agregar investigador? (s/n): ");
            agregarMas = scanner.nextLine().trim().equalsIgnoreCase("s");
            if (agregarMas) {
                Investigador investigador = InputInvestigador.solicitarInvestigador(scanner);
                documental.agregarInvestigador(investigador);
            }
        } while (agregarMas);
    }

    private void mostrarContenidos() {
        System.out.println("\n==============================");
        System.out.println("--- Contenidos Audiovisuales ---");
        if (controller.getContenidos().isEmpty()) {
            System.out.println("No hay contenidos audiovisuales registrados.");
        } else {
            for (ContenidoAudiovisual contenido : controller.getContenidos()) {
                contenido.mostrarDetalles();
            }
        }
        System.out.println();
    }

    private int leerEntero() {
        while (true) {
            try {
                if (!scanner.hasNextLine()) {
                    System.out.println("No hay más entrada disponible. Cerrando aplicación.");
                    System.exit(0);
                }
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Intente de nuevo: ");
            }
        }
    }

    private String solicitarTexto(String campo) {
        System.out.print(campo + ": ");
        String texto = scanner.nextLine();
        Validador.validarTexto(texto, campo);
        return texto;
    }

    private int solicitarNumero(String campo) {
        System.out.print(campo + ": ");
        int numero = leerEntero();
        Validador.validarNumeroPositivo(numero, campo);
        return numero;
    }
}
