package Controller;

import Model.*;
import View.*;

public class OperacoesCliente {
    private final MenuCliente view;
    private ListaQuadras quadrasAlocadas;
    private final QuadraView quadraView;
    
    private Cliente cliente;

    public OperacoesCliente(MenuCliente view) {
        this.view = view;
        this.cliente = view.getCliente();
        this.quadraView = new QuadraView();
    }

    public boolean navegar(int opcao, Cliente cliente, ListaQuadras quadrasAlocadas) {
        this.quadrasAlocadas = quadrasAlocadas;
    
        if (opcao == 1) {
            view.exibirMensagem("Voltando ao menu principal...");
            return true; // Indica que deve voltar ao menu principal
        } else if (opcao == 2) {
            if (quadrasAlocadas.tamanho() == 0) {
                view.exibirMensagem("Não há locais cadastrados");
            } else {
                view.exibirMensagem("Exibindo locais:");
                //view.exibirDetalhesQuadra(Aluguel.exibirDetalhes().);
            }
        } else if (opcao == 3) {
            if (quadrasAlocadas.tamanho() == 0) {
                view.exibirMensagem("Não possui nenhuma quadra cadastrada.");
            } else {  
                view.exibirMensagem("Quadras Disponíveis: ");
                quadraView.exibirNomeQuadras(quadrasAlocadas);
   
                view.exibirMensagem("Pegar as quadras e fazer a lógica que tava antes,só que eu me enrolei ");
                //view.reservarQuadras();
            }
        }
        return false; // Não voltar ao menu principal
    }
   
}
