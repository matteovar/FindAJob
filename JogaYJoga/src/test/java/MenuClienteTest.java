import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MenuClienteTest {

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
        String input = "1\n3\n"; // Select Voltar ao início option, then exit
        provideInput(input);

        Cliente cliente = new Cliente("John", "123", "john@example.com", "password");
        Locador locador = new Locador("Beach Sports", "beach@example.com", "password", "456");
        MenuCliente menuCliente = new MenuCliente(cliente, locador);

        assertDoesNotThrow(() -> menuCliente.inicia());
    }

    @Test
    public void testInicia_VerLocaisOption() {
        String input = "2\n3\n"; // Select Ver meus locais option, then exit
        provideInput(input);

        Cliente cliente = new Cliente("John", "123", "john@example.com", "password");
        Locador locador = new Locador("Beach Sports", "beach@example.com", "password", "456");
        MenuCliente menuCliente = new MenuCliente(cliente, locador);

        assertDoesNotThrow(() -> menuCliente.inicia());
    }

    @Test
    public void testInicia_AlugarQuadrasOption() {
        String input = "3\n3\n"; // Select Alugar Quadras option, then exit
        provideInput(input);

        Cliente cliente = new Cliente("John", "123", "john@example.com", "password");
        Locador locador = new Locador("Beach Sports", "beach@example.com", "password", "456");
        MenuCliente menuCliente = new MenuCliente(cliente, locador);

        assertDoesNotThrow(() -> menuCliente.inicia());
    }

    @Test
    public void testInicia_InvalidOption() {
        String input = "5\n3\n"; // Enter invalid option, then exit
        provideInput(input);

        Cliente cliente = new Cliente("John", "123", "john@example.com", "password");
        Locador locador = new Locador("Beach Sports", "beach@example.com", "password", "456");
        MenuCliente menuCliente = new MenuCliente(cliente, locador);

        assertDoesNotThrow(() -> menuCliente.inicia());
    }

    @Test
    public void testInicia_ExitOption() {
        String input = "3\n"; // Select Exit option
        provideInput(input);

        Cliente cliente = new Cliente("John", "123", "john@example.com", "password");
        Locador locador = new Locador("Beach Sports", "beach@example.com", "password", "456");
        MenuCliente menuCliente = new MenuCliente(cliente, locador);

        assertDoesNotThrow(() -> menuCliente.inicia());
    }
}
