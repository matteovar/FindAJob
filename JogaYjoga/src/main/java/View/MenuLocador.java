package View;

import Controller.*;
import Model.*;

import java.util.Scanner;

public class MenuLocador {
    private final Locador locador;
    private final OperacoesLocador controller;
    private final ListaQuadras listaQuadras;

    public MenuLocador(String nome, String email, String senha, String cnpj, ListaQuadras listaQuadras) {
        this.locador = new Locador(nome, email, senha, cnpj);
        this.controller = new OperacoesLocador(this);
        this.listaQuadras = listaQuadras; // Usar a mesma instância passada como parâmetro
    }

    public void inicia() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("===*** Olá " + locador.getNome() + " ***===");
        boolean voltarMenuPrincipal = false;
        while (!voltarMenuPrincipal) {
            System.out.println("\nSelecione uma opção: ");
            System.out.println("[1] Voltar ao inicio \n[2] Meus Locais \n[3] Verificar agenda \n[4] Cadastrar novo Local");
            int opcao = teclado.nextInt();
            while (opcao < 1 || opcao > 4) {
                System.out.print("Digite uma opção válida: ");
                opcao = teclado.nextInt();
            }
            Main.clear();
            voltarMenuPrincipal = controller.navegar(opcao, locador, listaQuadras);
        }
    }

    public void exibirLocais(ListaQuadras listaQuadras) {
        for (int i = 0; i < listaQuadras.tamanho(); i++) {
            Quadra quadra = listaQuadras.getQuadra(i);
            System.out.println("Local: " + quadra.getNome());
        }
    }

    public void exibirAgenda(ListaQuadras listaQuadras) {
        for (int i = 0; i < listaQuadras.tamanho(); i++) {
            Quadra quadra = listaQuadras.getQuadra(i);
            System.out.println("Agenda para a quadra: " + quadra.getNome());
            quadra.getDiasHorarios().forEach((data, horarios) -> {
                System.out.println("Data: " + data);
                if (horarios.isEmpty()) {
                    System.out.println("  Todos os horários estão reservados.");
                } else {
                    System.out.println("  Horários disponíveis: " + horarios);
                }
            });
            System.out.println();
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
