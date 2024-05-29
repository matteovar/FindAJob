import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PessoaTest {

    private Pessoa pessoa;

    @BeforeEach
    public void setUp() {
        pessoa = new Pessoa("João Silva", "joao@example.com", "senha123");
    }

    @Test
    public void testGetNome() {
        assertEquals("João Silva", pessoa.getNome());
    }

    @Test
    public void testSetNome() {
        pessoa.setNome("Maria Souza");
        assertEquals("Maria Souza", pessoa.getNome());
    }

    @Test
    public void testGetEmail() {
        assertEquals("joao@example.com", pessoa.getEmail());
    }

    @Test
    public void testSetEmail() {
        pessoa.setEmail("maria@example.com");
        assertEquals("maria@example.com", pessoa.getEmail());
    }

    @Test
    public void testGetSenha() {
        assertEquals("senha123", pessoa.getSenha());
    }

    @Test
    public void testSetSenha() {
        pessoa.setSenha("novaSenha456");
        assertEquals("novaSenha456", pessoa.getSenha());
    }

    @Test
    public void testPessoaConstructor() {
        Pessoa novaPessoa = new Pessoa("Carlos Alberto", "carlos@example.com", "senha789");
        
        assertEquals("Carlos Alberto", novaPessoa.getNome());
        assertEquals("carlos@example.com", novaPessoa.getEmail());
        assertEquals("senha789", novaPessoa.getSenha());
    }
}
