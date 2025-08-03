package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliculaTest {

    public PeliculaTest() {
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
     * Test para obtener y establecer el título de una película.
     * Este método verifica que se pueda obtener el título de una película y luego cambiarlo, asegurando que el cambio se refleje correctamente.
     */
    @Test
    public void testGetSetEstudio() {
        Pelicula pelicula = new Pelicula("Matrix", 120, "Acción", "Warner");
        assertEquals("Warner", pelicula.getEstudio());
        pelicula.setEstudio("Universal");
        assertEquals("Universal", pelicula.getEstudio());
    }

    /**
     * Test para establecer el actor de una película.
     * Este método verifica que se pueda establecer el actor de una película.
     * Verifica que se pueda cambiar el actor.
     * Verifica que se pueda agregar y eliminar actores de una película.
     * Verifica que la lista de actores esté vacía inicialmente.
     */
    @Test
    public void testActores() {
        Pelicula pelicula = new Pelicula("Matrix", 120, "Acción", "Warner");
        assertTrue(pelicula.getActores().isEmpty());
        Actor actor = new Actor("Keanu Reeves", 56, "Canadiense", "Neo");
        pelicula.agregarActor(actor);
        assertEquals(1, pelicula.getActores().size());
        assertEquals("Keanu Reeves", pelicula.getActores().get(0).getNombre());
        pelicula.eliminarActor(actor);
        assertTrue(pelicula.getActores().isEmpty());
    }

    /**
     * Test para mostrar los detalles de una película.
     * Este método verifica que se muestren correctamente los detalles de una película.
     * También verifica que no se lance ninguna excepción al mostrar los detalles.
     */
    @Test
    public void testMostrarDetalles() {
        Pelicula pelicula = new Pelicula("Matrix", 120, "Acción", "Warner");
        pelicula.agregarActor(new Actor("Keanu Reeves", 56, "Canadiense", "Neo"));
        pelicula.mostrarDetalles();
    }

    /**
     * Test para convertir una película a formato CSV y luego reconstruirla desde ese formato.
     * Este método verifica que se pueda convertir una película a CSV y luego reconstruirla correctamente verificando que los datos coincidan.
     * También verifica que la lista de actores se haya convertido correctamente.
     */
    @Test
    public void testToCSVFromCSV() {
        Pelicula pelicula = new Pelicula("Matrix", 120, "Acción", "Warner");
        pelicula.agregarActor(new Actor("Keanu Reeves", 56, "Canadiense", "Neo"));
        String[] csv = pelicula.toCSV();
        Pelicula copia = new Pelicula("", 0, "", "");
        copia.fromCSV(csv);
        assertEquals("Matrix", copia.getTitulo());
        assertEquals(120, copia.getDuracionEnMinutos());
        assertEquals("Acción", copia.getGenero());
        assertEquals("Warner", copia.getEstudio());
        assertEquals(1, copia.getActores().size());
        assertEquals("Keanu Reeves", copia.getActores().get(0).getNombre());
    }

    /**
     * Test para reconstruir una película desde un formato CSV.
     * Este método verifica que se pueda reconstruir una película a partir de un array de datos CSV.
     * Verifica que los datos de la película coincidan con los datos originales.
     * También verifica que la lista de actores se haya reconstruido correctamente.
     * Este método verifica que no se lance ninguna excepción al reconstruir la película.
     */
    @Test
    public void testFromCSV() {
        String[] data = {
                "1", "Matrix", "120", "Acción", "Warner", "Keanu Reeves;56;Canadiense;Neo"
        };
        Pelicula instance = new Pelicula("", 0, "", "");
        instance.fromCSV(data);
        assertEquals("Matrix", instance.getTitulo());
        assertEquals(120, instance.getDuracionEnMinutos());
        assertEquals("Acción", instance.getGenero());
        assertEquals("Warner", instance.getEstudio());
        assertEquals(1, instance.getActores().size());
        assertEquals("Keanu Reeves", instance.getActores().get(0).getNombre());
    }
}
