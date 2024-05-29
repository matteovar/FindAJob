import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MenuLocadorTest {

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
    public void testInicia_VoltarInicioOption() {
        String input = "1\n"; // Select Voltar ao início option
        provideInput(input);

        Locador locador = new Locador("Beach Sports", "beach@example.com", "password", "456");
        MenuLocador menuLocador = new MenuLocador(locador);

        assertDoesNotThrow(() -> menuLocador.inicia());
    }

    @Test
    public void testInicia_MeusLocaisOption() {
        String input = "2\n"; // Select Meus Locais option
        provideInput(input);

        Locador locador = new Locador("Beach Sports", "beach@example.com", "password", "456");
        MenuLocador menuLocador = new MenuLocador(locador);

        assertDoesNotThrow(() -> menuLocador.inicia());
    }

    @Test
    public void testInicia_VerificarAgendaOption() {
        String input = "3\n"; // Select Verificar agenda option
        provideInput(input);

        Locador locador = new Locador("Beach Sports", "beach@example.com", "password", "456");
        MenuLocador menuLocador = new MenuLocador(locador);

        assertDoesNotThrow(() -> menuLocador.inicia());
    }

    @Test
    public void testInicia_CadastrarNovoLocalOption() {
        String input = "4\n"; // Select Cadastrar novo Local option
        provideInput(input);

        Locador locador = new Locador("Beach Sports", "beach@example.com", "password", "456");
        MenuLocador menuLocador = new MenuLocador(locador);

        assertDoesNotThrow(() -> menuLocador.inicia());
    }
}
