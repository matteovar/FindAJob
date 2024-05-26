/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jonat
 */
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
    

