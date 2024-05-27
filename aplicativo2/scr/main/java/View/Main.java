package View;

import Model.*;
import Controller.*;

import java.util.Scanner;

import Controller.OperacoesCliente;
import Controller.OperacoesLocador;
import Controller.QuadraController;

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
        Cliente cliente1 = new Cliente("Jônatas", "XXX.XXX.XXX.XXX", "@bol", "120");
        Locador locador1 = new Locador("Beach Sports", "@gmail", "321", "bb");
        Scanner teclado = new Scanner(System.in);
        QuadraController quadraController = new QuadraController(listaQuadras);

        while (true) {
            System.out.println("------ JOGA Y JOGA Y --------");
            System.out.print("Selecione uma opção: \n[1] Cliente \n[2] Locador \n[3] Sair\n--> ");
            int resposta = teclado.nextInt();

            clear();
            if (resposta == 1) {
                OperacoesCliente.operacoesCliente(cliente1, quadraController);
            } else if (resposta == 2) {
                OperacoesLocador.operacoesLocador(locador1, listaQuadras);
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