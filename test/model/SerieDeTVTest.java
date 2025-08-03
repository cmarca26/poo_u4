
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SerieDeTVTest {
    
    public SerieDeTVTest() {
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
     * Test para obtener y establecer el título de una serie.
     * Este método verifica que se pueda obtener el título de una serie y luego cambiarlo, asegurando que el cambio se refleje correctamente.
     */
    @Test
    public void testGetSetTemporadas() {
        SerieDeTV serie = new SerieDeTV("Friends", 30, "Comedia", 0);
        assertEquals(0, serie.getTemporadas());
        serie.setTemporadas(5);
        assertEquals(5, serie.getTemporadas());
    }

    /**
     * Test para establecer el número de temporadas de una serie.
     * Este método verifica que se pueda establecer el número de temporadas de una serie.
     * Verifica que se pueda cambiar el número de temporadas.
     */
    @Test
    public void testSetTemporadas() {
        SerieDeTV instance = new SerieDeTV("Friends", 30, "Comedia", 0);
        instance.setTemporadas(3);
        assertEquals(3, instance.getTemporadas());
    }

    /**
     * Test para obtener la lista de temporadas de una serie.
     * Este método verifica que se pueda acceder a la lista de temporadas.
     * También verifica que la lista esté vacía inicialmente.
     * Luego, agrega una temporada y verifica que la lista contenga esa temporada.
     * Finalmente, elimina la temporada y verifica que la lista esté vacía nuevamente.
     */
    @Test
    public void testListaTemporadas() {
        SerieDeTV serie = new SerieDeTV("Friends", 30, "Comedia", 0);
        assertTrue(serie.getListaTemporadas().isEmpty());
        Temporada temp = new Temporada(1, 24, 1994, "Primera temporada");
        serie.agregarTemporada(temp);
        assertEquals(1, serie.getListaTemporadas().size());
        assertEquals(1, serie.getListaTemporadas().get(0).getNumero());
        serie.eliminarTemporada(temp);
        assertTrue(serie.getListaTemporadas().isEmpty());
    }

    /**
     * Test para agregar una temporada a una serie.
     * Este método verifica que se pueda agregar una temporada a la lista de temporadas.
     * Verifica que la lista de temporadas tenga el tamaño correcto después de agregar.
     * También verifica que el número de la temporada agregada sea correcto.
     */
    @Test
    public void testAgregarTemporada() {
        SerieDeTV instance = new SerieDeTV("Friends", 30, "Comedia", 0);
        Temporada temporada = new Temporada(1, 24, 1994, "Primera temporada");
        instance.agregarTemporada(temporada);
        assertEquals(1, instance.getListaTemporadas().size());
        assertEquals(1, instance.getListaTemporadas().get(0).getNumero());
    }

    /**
     * Test para eliminar una temporada de una serie.
     * Este método verifica que se pueda eliminar una temporada de la lista de temporadas.
     * Verifica que la lista de temporadas tenga el tamaño correcto después de eliminar.
     * También verifica que la lista esté vacía después de eliminar la única temporada.
     */
    @Test
    public void testEliminarTemporada() {
        SerieDeTV instance = new SerieDeTV("Friends", 30, "Comedia", 0);
        Temporada temporada = new Temporada(1, 24, 1994, "Primera temporada");
        instance.agregarTemporada(temporada);
        instance.eliminarTemporada(temporada);
        assertTrue(instance.getListaTemporadas().isEmpty());
    }

    /**
     * Test para mostrar los detalles de una serie.
     * Este método verifica que se pueda mostrar la información de la serie, incluyendo el título, duración, género y la lista de temporadas.
     * Verifica que no se lance ninguna excepción al mostrar los detalles.
     */
    @Test
    public void testMostrarDetalles() {
        SerieDeTV serie = new SerieDeTV("Friends", 30, "Comedia", 0);
        serie.agregarTemporada(new Temporada(1, 24, 1994, "Primera temporada"));
        serie.mostrarDetalles();
    }

    /**
     * Test para convertir una serie a formato CSV y luego reconstruirla desde ese formato.
     * Este método verifica que se pueda convertir una serie a CSV y luego reconstruirla correctamente verificando que los datos coincidan.
     * También verifica que la lista de temporadas se haya convertido correctamente.
     */
    @Test
    public void testToCSVFromCSV() {
        SerieDeTV serie = new SerieDeTV("Friends", 30, "Comedia", 0);
        serie.agregarTemporada(new Temporada(1, 24, 1994, "Primera temporada"));
        String[] csv = serie.toCSV();
        SerieDeTV copia = new SerieDeTV("", 0, "", 0);
        copia.fromCSV(csv);
        assertEquals("Friends", copia.getTitulo());
        assertEquals(30, copia.getDuracionEnMinutos());
        assertEquals("Comedia", copia.getGenero());
        assertEquals(1, copia.getListaTemporadas().size());
        assertEquals(1, copia.getListaTemporadas().get(0).getNumero());
        assertEquals("Primera temporada", copia.getListaTemporadas().get(0).getSinopsis());
    }

    /**
     * Test para reconstruir una serie desde un formato CSV.
     * Este método verifica que se pueda reconstruir una serie a partir de un array de datos CSV.
     * Verifica que los datos de la serie coincidan con los datos originales.
     * También verifica que la lista de temporadas se haya reconstruido correctamente.
     * Este método verifica que no se lance ninguna excepción al reconstruir la serie.
     */
    @Test
    public void testFromCSV() {
        String[] data = {
            "1", "Friends", "30", "Comedia", "1", "1;24;1994;Primera temporada"
        };
        SerieDeTV instance = new SerieDeTV("", 0, "", 0);
        instance.fromCSV(data);
        assertEquals("Friends", instance.getTitulo());
        assertEquals(30, instance.getDuracionEnMinutos());
        assertEquals("Comedia", instance.getGenero());
        assertEquals(1, instance.getListaTemporadas().size());
        assertEquals(1, instance.getListaTemporadas().get(0).getNumero());
        assertEquals("Primera temporada", instance.getListaTemporadas().get(0).getSinopsis());
    }
    
}
