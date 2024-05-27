package Controller;

import Model.*;
import View.*;

public class OperacoesCliente {
    private final MenuCliente view;

    public OperacoesCliente(MenuCliente view) {
        this.view = view;
    }

    public boolean navegar(int opcao, Cliente cliente, ListaQuadras listaQuadras) {
        if (opcao == 1) {
            view.exibirMensagem("Voltando ao menu principal...");
            return true; // Indica que deve voltar ao menu principal
        } else if (opcao == 2) {
            if (listaQuadras.tamanho() == 0) {
                view.exibirMensagem("Não há locais cadastrados");
            } else {
                view.exibirMensagem("Exibindo locais:");
                view.exibirDetalhesQuadra(listaQuadras);
            }
        } else if (opcao == 3) {
            if (listaQuadras.tamanho() == 0) {
                view.exibirMensagem("Não possui nenhuma quadra cadastrada.");
            } else {
                view.exibirMensagem("Quadras Cadastradas");
                view.reservarQuadra(listaQuadras);
            }
        }
        return false; // Não voltar ao menu principal
    }
}
