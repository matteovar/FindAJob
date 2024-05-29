import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClienteTest {

    private Cliente cliente;
    private Aluguel aluguelMock;
    private ListaQuadras listaQuadrasMock;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente("João Silva", "123.456.789-00", "joao@example.com", "senha123");
        aluguelMock = Mockito.mock(Aluguel.class);
        listaQuadrasMock = Mockito.mock(ListaQuadras.class);
    }

    @Test
    public void testGetCpf() {
        assertEquals("123.456.789-00", cliente.getCpf());
    }

    @Test
    public void testSetCpf() {
        cliente.setCpf("987.654.321-00");
        assertEquals("987.654.321-00", cliente.getCpf());
    }

    @Test
    public void testGetAluguel() {
        cliente.setAluguel(aluguelMock);
        assertEquals(aluguelMock, cliente.getAluguel());
    }

    @Test
    public void testSetAluguel() {
        cliente.setAluguel(aluguelMock);
        assertEquals(aluguelMock, cliente.getAluguel());
    }

    @Test
    public void testGetObjetolista() {
        when(aluguelMock.getObjetolista()).thenReturn(listaQuadrasMock);
        cliente.setAluguel(aluguelMock);
        
        ListaQuadras result = cliente.getObjetolista();
        
        assertEquals(listaQuadrasMock, result);
        verify(aluguelMock).getObjetolista();
    }

    @Test
    public void testClienteConstructor() {
        Cliente novoCliente = new Cliente("Maria Souza", "111.222.333-44", "maria@example.com", "senha456");
        
        assertEquals("Maria Souza", novoCliente.getNome());
        assertEquals("111.222.333-44", novoCliente.getCpf());
        assertEquals("maria@example.com", novoCliente.getEmail());
        assertEquals("senha456", novoCliente.getSenha());
    }
}
