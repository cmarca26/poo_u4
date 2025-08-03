package view;

import controller.ContenidoController;
import model.*;
import utils.InputActor;
import utils.InputDocumental;
import utils.InputInvestigador;
import utils.InputPelicula;
import utils.InputSerieDeTV;
import utils.InputTemporada;
import utils.InputHelper;

import java.io.File;
import java.util.Scanner;

public class ContenidoView {

    /**
     * Ruta del archivo donde se guardarán los contenidos audiovisuales.
     */
    private static final String ARCHIVO_DATOS = "data/contenidos.csv";
    private final ContenidoController controller;
    private final Scanner scanner;

    public ContenidoView(ContenidoController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú de opciones para interactuar con los contenidos audiovisuales.
     * Permite al usuario agregar películas, series de TV, documentales y mostrar todos los contenidos.
     */
    private void mostrarMenu() {
        System.out.println("\n");
        System.out.println("--- Menú de Contenidos Audiovisuales ---");
        System.out.println("1. Agregar Película");
        System.out.println("2. Agregar Serie de TV");
        System.out.println("3. Agregar Documental");
        System.out.println("4. Mostrar todos los contenidos");
        System.out.println("0. Salir");
    }

    /**
     * Inicia la vista de contenidos audiovisuales.
     * Muestra el menú y permite al usuario interactuar con las opciones.
     */
    public void iniciar() {
        verificarDatosGuardados();
        int opcion;
        do {
            mostrarMenu();
            opcion = InputHelper.solicitarNumero(scanner, "Seleccione una opción: ");
            ejecutarOpcion(opcion);
        } while (opcion != 0);
    }

    /**
     * Ejecuta la opción seleccionada por el usuario.
     *
     * @param opcion La opción seleccionada.
     */
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

    /**
     * Agrega una nueva película al sistema.
     * Solicita los datos de la película y los actores, y los guarda en el controlador.
     */
    private void agregarPelicula() {
        System.out.println("--- Agregar Película ---");
        Pelicula pelicula = null;
        boolean exito = false;
        do {
            try {
                pelicula = InputPelicula.solicitarPelicula(scanner);
                agregarActoresAPelicula(pelicula);
                controller.agregarPelicula(pelicula);
                controller.guardarContenidos("data/contenidos.csv");
                System.out.println("Película agregada y guardada correctamente.\n");
                exito = true;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Por favor, ingrese los datos nuevamente.\n");
            }
        } while (!exito);
    }

    /**
     * Agrega actores a una película.
     * Permite al usuario agregar múltiples actores hasta que decida no agregar más.
     *
     * @param pelicula La película a la que se agregarán los actores.
     */
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

    /**
     * Agrega una nueva serie de TV al sistema.
     * Solicita los datos de la serie y las temporadas, y las guarda en el controlador.
     */
    private void agregarSerie() {
        System.out.println("--- Agregar Serie de TV ---");
        SerieDeTV serie = null;
        boolean exito = false;
        do {
            try {
                serie = InputSerieDeTV.solicitarSerieDeTV(scanner);
                agregarTemporadasASerie(serie);
                controller.agregarSerie(serie);
                controller.guardarContenidos("data/contenidos.csv");
                System.out.println("Serie agregada y guardada correctamente.\n");
                exito = true;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Por favor, ingrese los datos nuevamente.\n");
            }
        } while (!exito);
    }

    /**
     * Agrega temporadas a una serie de TV.
     * Permite al usuario agregar múltiples temporadas hasta que decida no agregar más.
     *
     * @param serie La serie de TV a la que se agregarán las temporadas.
     */
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

    /**
     * Agrega un nuevo documental al sistema.
     * Solicita los datos del documental y los investigadores, y los guarda en el controlador.
     */
    private void agregarDocumental() {
        System.out.println("--- Agregar Documental ---");
        Documental documental = null;
        boolean exito = false;
        do {
            try {
                documental = InputDocumental.solicitarDocumental(scanner);
                agregarInvestigadoresADocumental(documental);
                controller.agregarDocumental(documental);
                controller.guardarContenidos("data/contenidos.csv");
                System.out.println("Documental agregado y guardado correctamente.\n");
                exito = true;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Por favor, ingrese los datos nuevamente.\n");
            }
        } while (!exito);
    }

    /**
     * Agrega investigadores a un documental.
     * Permite al usuario agregar múltiples investigadores hasta que decida no agregar más.
     *
     * @param documental El documental al que se agregarán los investigadores.
     */
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

    /**
     * Muestra todos los contenidos audiovisuales registrados en el sistema.
     * Recorre la lista de contenidos y muestra los detalles de cada uno.
     */
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

    /**
     * Verifica si hay datos guardados en el archivo y pregunta al usuario si desea cargarlos.
     * Si el usuario acepta, carga los datos desde el archivo.
     */
    private void verificarDatosGuardados() {
        File archivo = new File(ARCHIVO_DATOS);
        if (archivo.exists() && archivo.length() > 0) {
            System.out.print("Se encontraron datos guardados. ¿Desea cargarlos? (s/n): ");
            String respuesta = scanner.nextLine().trim();
            if (respuesta.equalsIgnoreCase("s")) {
                try {
                    controller.cargarContenidos(ARCHIVO_DATOS);
                    System.out.println("Datos cargados correctamente.\n");
                    mostrarContenidos();
                } catch (Exception e) {
                    System.out.println("Error al cargar los datos: " + e.getMessage());
                }
            } else {
                System.out.println("Se iniciara con datos vacios.\n");
            }
        }
    }
}
