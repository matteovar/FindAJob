package View;
import Controller.LoginController;
import Model.Aluguel;
import java.util.Scanner;
import Model.Cliente;
import Model.Locador;
import Model.Quadra;
 
public class Main {
    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
  
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Quadra quadra1 =  new Quadra("Futset Pinheiros","Quadra Localizada em pinheiros ",null,"100R$");
        Cliente cliente = new Cliente("Jonatas","394", "@bol", "123");
        Locador locador = new Locador("Beach Sports","@gmail","321","bb");
        //Aluguel aluguel = new Aluguel(1, cliente, quadra1, "100", "13/04/2001 13");
        //System.out.println(aluguel.getQuadra().getNome()+" Alugada em "+aluguel.getData());
        System.out.println("Selecione: [1]Cliente [2]Locador");
        int resposta = teclado.nextInt();
        if(resposta == 1){
            System.out.println("Usuário: "+cliente.getNome());
            Login log = new Login(cliente.getNome(),cliente.getSenha());
            log.entrar(cliente.getNome(),cliente.getSenha());
        }else if(resposta == 2){
            System.out.println("Locador: "+locador.getNome());
            Login log1 = new Login(locador.getNome(),locador.getSenha());
            log1.entrar(locador.getNome(),locador.getSenha());
        }
        
    }

    
}
