package Model;

public class Cliente extends Pessoa {
    private String cpf;
    private Aluguel aluguel;

    public Cliente(String nome, String cpf, String email, String senha, ListaQuadras listaQuadras) {
        super(nome, email, senha);
        this.cpf = cpf;
        this.aluguel = new Aluguel(listaQuadras);
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Aluguel getAluguel() {
        return this.aluguel;
    }

    public int getTotalQuadras() {
        return this.aluguel.getTotalQuadras();
    }

    public ListaQuadras getObjetolista() {
        return this.aluguel.getObjetolista();
    }
}
