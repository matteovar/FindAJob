// Source code is decompiled from a .class file using FernFlower decompiler.
package JogaYJoga.Pacotao;

public class Main {
   public Main() {
   }

   public static void main(String[] args) {
      new Pessoa("Jonatas", "@hotmail", "123");
      Cliente cliente1 = new Cliente("Jonatas", "@hotmail", "123", "aa");
      Locador locador1 = new Locador("Matteo", "@bol", "321", "bb");
      System.out.println(cliente1.getNome());
      System.out.println(cliente1.getEmail());
      System.out.println(cliente1.getSenha());
      System.out.println(cliente1.getCpf());
      System.out.println(locador1.getCnpj());
   }
}
