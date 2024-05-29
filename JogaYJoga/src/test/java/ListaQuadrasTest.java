import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaQuadrasTest {

    private ListaQuadras listaQuadras;
    private Quadra quadra;

    @BeforeEach
    public void setUp() {
        listaQuadras = new ListaQuadras();
        quadra = new Quadra("Quadra 1", "Descrição da Quadra 1", new Agendas(), "100");
    }

    @Test
    public void testTamanhoInicial() {
        assertEquals(0, listaQuadras.tamanho());
    }

    @Test
    public void testAdicionarQuadras() {
        listaQuadras.adicionarQuadras(quadra);
        assertEquals(1, listaQuadras.tamanho());
    }

    @Test
    public void testConstrutorComQuadra() {
        ListaQuadras listaComQuadra = new ListaQuadras(quadra);
        assertEquals(1, listaComQuadra.tamanho());
        assertEquals(quadra, listaComQuadra.getQuadra(0));
    }

    @Test
    public void testExibirNomeQuadras() {
        listaQuadras.adicionarQuadras(quadra);
        assertEquals("Quadra 1", listaQuadras.exibirNomeQuadras());
    }

    @Test
    public void testGetQuadraPosicaoValida() {
        listaQuadras.adicionarQuadras(quadra);
        assertEquals(quadra, listaQuadras.getQuadra(0));
    }

    @Test
    public void testGetQuadraPosicaoInvalida() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            listaQuadras.getQuadra(1);
        });
        assertEquals("Posição inválida.", exception.getMessage());
    }
}
