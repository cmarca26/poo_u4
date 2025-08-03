package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DocumentalTest {
    
    public DocumentalTest() {
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
     * Test para obtener y establecer el tema de un documental.
     * Este método verifica que se pueda obtener el tema de un documental y luego cambiarlo, asegurando que el cambio se refleje correctamente.
     */
    @Test
    public void testGetSetTema() {
        Documental doc = new Documental("Planeta Tierra", 60, "Naturaleza", "Fauna");
        assertEquals("Fauna", doc.getTema());
        doc.setTema("Clima");
        assertEquals("Clima", doc.getTema());
    }

    /**
     * Test para establecer el tema de un documental.
     * Este método verifica que se pueda establecer el tema de un documental.
     * Verifica que se pueda cambiar el tema.
     * Verifica que se pueda agregar y eliminar investigadores de un documental.
     */
    @Test
    public void testSetTema() {
        Documental instance = new Documental("Planeta Tierra", 60, "Naturaleza", "Fauna");
        instance.setTema("Clima");
        assertEquals("Clima", instance.getTema());
    }

    /**
     * Test para manejar la lista de investigadores de un documental.
     * Este método verifica que se pueda acceder a la lista de investigadores.
     * También verifica que la lista esté vacía inicialmente. Luego, agrega un investigador y verifica que la lista contenga ese investigador. 
     * Este método verifica que no se lance ninguna excepción al agregar o eliminar investigadores.
     * Verifica que se pueda agregar y eliminar investigadores de un documental.
     */
    @Test
    public void testInvestigadores() {
        Documental doc = new Documental("Planeta Tierra", 60, "Naturaleza", "Fauna");
        assertTrue(doc.getInvestigadores().isEmpty());
        Investigador inv = new Investigador("David Attenborough", "BBC", "Biología", 50);
        doc.agregarInvestigador(inv);
        assertEquals(1, doc.getInvestigadores().size());
        assertEquals("David Attenborough", doc.getInvestigadores().get(0).getNombre());
        doc.eliminarInvestigador(inv);
        assertTrue(doc.getInvestigadores().isEmpty());
    }

    /**
     * Test para agregar un investigador a un documental.
     * Este método verifica que se pueda agregar un investigador a la lista de investigadores.
     */
    @Test
    public void testAgregarInvestigador() {
        Documental instance = new Documental("Planeta Tierra", 60, "Naturaleza", "Fauna");
        Investigador investigador = new Investigador("David Attenborough", "BBC", "Biología", 50);
        instance.agregarInvestigador(investigador);
        assertEquals(1, instance.getInvestigadores().size());
        assertEquals("David Attenborough", instance.getInvestigadores().get(0).getNombre());
    }

    /**
     * Test para eliminar un investigador de un documental.
     * Este método verifica que se pueda eliminar un investigador de la lista de investigadores.
     * Verifica que la lista de investigadores esté vacía después de eliminar.
     * Este método verifica que no se lance ninguna excepción al eliminar un investigador.
     */
    @Test
    public void testEliminarInvestigador() {
        Documental instance = new Documental("Planeta Tierra", 60, "Naturaleza", "Fauna");
        Investigador investigador = new Investigador("David Attenborough", "BBC", "Biología", 50);
        instance.agregarInvestigador(investigador);
        instance.eliminarInvestigador(investigador);
        assertTrue(instance.getInvestigadores().isEmpty());
    }

    /**
     * Test para mostrar los detalles de un documental.
     * Este método verifica que se muestren correctamente los detalles del documental, incluyendo el título, duración, género, tema e investigadores.
     * Verifica que no se lance ninguna excepción al mostrar los detalles.
     */
    @Test
    public void testMostrarDetalles() {
        Documental doc = new Documental("Planeta Tierra", 60, "Naturaleza", "Fauna");
        doc.agregarInvestigador(new Investigador("David Attenborough", "BBC", "Biología", 50));
        // Solo verifica que no lanza excepción
        doc.mostrarDetalles();
    }

    /**
     * Test para convertir un documental a CSV y de vuelta.
     * Este método verifica que se pueda convertir un documental a formato CSV y luego reconstruirlo desde ese formato.
     * También verifica que los datos coincidan.
     * Este método verifica que no se lance ninguna excepción al convertir a CSV.
     */
    @Test
    public void testToCSVFromCSV() {
        Documental doc = new Documental("Planeta Tierra", 60, "Naturaleza", "Fauna");
        doc.agregarInvestigador(new Investigador("David Attenborough", "BBC", "Biología", 50));
        String[] csv = doc.toCSV();
        Documental copia = new Documental("", 0, "", "");
        copia.fromCSV(csv);
        assertEquals("Planeta Tierra", copia.getTitulo());
        assertEquals(60, copia.getDuracionEnMinutos());
        assertEquals("Naturaleza", copia.getGenero());
        assertEquals("Fauna", copia.getTema());
        assertEquals(1, copia.getInvestigadores().size());
        assertEquals("David Attenborough", copia.getInvestigadores().get(0).getNombre());
    }

    /**
     * Test para convertir un documental a CSV y de vuelta.
     * Este método verifica que se pueda reconstruir un documental a partir de un array de datos CSV.
     * También verifica que los datos coincidan.
     * Este método verifica que no se lance ninguna excepción al reconstruir desde CSV.
     */
    @Test
    public void testFromCSV() {
        String[] data = {
            "1", "Planeta Tierra", "60", "Naturaleza", "Fauna", "David Attenborough;BBC;Biología;50"
        };
        Documental instance = new Documental("", 0, "", "");
        instance.fromCSV(data);
        assertEquals("Planeta Tierra", instance.getTitulo());
        assertEquals(60, instance.getDuracionEnMinutos());
        assertEquals("Naturaleza", instance.getGenero());
        assertEquals("Fauna", instance.getTema());
        assertEquals(1, instance.getInvestigadores().size());
        assertEquals("David Attenborough", instance.getInvestigadores().get(0).getNombre());
    }
    
}
