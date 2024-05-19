// Source code is decompiled from a .class file using FernFlower decompiler.
package JogaYJoga.Pacotao;

import java.util.Scanner;


public class Main {
public static void clear(){
      try{
          new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
      }catch ( Exception e){
          System.out.println(e);
      }
  }
    
   public static void operacoesCliente(Cliente cliente,ListaQuadras lista_quadras){
       Scanner teclado = new Scanner(System.in);
       int resposta;
       
       System.out.println("Bem vindo de volta");
       System.out.println(cliente.getNome().toUpperCase());
       System.out.println("\nSelecione uma opção: ");
       System.out.println("[1] Voltar ao inicio \n[2] Alugar uma quadra");
       
       resposta = teclado.nextInt();
       while(resposta != 1 && resposta != 2){
            System.out.print("Digite uma opção válida");
            resposta = teclado.nextInt();
      }
      // --> Usar algo pra limpar a tela seria interessante
      if(resposta == 2){
        System.out.println("--> Exibindo Lista de Quadras :");
        lista_quadras.exibirNomeQuadras();
        
        System.out.println("Escolha uma Quadra: ");
        int numero_quadra = teclado.nextInt();
        
        System.out.println("\n->Descrição: ");
        lista_quadras.exibirDescricaoQuadras(numero_quadra);
        System.out.println("Valor |    |    [9] Confirmar  [1]Voltar");
        resposta = teclado.nextInt();
        if (resposta == 9){
            System.out.println("Dias Disponíveis");
            lista_quadras.exibirDiasDisponiveis(numero_quadra);
        }
        
      }
   } 
   
   
   public static void operacoesLocador(Locador locador,ListaQuadras lista_quadras){
        Scanner teclado = new Scanner(System.in);
        int resposta = 0;
        System.out.println("===*** Olá "+locador.getNome()+" ***===");
        
        while(resposta != 1){
            System.out.println("\nSelecione uma opção: ");
            System.out.println("[1] Voltar ao inicio \n[2] Meus Locais \n[3] Verificar agenda \n[4] Cadastrar novo local" );
            resposta = teclado.nextInt();
            while(resposta != 1 && resposta != 2 && resposta != 3 && resposta != 4){
                System.out.print("Digite uma opção válida");
                resposta = teclado.nextInt();
            }
            
            if(resposta == 2){
                System.out.println("-->Exibindo locais");
                lista_quadras.exibirNomeQuadras();   
                if(lista_quadras.tamanho() == 0){
                    System.out.println("Não há locais cadastrados");
                }else{
                    System.out.println("\nDigite o Numero da quadra para alterar");
                    System.out.println("[1] Voltar ");
                } 
            }
            if(resposta == 3){
                System.out.println("-->Quadras Agendadas");
                if(lista_quadras.tamanho() == 0){
                    System.out.println("Voce não possui nenhuma quadra agendada");
                }else{
                    System.out.println("Atualemnte voce tem X alocações");
                    System.out.println("Temos que trabalhar nesse método ");
                }
            }
            
            if(resposta == 4){
                Quadra2 quadraExemplo = new Quadra2("Quadra Futset Pinheiros","Esta quadra é absurdamente legal","1,2,3","18:00");
                lista_quadras.adicionarQuadras(quadraExemplo);
                System.out.println("Quadra: == " + quadraExemplo.getNome()+" == Adicionada");
                clear();
            }
        }   
        menu(lista_quadras);
   }

   public static void menu(ListaQuadras lista_quadras){
      Cliente cliente1 = new Cliente("Jônatas", "XXX.XXX.XXX.XXX", "@bol", "120");
      Locador locador1 = new Locador("Beach Sports", "@bol", "321", "bb");
      Scanner teclado = new Scanner(System.in);
      
      //Estou supondo que o login é o mesmo
      System.out.println("------ JOGA Y JOGA Y --------");
      int resposta = 0;
      while(resposta != 1 && resposta != 2){
            System.out.print("Selecione uma opção: \n[1]Cliente [2]Locador\n--> ");
            resposta = teclado.nextInt();
      }
      if(resposta == 1){
          operacoesCliente(cliente1,lista_quadras);
      }else{
          operacoesLocador(locador1,lista_quadras);
      }
   }
   
   
   public static void main(String[] args) {
      //Instanciamos uma lista de quadras
      ListaQuadras lista_quadras = new ListaQuadras();
      menu(lista_quadras);
      
      
      
      
   }
}
