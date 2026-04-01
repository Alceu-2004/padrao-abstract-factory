import factory.*;
import model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    void deveRetornarTiposCorretosParaFactoryQuente() {
        BebidaFactory factory = new BebidaQuenteFactory();

        assertTrue(factory.criarCafe() instanceof CafeQuente);
        assertTrue(factory.criarCha() instanceof ChaQuente);
    }

    @Test
    void deveRetornarTiposCorretosParaFactoryFria() {
        BebidaFactory factory = new BebidaFriaFactory();

        assertTrue(factory.criarCafe() instanceof CafeGelado);
        assertTrue(factory.criarCha() instanceof ChaGelado);
    }

    @Test
    void naoDeveRetornarObjetosNulos() {
        BebidaFactory quente = new BebidaQuenteFactory();
        BebidaFactory fria = new BebidaFriaFactory();

        assertNotNull(quente.criarCafe());
        assertNotNull(quente.criarCha());
        assertNotNull(fria.criarCafe());
        assertNotNull(fria.criarCha());
    }

    @Test
    void bebidasDaMesmaFactoryDevemSerDaMesmaFamilia() {
        BebidaFactory factory = new BebidaQuenteFactory();

        String cafe = factory.criarCafe().servir();
        String cha = factory.criarCha().servir();

        assertTrue(cafe.contains("quente"));
        assertTrue(cha.contains("quente"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"quente", "gelado"})
    void deveConterTipoCorretoNaDescricao(String tipo) {

        BebidaFactory factory = tipo.equals("quente")
                ? new BebidaQuenteFactory()
                : new BebidaFriaFactory();

        String cafe = factory.criarCafe().servir();

        assertTrue(cafe.toLowerCase().contains(tipo));
    }
}