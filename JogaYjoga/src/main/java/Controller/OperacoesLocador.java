package Controller;

import Model.*;
import View.*;

public class OperacoesLocador {
    private final MenuLocador view;
    private Locador locador;

    public OperacoesLocador(MenuLocador view) {
        this.view = view;
        this.locador = view.getLocador();
    }

    public static boolean quadraJaAdicionada(Locador locador, String nomeQuadra) {
        for (int i = 0; i < locador.getTotalQuadras(); i++) {
            Quadra quadra = locador.getQuadra(i);
            if (quadra.getNome().equalsIgnoreCase(nomeQuadra)) {
                return true;
            }
        }
        return false;
    }

    public boolean navegar(int opcao, Locador locador, ListaQuadras listaQuadras) {
        while (true) {
            if (opcao == 1) {
                view.exibirMensagem("Voltando ao menu principal...");
                return true; // Indica que deve voltar ao menu principal
            } else if (opcao == 2) {
                if (locador.getTotalQuadras() == 0) {
                    view.exibirMensagem("Não há locais cadastrados");
                } else {
                    view.exibirMensagem("Exibindo locais:");
                    view.exibirLocais(locador.getObjetolista());
                }
            } else if (opcao == 3) {
                if (locador.getTotalQuadras() == 0) {
                    view.exibirMensagem("Você não possui nenhuma quadra cadastrada.");
                } else {
                    view.exibirMensagem("Verificando Agenda:");
                    view.exibirAgenda(listaQuadras);
                }
            } else if (opcao == 4) {
                Quadra novaQuadra = new Quadra("Futset", "Quadra Legal", Agendas.getDiasHorarios(), "100");
                if (!quadraJaAdicionada(locador, novaQuadra.getNome())) {
                    locador.adicionarQuadras(novaQuadra);
                    view.exibirMensagem(locador.getListaQuadras());
                } else {
                    view.exibirMensagem("Quadra: == " + novaQuadra.getNome() + " == já está cadastrada\n");
                }
            } else {
                view.exibirMensagem("Opção inválida");
            }
            return false; // Não voltar ao menu principal
        }
    }
}