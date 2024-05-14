// Source code is decompiled from a .class file using FernFlower decompiler.
package JogaYJoga.Pacotao;

import java.util.ArrayList;
import java.util.List;

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

       List<String> diasDisponiveis = new ArrayList<>();
        diasDisponiveis.add("Segunda-feira");
        diasDisponiveis.add("Terça-feira");
        diasDisponiveis.add("Quarta-feira");
        diasDisponiveis.add("Quinta-feira");
        diasDisponiveis.add("Sexta-feira");
        diasDisponiveis.add("Sábado");
        diasDisponiveis.add("Domingo");

        List<String> horariosDisponiveis = new ArrayList<>();
        horariosDisponiveis.add("08:00");
        horariosDisponiveis.add("10:00");
        horariosDisponiveis.add("12:00");
        horariosDisponiveis.add("14:00");
        horariosDisponiveis.add("16:00");
        horariosDisponiveis.add("18:00");
        horariosDisponiveis.add("20:00");

        Quadra quadra = new Quadra(diasDisponiveis, horariosDisponiveis);

        // Exemplo de uso
        System.out.println("Quadras disponíveis: " + quadra.cadastarQuadras());
        quadra.selecionarQuadras("Quadra 1", "Segunda-feira", "10:00");
        System.out.println("Horários disponíveis para a Quadra 1 na Segunda-feira: " + quadra.horariosDisponiveis("Quadra 1", "Segunda-feira"));
        
        System.out.println("Quadras disponíveis: " + quadra.cadastarQuadras());
        quadra.selecionarQuadras("Quadra 1", "Segunda-feira", "10:00");
        System.out.println("Horários disponíveis para a Quadra 1 na Segunda-feira: " + quadra.horariosDisponiveis("Quadra 1", "Segunda-feira"));

      }
}
