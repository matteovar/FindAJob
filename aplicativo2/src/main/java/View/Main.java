package View;

import Model.*;

import java.util.Scanner;

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

    public static void menu(ListaQuadras listaQuadras) {
        Cliente cliente1 = new Cliente("Jônatas", "XXX.XXX.XXX.XXX", "@bol", "120", null);
        Locador locador1 = new Locador("Beach Sports", "@gmail", "321", "bb", null);
        Scanner teclado = new Scanner(System.in);

        while (true) {
            System.out.println("------ JOGA Y JOGA Y --------");
            System.out.print("Selecione uma opção: \n[1] Cliente \n[2] Locador \n[3] Sair\n--> ");
            int resposta = teclado.nextInt();

            clear();
            if (resposta == 1) {
                MenuCliente menuCliente = new MenuCliente(cliente1.getNome(), cliente1.getCpf(), cliente1.getEmail(), cliente1.getSenha(), listaQuadras);
                menuCliente.inicia();
            } else if (resposta == 2) {
                MenuLocador menuLocador = new MenuLocador(locador1.getNome(), locador1.getEmail(), locador1.getSenha(), locador1.getCnpj(), listaQuadras);
                menuLocador.inicia();
            
            } else if (resposta == 3) {
                System.out.println("Obrigado por usar o JogaYJoga");
                break; // Sair do loop e terminar o programa
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void main(String[] args) {
        ListaQuadras listaQuadras = new ListaQuadras();
        menu(listaQuadras);
    }
}
