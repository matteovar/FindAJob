package View;

import Model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class QuadraView {
    private Scanner scanner;
    private int opcao;

    public QuadraView() {
        scanner = new Scanner(System.in);
    }

    public void exibirNomeQuadras(ListaQuadras listaQuadras) {
        for (int i = 0; i < listaQuadras.tamanho(); i++) {
            System.out.println("[" + i + "] " + listaQuadras.getQuadra(i).getNome());
        }
    }

    public void exibirDescricaoQuadra(ListaQuadras listaQuadras, int posicao) {
        if (posicao >= 0 && posicao < listaQuadras.tamanho()) {
            System.out.println("Descrição: " + listaQuadras.getQuadra(posicao).getDescricao());
        } else {
            System.out.println("Posição inválida.");
        }
    }

    
    public void exibirValor(ListaQuadras listaQuadras, int posicao) {
        if (posicao >= 0 && posicao < listaQuadras.tamanho()) {
            System.out.println("Valor: " + listaQuadras.getQuadra(posicao).getValor());
        } else {
            System.out.println("Posição inválida.");
        }
    }

    public int obterOpcaoQuadra(ListaQuadras listaQuadras) {
        exibirNomeQuadras(listaQuadras);
        System.out.print("Escolha uma Quadra: ");
        return scanner.nextInt();
    }

    public LocalDate obterDiaEscolhido(ArrayList<LocalDate> diasDisponiveis) {
        System.out.println("Dias disponíveis:");
        for (int i = 0; i < diasDisponiveis.size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + diasDisponiveis.get(i));
        }

        System.out.print("Escolha um dia: ");
        int diaEscolhido = scanner.nextInt() - 1;
        if (diaEscolhido >= 0 && diaEscolhido < diasDisponiveis.size()) {
            return diasDisponiveis.get(diaEscolhido);
        } else {
            System.out.println("Opção de dia inválida.");
            return null;
        }
    }

    public String obterHorarioEscolhido(ArrayList<String> horarios) {
        if (horarios.isEmpty()) {
            System.out.println("Não há horários disponíveis para esta data.");
            return null;
        } else {
            System.out.println("Horários disponíveis:");
            for (int i = 0; i < horarios.size(); i++) {
                System.out.println("[" + (i + 1) + "] - " + horarios.get(i));
            }

            System.out.print("Escolha um horário: ");
            int horarioEscolhido = scanner.nextInt() - 1;
            scanner.nextLine(); 
            if (horarioEscolhido >= 0 && horarioEscolhido < horarios.size()) {
                return horarios.get(horarioEscolhido);
            } else {
                System.out.println("Opção de horário inválida.");
                return null;
            }
        }
    }
}
