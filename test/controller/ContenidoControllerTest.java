package controller;

import java.io.File;
import java.util.List;
import model.ContenidoAudiovisual;
import model.Documental;
import model.Pelicula;
import model.SerieDeTV;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContenidoControllerTest {
    
    public ContenidoControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test para agregar una película.
     * Este método verifica que se pueda agregar una película al controlador de contenidos.
     * Verifica que se pueda agregar una película y que se refleje en la lista de contenidos.
     */
    @Test
    public void testAgregarPelicula() {
        Pelicula pelicula = new Pelicula("Matrix", 120, "Accion", "Warner Bros");
        ContenidoController instance = new ContenidoController();
        instance.agregarPelicula(pelicula);
        List<ContenidoAudiovisual> contenidos = instance.getContenidos();
        assertTrue(contenidos.contains(pelicula));
    }

    /**
     * Test para agregar una serie.
     * Este método verifica que se pueda agregar una serie al controlador de contenidos.
     * Verifica que se pueda agregar una serie y que se refleje en la lista de contenidos.
     */
    @Test
    public void testAgregarSerie() {
        SerieDeTV serie = new SerieDeTV("Breaking Bad", 2008, "Drama", 5);
        ContenidoController instance = new ContenidoController();
        instance.agregarSerie(serie);
        List<ContenidoAudiovisual> contenidos = instance.getContenidos();
        assertTrue(contenidos.contains(serie));
    }

    /**
     * Test para agregar un documental.
     * Este método verifica que se pueda agregar un documental al controlador de contenidos.
     * Verifica que se pueda agregar un documental y que se refleje en la lista de contenidos.
     */
    @Test
    public void testAgregarDocumental() {
        Documental documental = new Documental("Planeta Tierra", 2006, "Naturaleza", "BBC");
        ContenidoController instance = new ContenidoController();
        instance.agregarDocumental(documental);
        List<ContenidoAudiovisual> contenidos = instance.getContenidos();
        assertTrue(contenidos.contains(documental));
    }

    /**
     * Test para obtener la lista de contenidos.
     * Este método verifica que se pueda acceder a la lista de contenidos agregados.
     * Verifica que se pueda agregar una película, una serie y un documental.
     */
    @Test
    public void testGetContenidos() {
        ContenidoController instance = new ContenidoController();
        Pelicula pelicula = new Pelicula("Matrix", 120, "Accion", "Warner Bros");
        SerieDeTV serie = new SerieDeTV("Breaking Bad", 2008, "Drama", 5);
        Documental documental = new Documental("Planeta Tierra", 2006, "Naturaleza", "BBC");
        instance.agregarPelicula(pelicula);
        instance.agregarSerie(serie);
        instance.agregarDocumental(documental);
        List<ContenidoAudiovisual> result = instance.getContenidos();
        assertEquals(3, result.size());
        assertTrue(result.contains(pelicula));
        assertTrue(result.contains(serie));
        assertTrue(result.contains(documental));
    }

    /**
     * Test para guardar los contenidos en un archivo CSV.
     * Este método verifica que se guarden correctamente los contenidos en un archivo CSV.
     * Verifica que se pueda guardar una película, una serie y un documental.
     * Verifica que el archivo se crea y no está vacío.
     * Elimina el archivo después de la prueba.
     * @throws Exception si ocurre un error al guardar el archivo.
     */
    @Test
    public void testGuardarContenidos() throws Exception {
        String rutaArchivo = "data/test_contenidos.csv";
        ContenidoController instance = new ContenidoController();
        Pelicula pelicula = new Pelicula("Matrix", 120, "Accion", "Warner Bros");
        instance.agregarPelicula(pelicula);
        instance.guardarContenidos(rutaArchivo);
        File file = new File(rutaArchivo);
        assertTrue(file.exists() && file.length() > 0);
        file.delete();
    }

    /**
     * Test para cargar los contenidos desde un archivo CSV.
     * Este método verifica que se carguen correctamente los contenidos desde el archivo CSV.
     * Verifica que se pueda cargar una película, una serie y un documental.
     * Elimina el archivo después de la prueba.
     * @throws Exception si ocurre un error al cargar el archivo.
     */
    @Test
    public void testCargarContenidos() throws Exception {
        String rutaArchivo = "data/test_contenidos.csv";
        ContenidoController instance = new ContenidoController();
        Pelicula pelicula = new Pelicula("Matrix", 120, "Accion", "Warner Bros");
        instance.agregarPelicula(pelicula);
        instance.guardarContenidos(rutaArchivo);
        ContenidoController nuevoInstance = new ContenidoController();
        nuevoInstance.cargarContenidos(rutaArchivo);
        List<ContenidoAudiovisual> contenidos = nuevoInstance.getContenidos();
        assertEquals(1, contenidos.size());
        assertEquals("Matrix", contenidos.get(0).getTitulo());
        File file = new File(rutaArchivo);
        file.delete();
    }
    
}
