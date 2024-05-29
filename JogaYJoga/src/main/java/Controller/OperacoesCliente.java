package Controller;

import Model.*;
import View.*;
import java.time.LocalDate;
import java.util.Scanner;

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
                view.exibirDetalhesQuadra(quadrasAlocadas);
            }
        } else if (opcao == 3) {
            if (quadrasAlocadas.tamanho() == 0) {
                view.exibirMensagem("Não possui nenhuma quadra cadastrada.");
            } else {  
                view.exibirMensagem("Quadras Disponíveis: ");
                quadraView.exibirNomeQuadras(quadrasAlocadas);
                
                System.out.println("Digite o numero");
                Scanner teclado = new Scanner(System.in);
                int resposta = teclado.nextInt();
                view.exibirMensagem("Exibindo Agenda");
                view.exibirMensagem(quadrasAlocadas.getQuadra(resposta).getAgenda().getHorariosDisponiveis());
                
                Agendas agenda = quadrasAlocadas.getQuadra(resposta).getAgenda();
                quadrasAlocadas.getQuadra(resposta).getAgenda().reservaHorario(LocalDate.of(2024, 06, 13), "08:00 - 09:00");
                quadrasAlocadas.getQuadra(resposta).getAgenda().reservaHorario(LocalDate.of(2024, 06, 13), "10:00 - 11:00");

                //aluguel.Alugar(Cliente,quadras.Alocadas.getQ);
                view.exibirMensagem(quadrasAlocadas.getQuadra(resposta).getNome() + "Alugada em ");
                view.exibirMensagem(quadrasAlocadas.getQuadra(resposta).getAgenda().getHorariosReservados());
            }
        }
        return false; 
    }
   
}
