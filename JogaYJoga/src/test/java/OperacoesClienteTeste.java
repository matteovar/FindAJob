import Model.*;
import View.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OperacoesClienteTest {

    @Mock
    private MenuCliente menuCliente;

    @Mock
    private ListaQuadras listaQuadras;

    @Mock
    private QuadraView quadraView;

    @Mock
    private Cliente cliente;

    @Mock
    private Quadra quadra;

    @Mock
    private Agendas agenda;

    @InjectMocks
    private OperacoesCliente operacoesCliente;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(menuCliente.getCliente()).thenReturn(cliente);
        operacoesCliente = new OperacoesCliente(menuCliente);
    }

    @Test
    public void testNavegarVoltarAoMenuPrincipal() {
        boolean result = operacoesCliente.navegar(1, cliente, listaQuadras);
        assertTrue(result);
        verify(menuCliente).exibirMensagem("Voltando ao menu principal...");
    }

    @Test
    public void testNavegarExibirLocaisSemQuadras() {
        when(listaQuadras.tamanho()).thenReturn(0);
        boolean result = operacoesCliente.navegar(2, cliente, listaQuadras);
        assertFalse(result);
        verify(menuCliente).exibirMensagem("Não há locais cadastrados");
    }

    @Test
    public void testNavegarExibirLocaisComQuadras() {
        when(listaQuadras.tamanho()).thenReturn(2);
        boolean result = operacoesCliente.navegar(2, cliente, listaQuadras);
        assertFalse(result);
        verify(menuCliente).exibirMensagem("Exibindo locais:");
        verify(menuCliente).exibirDetalhesQuadra(listaQuadras);
    }

    @Test
    public void testNavegarReservarQuadra() {
        when(listaQuadras.tamanho()).thenReturn(1);
        when(listaQuadras.getQuadra(0)).thenReturn(quadra);
        when(quadra.getAgenda()).thenReturn(agenda);
        when(quadra.getNome()).thenReturn("Quadra 1");
        when(agenda.getHorariosDisponiveis()).thenReturn(Arrays.asList("08:00 - 09:00", "10:00 - 11:00"));
        when(agenda.getHorariosReservados()).thenReturn(Arrays.asList("08:00 - 09:00", "10:00 - 11:00"));

        // Mock the Scanner to simulate user input
        try (MockedStatic<Scanner> mockedScanner = Mockito.mockStatic(Scanner.class)) {
            Scanner scanner = mock(Scanner.class);
            when(scanner.nextInt()).thenReturn(0);
            mockedScanner.when(Scanner::new).thenReturn(scanner);

            boolean result = operacoesCliente.navegar(3, cliente, listaQuadras);

            assertFalse(result);
            verify(menuCliente).exibirMensagem("Quadras Disponíveis: ");
            verify(quadraView).exibirNomeQuadras(listaQuadras);
            verify(menuCliente).exibirMensagem("Exibindo Agenda");
            verify(menuCliente).exibirMensagem(Arrays.asList("08:00 - 09:00", "10:00 - 11:00"));
            verify(agenda).reservaHorario(LocalDate.of(2024, 6, 13), "08:00 - 09:00");
            verify(agenda).reservaHorario(LocalDate.of(2024, 6, 13), "10:00 - 11:00");
            verify(menuCliente).exibirMensagem("Quadra 1Alugada em ");
            verify(menuCliente).exibirMensagem(Arrays.asList("08:00 - 09:00", "10:00 - 11:00"));
        }
    }
}
