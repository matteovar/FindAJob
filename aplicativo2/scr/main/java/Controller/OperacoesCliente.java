package Controller;

import Model.*;
import View.*;

import java.util.Scanner;

public class OperacoesCliente {
    public static void operacoesCliente(Cliente cliente, QuadraController quadraController) {
        Scanner teclado = new Scanner(System.in);
        int resposta;

        while (true) {
            System.out.println("Bem vindo de volta, " + cliente.getNome().toUpperCase());
            System.out.println("\nSelecione uma opção: ");
            System.out.println("[1] Voltar ao inicio \n[2] Alugar uma quadra");

            resposta = teclado.nextInt();
            while (resposta != 1 && resposta != 2) {
                System.out.print("Digite uma opção válida: ");
                resposta = teclado.nextInt();
            }

            Main.clear();
            if (resposta == 1) {
                return; // Voltar ao menu principal
            } else if (resposta == 2) {
                quadraController.exibirDetalhesQuadra();
                quadraController.reservarQuadra();
            }
        }
    }
}