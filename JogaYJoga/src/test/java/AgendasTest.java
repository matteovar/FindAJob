import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AgendasTest {

    private Agendas agendas;
    private LocalDate testDate;

    @BeforeEach
    public void setUp() {
        agendas = new Agendas();
        testDate = LocalDate.of(2024, 6, 13);
    }

    @Test
    public void testAdicionarDias() {
        ArrayList<String> horarios = new ArrayList<>();
        horarios.add("08:00 - 09:00");
        horarios.add("10:00 - 11:00");

        agendas.AdicionarDias(testDate, horarios);
        Map<LocalDate, ArrayList<String>> diasHorarios = Agendas.getDiasHorarios();

        assertTrue(diasHorarios.containsKey(testDate));
        assertEquals(2, diasHorarios.get(testDate).size());
        assertEquals("08:00 - 09:00", diasHorarios.get(testDate).get(0));
    }

    @Test
    public void testGetHorariosDisponiveisWithExistingDate() {
        ArrayList<String> horarios = new ArrayList<>();
        horarios.add("08:00 - 09:00");
        horarios.add("10:00 - 11:00");

        agendas.AdicionarDias(testDate, horarios);
        ArrayList<String> horariosDisponiveis = agendas.getHorariosDisponiveis(testDate);

        assertEquals(2, horariosDisponiveis.size());
        assertEquals("08:00 - 09:00", horariosDisponiveis.get(0));
    }

    @Test
    public void testGetHorariosDisponiveisWithNonExistingDate() {
        ArrayList<String> horariosDisponiveis = agendas.getHorariosDisponiveis(LocalDate.of(2024, 6, 14));

        assertTrue(horariosDisponiveis.isEmpty());
    }

    @Test
    public void testGetHorariosReservadosWhenEmpty() {
        String horariosReservados = agendas.getHorariosReservados();
        assertEquals("-> Não há horários reservados", horariosReservados);
    }

    @Test
    public void testGetHorariosReservadosWhenNotEmpty() {
        ArrayList<String> horarios = new ArrayList<>();
        horarios.add("08:00 - 09:00");
        horarios.add("10:00 - 11:00");

        agendas.AdicionarDias(testDate, horarios);
        agendas.reservaHorario(testDate, "08:00 - 09:00");

        String horariosReservados = agendas.getHorariosReservados();
        assertEquals("08:00 - 09:00", horariosReservados);
    }

    @Test
    public void testReservaHorarioSuccess() {
        ArrayList<String> horarios = new ArrayList<>();
        horarios.add("08:00 - 09:00");
        horarios.add("10:00 - 11:00");

        agendas.AdicionarDias(testDate, horarios);
        boolean result = agendas.reservaHorario(testDate, "08:00 - 09:00");

        assertTrue(result);
        assertFalse(agendas.getHorariosDisponiveis(testDate).contains("08:00 - 09:00"));
        assertTrue(agendas.getHorariosReservados().contains("08:00 - 09:00"));
    }

    @Test
    public void testReservaHorarioFailure() {
        ArrayList<String> horarios = new ArrayList<>();
        horarios.add("08:00 - 09:00");
        horarios.add("10:00 - 11:00");

        agendas.AdicionarDias(testDate, horarios);
        boolean result = agendas.reservaHorario(testDate, "09:00 - 10:00");

        assertFalse(result);
        assertFalse(agendas.getHorariosReservados().contains("09:00 - 10:00"));
    }
}
