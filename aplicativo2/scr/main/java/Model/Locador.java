package Model;

public class Locador extends Pessoa {
    private String cnpj;

    public Locador(String nome, String email, String senha, String cnpj) {
        super(nome, email, senha);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}