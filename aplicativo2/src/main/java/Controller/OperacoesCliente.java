package Controller;

import Model.*;
import View.*;

public class OperacoesCliente {
    private final MenuCliente view;
    private Cliente cliente;

    public OperacoesCliente(MenuCliente view) {
        this.view = view;
        this.cliente = view.getCliente();
    }

    public boolean navegar(int opcao, Cliente cliente, ListaQuadras listaQuadras) {
        if (opcao == 1) {
            view.exibirMensagem("Voltando ao menu principal...");
            return true; // Indica que deve voltar ao menu principal
        } else if (opcao == 2) {
            if (cliente.getTotalQuadras() == 0) {
                view.exibirMensagem("Não há locais cadastrados");
            } else {
                view.exibirMensagem("Exibindo locais:");
                view.exibirDetalhesQuadra(cliente.getObjetolista());
            }
        } else if (opcao == 3) {
            if (cliente.getTotalQuadras() == 0) {
                view.exibirMensagem("Não possui nenhuma quadra cadastrada.");
            } else {
                view.exibirMensagem("Quadras Cadastradas");
                view.reservarQuadra(cliente);
            }
        }
        return false;
    }
    
}
