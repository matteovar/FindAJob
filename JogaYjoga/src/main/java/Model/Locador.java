/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jonat
 */
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
