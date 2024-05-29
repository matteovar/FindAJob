import Model.*;
import View.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OperacoesLocadorTest {

    @Mock
    private MenuLocador menuLocador;

    @Mock
    private Locador locador;

    @Mock
    private Quadra quadra;

    @Mock
    private Agendas agenda;

    @InjectMocks
    private OperacoesLocador operacoesLocador;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(menuLocador.getLocador()).thenReturn(locador);
        operacoesLocador = new OperacoesLocador(menuLocador);
    }

    @Test
    public void testNavegarVoltarAoMenuPrincipal() {
        boolean result = operacoesLocador.navegar(1, locador);
        assertTrue(result);
        verify(menuLocador).exibirMensagem("Voltando ao menu principal...");
    }

    @Test
    public void testNavegarExibirLocaisSemQuadras() {
        when(locador.getTotalQuadras()).thenReturn(0);
        boolean result = operacoesLocador.navegar(2, locador);
        assertFalse(result);
        verify(menuLocador).exibirMensagem("Não há locais cadastrados");
    }

    @Test
    public void testNavegarExibirLocaisComQuadras() {
        when(locador.getTotalQuadras()).thenReturn(1);
        boolean result = operacoesLocador.navegar(2, locador);
        assertFalse(result);
        verify(menuLocador).exibirMensagem("Exibindo locais:");
        verify(menuLocador).exibirLocais();
    }

    @Test
    public void testNavegarVerificarAgendaSemQuadras() {
        when(locador.getTotalQuadras()).thenReturn(0);
        boolean result = operacoesLocador.navegar(3, locador);
        assertFalse(result);
        verify(menuLocador).exibirMensagem("Você não possui nenhuma quadra cadastrada.");
    }

    @Test
    public void testNavegarVerificarAgendaComQuadras() {
        when(locador.getTotalQuadras()).thenReturn(1);
        when(locador.getQuadra(0)).thenReturn(quadra);
        when(quadra.getNome()).thenReturn("Quadra 1");
        when(quadra.getAgenda()).thenReturn(agenda);
        when(agenda.getHorariosReservados()).thenReturn(Arrays.asList("08:00 - 09:00"));
        when(agenda.getDiasHorario()).thenReturn(Arrays.asList("10:00 - 11:00", "11:00 - 12:00"));

        boolean result = operacoesLocador.navegar(3, locador);

        assertFalse(result);
        verify(menuLocador).exibirMensagem("Verificando Agenda:");
        verify(menuLocador).exibirMensagem(" Quadra Quadra 1");
        verify(menuLocador).exibirMensagem("Horarios agendados:");
        verify(menuLocador).exibirMensagem(Arrays.asList("08:00 - 09:00"));
        verify(menuLocador).exibirMensagem("Horarios livres:");
        verify(menuLocador).exibirMensagem(Arrays.asList("10:00 - 11:00", "11:00 - 12:00"));
        verify(agenda).reservaHorario(LocalDate.of(2024, 6, 13), "08:00 - 09:00");
    }

    @Test
    public void testNavegarAdicionarQuadra() {
        Agendas newAgenda = new Agendas();
        ArrayList<String> horarios = new ArrayList<>(Arrays.asList("08:00 - 09:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00"));
        newAgenda.AdicionarDias(LocalDate.of(2024, 6, 13), horarios);
        Quadra novaQuadra = new Quadra("-= Futset =-", "Quadra de Futebol localizada em guarulhos", newAgenda, "100");

        when(locador.getTotalQuadras()).thenReturn(0);

        boolean result = operacoesLocador.navegar(4, locador);

        assertFalse(result);
        verify(locador).adicionarQuadras(any(Quadra.class));
        verify(menuLocador).exibirMensagem(novaQuadra.getNome());
        verify(menuLocador).exibirMensagem(novaQuadra.getDescricao());
        verify(menuLocador).exibirMensagem("R$" + novaQuadra.getValor());
    }

    @Test
    public void testNavegarAdicionarQuadraJaExistente() {
        Agendas newAgenda = new Agendas();
        ArrayList<String> horarios = new ArrayList<>(Arrays.asList("08:00 - 09:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00"));
        newAgenda.AdicionarDias(LocalDate.of(2024, 6, 13), horarios);
        Quadra novaQuadra = new Quadra("-= Futset =-", "Quadra de Futebol localizada em guarulhos", newAgenda, "100");

        when(locador.getTotalQuadras()).thenReturn(1);
        when(locador.getQuadra(0)).thenReturn(novaQuadra);
        when(locador.getQuadra(0).getNome()).thenReturn("-= Futset =-");

        boolean result = operacoesLocador.navegar(4, locador);

        assertFalse(result);
        verify(menuLocador).exibirMensagem("XXX -= Futset =- == já está cadastrado\n");
    }

    @Test
    public void testNavegarOpcaoInvalida() {
        boolean result = operacoesLocador.navegar(99, locador);
        assertFalse(result);
        verify(menuLocador).exibirMensagem("Opção inválida");
    }
}
