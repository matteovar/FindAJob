import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class QuadraTest {

    private Quadra quadra;
    private Agendas agenda;

    @BeforeEach
    public void setUp() {
        agenda = new Agendas();
        quadra = new Quadra("Quadra 1", "Descrição da Quadra 1", agenda, "100");
    }

    @Test
    public void testGetNome() {
        assertEquals("Quadra 1", quadra.getNome());
    }

    @Test
    public void testSetNome() {
        quadra.setNome("Quadra 2");
        assertEquals("Quadra 2", quadra.getNome());
    }

    @Test
    public void testGetDescricao() {
        assertEquals("Descrição da Quadra 1", quadra.getDescricao());
    }

    @Test
    public void testSetDescricao() {
        quadra.setDescricao("Nova descrição da Quadra 2");
        assertEquals("Nova descrição da Quadra 2", quadra.getDescricao());
    }

    @Test
    public void testGetAgenda() {
        assertEquals(agenda, quadra.getAgenda());
    }

    @Test
    public void testSetDiasHorarios() {
        Agendas novaAgenda = new Agendas();
        quadra.setDiasHorarios(novaAgenda);
        assertEquals(novaAgenda, quadra.getAgenda());
    }

    @Test
    public void testGetValor() {
        assertEquals("100", quadra.getValor());
    }

    @Test
    public void testSetValor() {
        quadra.setValor("200");
        assertEquals("200", quadra.getValor());
    }

    @Test
    public void testReservarHorario() {
        LocalDate data = LocalDate.of(2024, 6, 13);
        String horario = "08:00 - 09:00";

        ArrayList<String> horarios = new ArrayList<>();
        horarios.add(horario);
        agenda.AdicionarDias(data, horarios);

        assertTrue(quadra.getAgenda().getHorariosDisponiveis(data).contains(horario));

        quadra.reservarHorario(data, horario);

        assertFalse(quadra.getAgenda().getHorariosDisponiveis(data).contains(horario));
        assertTrue(quadra.getAgenda().getHorariosReservados().contains(horario));
    }
}
