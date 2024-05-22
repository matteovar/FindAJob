package JogaYJoga.Pacotao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListaQuadras {
    private ArrayList<Quadra2> listaOpcoes;

    public ListaQuadras() {
        listaOpcoes = new ArrayList<>();
    }

    public ListaQuadras(Quadra2 quadra) {
        listaOpcoes = new ArrayList<>();
        listaOpcoes.add(quadra);
    }

    public int tamanho() {
        return listaOpcoes.size();
    }

    public void adicionarQuadras(Quadra2 quadra) {
        listaOpcoes.add(quadra);
    }

    public void exibirNomeQuadras() {
        for (int i = 0; i < listaOpcoes.size(); i++) {
            System.out.println("[" + i + "] " + listaOpcoes.get(i).getNome());
        }
    }

    public void exibirDescricaoQuadras(int posicao) {
        if (posicao >= 0 && posicao < listaOpcoes.size()) {
            System.out.println(listaOpcoes.get(posicao).getDescricao());
        } else {
            System.out.println("Posição inválida.");
        }
    }

    public void exibirDiasDisponiveis(int posicao) {
        if (posicao >= 0 && posicao < listaOpcoes.size()) {
            System.out.println("Dias e horários disponíveis:");
            listaOpcoes.get(posicao).getDiasHorarios().forEach((data, horarios) -> {
                System.out.println("Data: " + data + " - Horários: " + horarios);
            });
        } else {
            System.out.println("Posição inválida.");
        }
    }

    public void exibirValor(int posicao) {
        if (posicao >= 0 && posicao < listaOpcoes.size()) {
            System.out.println(listaOpcoes.get(posicao).getValor());
        } else {
            System.out.println("Posição inválida.");
        }
    }

    public void excluirQuadra(int posicao) {
        if (posicao >= 0 && posicao < listaOpcoes.size()) {
            listaOpcoes.remove(posicao);
            System.out.println("Quadra removida com sucesso.");
        } else {
            System.out.println("Posição inválida.");
        }
    }

    public Quadra2 getQuadra(int posicao) {
        if (posicao >= 0 && posicao < listaOpcoes.size()) {
            return listaOpcoes.get(posicao);
        } else {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }
    }
}
