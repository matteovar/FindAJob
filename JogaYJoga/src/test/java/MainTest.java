import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MainTest {

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
    public void testMenu_ClienteOption() {
        String input = "1\n3\n"; // Select Client option, then exit
        provideInput(input);

        assertDoesNotThrow(() -> Main.menu(new Cliente(), new Locador()));
    }

    @Test
    public void testMenu_LocadorOption() {
        String input = "2\n3\n"; // Select Locador option, then exit
        provideInput(input);

        assertDoesNotThrow(() -> Main.menu(new Cliente(), new Locador()));
    }

    @Test
    public void testMenu_InvalidOption() {
        String input = "5\n3\n"; // Enter invalid option, then exit
        provideInput(input);

        assertDoesNotThrow(() -> Main.menu(new Cliente(), new Locador()));
    }

    @Test
    public void testMenu_ExitOption() {
        String input = "3\n"; // Select Exit option
        provideInput(input);

        assertDoesNotThrow(() -> Main.menu(new Cliente(), new Locador()));
    }
}
