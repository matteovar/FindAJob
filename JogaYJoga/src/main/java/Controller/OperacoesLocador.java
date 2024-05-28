package Controller;

import Model.*;
import View.*;
import java.util.ArrayList;
import java.time.LocalDate;


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

    public boolean navegar(int opcao, Locador locador) {
        while (true) {
            if (opcao == 1) {
                view.exibirMensagem("Voltando ao menu principal...");
                return true; // Indica que deve voltar ao menu principal
            } else if (opcao == 2) {
                if (locador.getTotalQuadras() == 0) {
                    view.exibirMensagem("Não há locais cadastrados");
                } else {
                    view.exibirMensagem("Exibindo locais:");
                    view.exibirLocais();
                }
            } else if (opcao == 3) {
                if (locador.getTotalQuadras() == 0) {
                    view.exibirMensagem("Você não possui nenhuma quadra cadastrada.");
                } else {
                    view.exibirMensagem("Verificando Agenda:");
                    for(int i = 0;i < locador.getTotalQuadras();i++){
                        view.exibirMensagem(" Quadra "  + locador.getQuadra(0).getNome());
                        view.exibirMensagem("Horarios agendados:");
                        view.exibirMensagem(locador.getQuadra(i).getAgenda().getHorariosReservados());
                        view.exibirMensagem("Horarios livres:");
                        view.exibirMensagem("" + locador.getQuadra(i).getAgenda().getDiasHorario());
                        
                    }
                    locador.getQuadra(0).getAgenda().reservaHorario(LocalDate.of(2024,06,13),"08:00 - 09:00");
                }
            } else if (opcao == 4) {
                Agendas agenda = new Agendas();
                ArrayList<String> horarios = new ArrayList();
                horarios.add("08:00 - 09:00");
                horarios.add("10:00 - 11:00");
                horarios.add("11:00 - 12:00");
                horarios.add("12:00 - 13:00");
                agenda.AdicionarDias(LocalDate.of(2024, 06, 13),horarios);
                Quadra novaQuadra = new Quadra("-= Futset =- ", "Quadra de Futebol localizada em guarulhos",agenda, "100");
                
                if (!quadraJaAdicionada(locador, novaQuadra.getNome())) {
                    locador.adicionarQuadras(novaQuadra);
                    view.exibirMensagem(locador.getQuadra(locador.getTotalQuadras()-1).getNome());
                    view.exibirMensagem(locador.getQuadra(locador.getTotalQuadras()-1).getDescricao());
                    view.exibirMensagem("R$" + locador.getQuadra(locador.getTotalQuadras()-1).getValor());
                } else {
                    view.exibirMensagem("XXX " + novaQuadra.getNome() + " == já está cadastrado\n");      
                }
            } else {
                view.exibirMensagem("Opção inválida");
            }
            return false; // Não voltar ao menu principal
        }
    }
}