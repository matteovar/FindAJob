package View;

import Controller.*;
import Model.*;

import java.util.Scanner;

public class MenuLocador {
    private Locador locador;
    private final OperacoesLocador controller;

    public MenuLocador(Locador locador) {
        this.locador = locador;
        this.controller = new OperacoesLocador(this);
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
            voltarMenuPrincipal = controller.navegar(opcao, locador);
        }
    }

    public void exibirLocais() {
        for (int i = 0; i < locador.getTotalQuadras(); i++) {
            Quadra quadra = locador.getQuadra(i);
            System.out.println(quadra.getNome());
        }
    }

    public void exibirAgenda(ListaQuadras listaQuadras) {
        for (int i = 0; i < listaQuadras.tamanho(); i++) {
            Quadra quadra = locador.getQuadra(i);
            System.out.println("Agenda para a quadra: " + quadra.getNome());
            System.out.println("quadra.getDiasHorarios()");
            System.out.println();
        }
    }

    public Locador getLocador() {
        return this.locador;
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}