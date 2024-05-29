import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LocadorTest {

    private Locador locador;
    private Quadra quadra;

    @BeforeEach
    public void setUp() {
        locador = new Locador("Carlos Alberto", "carlos@example.com", "senha123", "12.345.678/0001-99");
        quadra = new Quadra("Quadra 1", "Descrição da Quadra 1", new Agendas(), "100");
    }

    @Test
    public void testGetCnpj() {
        assertEquals("12.345.678/0001-99", locador.getCnpj());
    }

    @Test
    public void testSetCnpj() {
        locador.setCnpj("98.765.432/0001-00");
        assertEquals("98.765.432/0001-00", locador.getCnpj());
    }

    @Test
    public void testGetObjetolista() {
        ListaQuadras lista = locador.getObjetolista();
        assertNotNull(lista);
        assertEquals(0, lista.tamanho());
    }

    @Test
    public void testGetListaQuadras() {
        locador.adicionarQuadras(quadra);
        assertEquals("Quadra 1", locador.getListaQuadras());
    }

    @Test
    public void testGetTotalQuadras() {
        assertEquals(0, locador.getTotalQuadras());
        locador.adicionarQuadras(quadra);
        assertEquals(1, locador.getTotalQuadras());
    }

    @Test
    public void testGetQuadraPosicaoValida() {
        locador.adicionarQuadras(quadra);
        assertEquals(quadra, locador.getQuadra(0));
    }

    @Test
    public void testGetQuadraPosicaoInvalida() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            locador.getQuadra(1);
        });
        assertEquals("Posição inválida.", exception.getMessage());
    }

    @Test
    public void testAdicionarQuadras() {
        locador.adicionarQuadras(quadra);
        assertEquals(1, locador.getTotalQuadras());
        assertEquals(quadra, locador.getQuadra(0));
    }
}
