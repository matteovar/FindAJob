package JogaYJoga.Pacotao;
public class Cliente extends Pessoa {
   private String cpf;

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
