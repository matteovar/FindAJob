import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class QuadraViewTest {

    private final InputStream systemIn = System.in;
    private ByteArrayInputStream testIn;

    @BeforeEach
    public void setUpInput() {
        System.setIn(systemIn);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
    }

    @Test
    public void testObterDiaEscolhido_ValidInput() {
        String input = "2\n"; // Choose second day
        provideInput(input);

        QuadraView quadraView = new QuadraView();
        ArrayList<LocalDate> diasDisponiveis = new ArrayList<>();
        diasDisponiveis.add(LocalDate.of(2024, 6, 10));
        diasDisponiveis.add(LocalDate.of(2024, 6, 11));
        LocalDate diaEscolhido = quadraView.obterDiaEscolhido(diasDisponiveis);

        assertEquals(LocalDate.of(2024, 6, 11), diaEscolhido);
    }

    @Test
    public void testObterDiaEscolhido_InvalidInput() {
        String input = "5\n"; // Choose an invalid option
        provideInput(input);

        QuadraView quadraView = new QuadraView();
        ArrayList<LocalDate> diasDisponiveis = new ArrayList<>();
        diasDisponiveis.add(LocalDate.of(2024, 6, 10));
        diasDisponiveis.add(LocalDate.of(2024, 6, 11));
        LocalDate diaEscolhido = quadraView.obterDiaEscolhido(diasDisponiveis);

        assertNull(diaEscolhido);
    }

    @Test
    public void testObterHorarioEscolhido_ValidInput() {
        String input = "2\n"; // Choose second time slot
        provideInput(input);

        QuadraView quadraView = new QuadraView();
        ArrayList<String> horarios = new ArrayList<>();
        horarios.add("08:00 - 09:00");
        horarios.add("09:00 - 10:00");
        String horarioEscolhido = quadraView.obterHorarioEscolhido(horarios);

        assertEquals("09:00 - 10:00", horarioEscolhido);
    }

    @Test
    public void testObterHorarioEscolhido_InvalidInput() {
        String input = "5\n"; // Choose an invalid option
        provideInput(input);

        QuadraView quadraView = new QuadraView();
        ArrayList<String> horarios = new ArrayList<>();
        horarios.add("08:00 - 09:00");
        horarios.add("09:00 - 10:00");
        String horarioEscolhido = quadraView.obterHorarioEscolhido(horarios);

        assertNull(horarioEscolhido);
    }
}
