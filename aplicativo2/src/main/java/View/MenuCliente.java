package View;

import Controller.*;
import Model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuCliente {
    private final Cliente cliente;
    private final OperacoesCliente controller;
    private final ListaQuadras listaQuadras;
    private final QuadraView quadraView;

    public MenuCliente(String nome, String cpf, String email, String senha, ListaQuadras listaQuadras) {
        this.cliente = new Cliente(nome, cpf, email, senha, listaQuadras);
        this.controller = new OperacoesCliente(this);
        this.listaQuadras = listaQuadras; // Usar a mesma instância passada como parâmetro
        this.quadraView = new QuadraView();
    }

    public void inicia() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("===*** Olá " + cliente.getNome() + " ***===");
        boolean voltarMenuPrincipal = false;
        while (!voltarMenuPrincipal) {
            System.out.println("\nSelecione uma opção: ");
            System.out.println("[1] Voltar ao início \n[2] Ver quadras Quadra\n[3] Agendar Quadras");
            int opcao = teclado.nextInt();
            while (opcao < 1 || opcao > 3) {
                System.out.print("Digite uma opção válida: ");
                opcao = teclado.nextInt();
            }
            Main.clear();
            voltarMenuPrincipal = controller.navegar(opcao, cliente, listaQuadras);
        }
    }

    public void exibirDetalhesQuadra(ListaQuadras listaQuadras) {
        int opcaoQuadra = quadraView.obterOpcaoQuadra(listaQuadras);

        quadraView.exibirDescricaoQuadra(listaQuadras, opcaoQuadra);
        quadraView.exibirValor(listaQuadras, opcaoQuadra);
    }

    public void reservarQuadra(Cliente Cliente) {
        int opcaoQuadra = quadraView.obterOpcaoQuadra(listaQuadras);
        ArrayList<LocalDate> diasDisponiveis = new ArrayList<>(listaQuadras.getQuadra(opcaoQuadra).getDiasHorarios().keySet());

        if (diasDisponiveis.isEmpty()) {
            System.out.println("Não há dias disponíveis para esta quadra.");
        } else {
            LocalDate dataEscolhida = quadraView.obterDiaEscolhido(diasDisponiveis);
            if (dataEscolhida != null) {
                ArrayList<String> horarios = listaQuadras.getQuadra(opcaoQuadra).getHorariosDisponiveis(dataEscolhida);
                if (horarios.isEmpty()) {
                    System.out.println("Não há horários disponíveis para esta data.");
                } else {
                    String horarioEscolhido = quadraView.obterHorarioEscolhido(horarios);
                    if (horarioEscolhido != null) {
                        boolean reservado = listaQuadras.getQuadra(opcaoQuadra).reservarHorario(dataEscolhida, horarioEscolhido);
                        if (reservado) {
                            System.out.println("Horário " + horarioEscolhido + " no dia " + dataEscolhida + " reservado com sucesso.");
                        } else {
                            System.out.println("Falha ao reservar o horário. Tente novamente.");
                        }
                    }
                }
            }
        }
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
