import Controller.SzovegStatisztika;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FeladatokTest {

    private SzovegStatisztika stat;
    private List<String> tesztAdatok;

    @BeforeEach
    void setUp() {
        tesztAdatok = new ArrayList<>(Arrays.asList(
                "Az alma nagyon finom.",
                "Tekerek a biciklin.",
                "A labda pattog."
        ));
        stat = new SzovegStatisztika(tesztAdatok);
    }

    @Test
    void testSzoSzamlalas() {
        assertEquals(10, stat.szoSzamlalas());
    }

    @Test
    void testLeghosszabbSzo() {
        assertEquals("biciklin", stat.LeghosszabbSzo());
    }

    @Test
    void testHanybanvanAbetu() {
        assertEquals(9, stat.HanybanvanAbetu());
    }

    @Test
    void testElsoUtolsoCsere() {
        assertEquals("almA", stat.elsoUtolsoCsere("Alma"));
    }

    @Test
    void testVanEDuplikacio() {
        assertTrue(stat.VanEDuplikacio());
    }

    @Test
    void testKarakterSzamlalas() {
        assertEquals(55, stat.karakterSzamlalas());
    }
}