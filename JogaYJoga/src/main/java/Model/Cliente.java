package Model;

public class Cliente extends Pessoa {
    private String cpf;
    private Aluguel aluguel;
    //private Aluguel aluguel;
    //precisa arrumar essa parte

    public Cliente(String nome, String cpf, String email, String senha) {
        super(nome, email, senha);
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



}