import factory.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {

    @Test
    void deveCriarBebidasQuentes() {
        BebidaFactory factory = new BebidaQuenteFactory();

        assertEquals("Cafe quente", factory.criarCafe().servir());
        assertEquals("Cha quente", factory.criarCha().servir());
    }

    @Test
    void deveCriarBebidasFrias() {
        BebidaFactory factory = new BebidaFriaFactory();

        assertEquals("Cafe gelado", factory.criarCafe().servir());
        assertEquals("Cha gelado", factory.criarCha().servir());
    }
}