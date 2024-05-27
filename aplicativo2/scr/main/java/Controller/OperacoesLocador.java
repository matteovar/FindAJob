package Controller;

import Model.*;
import View.Main;

import java.util.Scanner;

public class OperacoesLocador {
    public static boolean quadraJaAdicionada(ListaQuadras listaQuadras, String nomeQuadra) {
        for (int i = 0; i < listaQuadras.tamanho(); i++) {
            Quadra quadra = listaQuadras.getQuadra(i);
            if (quadra.getNome().equalsIgnoreCase(nomeQuadra)) {
                return true;
            }
        }
        return false;
    }

    public static void operacoesLocador(Locador locador, ListaQuadras listaQuadras) {
        Scanner teclado = new Scanner(System.in);
        int resposta = 0;
        System.out.println("===*** Olá " + locador.getNome() + " ***===");

        while (true) {
            System.out.println("\nSelecione uma opção: ");
            System.out.println("[1] Voltar ao inicio \n[2] Meus Locais \n[3] Verificar agenda \n[4] Cadastrar novo local");
            resposta = teclado.nextInt();
            while (resposta != 1 && resposta != 2 && resposta != 3 && resposta != 4) {
                System.out.print("Digite uma opção válida: ");
                resposta = teclado.nextInt();
            }

            Main.clear();
            if (resposta == 1) {
                return; // Voltar ao menu principal
            } else if (resposta == 2) {
                System.out.println("--> Exibindo locais:");
                listaQuadras.exibirNomeQuadras();
                if (listaQuadras.tamanho() == 0) {
                    System.out.println("Não há locais cadastrados");
                } else {
                    System.out.println("\nArrumar isso aqui");
                    
                }
            } else if (resposta == 3) {
                System.out.println("--> Verificando Agenda:");
                if (listaQuadras.tamanho() == 0) {
                    System.out.println("Você não possui nenhuma quadra cadastrada.");
                } else {
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
            } else if (resposta == 4) {
                Quadra novaQuadra = new Quadra("Futset", "Quadra Legal", Agendas.getDiasHorarios(), "100");

                if (!quadraJaAdicionada(listaQuadras, novaQuadra.getNome())) {
                    listaQuadras.adicionarQuadras(novaQuadra);
                    System.out.println("Quadra: == " + novaQuadra.getNome() + " == Adicionada com sucesso\n");
                } else {
                    System.out.println("Quadra: == " + novaQuadra.getNome() + " == já esta cadastrada\n");
                }
            }
        }
    }
}