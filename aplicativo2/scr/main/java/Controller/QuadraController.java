package Controller;

import Model.*;
import View.QuadraView;

import java.time.LocalDate;
import java.util.ArrayList;

public class QuadraController {
    private ListaQuadras listaQuadras;
    private QuadraView quadraView;

    public QuadraController(ListaQuadras listaQuadras) {
        this.listaQuadras = listaQuadras;
        this.quadraView = new QuadraView();
    }

    public void exibirDetalhesQuadra() {
        System.out.println("**-------- Informacoes da quadra--------**");
        int opcaoQuadra = quadraView.obterOpcaoQuadra(listaQuadras);

        System.out.println("\n**-------- Descricoes da Quadra--------**");
        quadraView.exibirDescricaoQuadra(listaQuadras, opcaoQuadra);
        quadraView.exibirValor(listaQuadras, opcaoQuadra);
    }

    public void reservarQuadra() {
        System.out.println("\n**-------- Selecione uma Quadra--------**");
        int opcaoQuadra = quadraView.obterOpcaoQuadra(listaQuadras);
        ArrayList<LocalDate> diasDisponiveis = new ArrayList<>(listaQuadras.getQuadra(opcaoQuadra).getDiasHorarios().keySet());

        if (diasDisponiveis.isEmpty()) {
            System.out.println("Não há dias disponíveis para esta quadra.");
        } else {
            LocalDate dataEscolhida = quadraView.obterDiaEscolhido(diasDisponiveis);
            if (dataEscolhida != null) {
                ArrayList<String> horarios = listaQuadras.getQuadra(opcaoQuadra).getHorariosDisponiveis(dataEscolhida);
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