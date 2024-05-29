import Model.Aluguel;
import Model.ListaQuadras;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AluguelTest {

    private ListaQuadras listaQuadrasMock;
    private Aluguel aluguel;

    @BeforeEach
    public void setUp() {
        listaQuadrasMock = Mockito.mock(ListaQuadras.class);
        aluguel = new Aluguel(listaQuadrasMock);
    }

    @Test
    public void testGetTotalQuadras() {
        when(listaQuadrasMock.tamanho()).thenReturn(5);
        int totalQuadras = aluguel.getTotalQuadras();
        assertEquals(5, totalQuadras);
        verify(listaQuadrasMock).tamanho();
    }

    @Test
    public void testGetObjetolista() {
        ListaQuadras result = aluguel.getObjetolista();
        assertEquals(listaQuadrasMock, result);
    }

    @Test
    public void testConstructor() {
        Aluguel novoAluguel = new Aluguel(listaQuadrasMock);
        assertNotNull(novoAluguel);
        assertEquals(listaQuadrasMock, novoAluguel.getObjetolista());
    }
}
