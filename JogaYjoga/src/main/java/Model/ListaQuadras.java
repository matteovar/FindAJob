package Model;

import java.util.ArrayList;

public class ListaQuadras {
    private ArrayList<Quadra> listaOpcoes;

    public ListaQuadras() {
        listaOpcoes = new ArrayList<>();
    }

    public ListaQuadras(Quadra quadra) {
        listaOpcoes = new ArrayList<>();
        listaOpcoes.add(quadra);
    }

    public int tamanho() {
        return listaOpcoes.size();
    }

    public void adicionarQuadras(Quadra quadra) {
        listaOpcoes.add(quadra);
    }

    public void exibirNomeQuadras() {
        for (int i = 0; i < listaOpcoes.size(); i++) {
            System.out.println("[" + i + "] " + listaOpcoes.get(i).getNome());
        }
    }

    public Quadra getQuadra(int posicao) {
        if (posicao >= 0 && posicao < listaOpcoes.size()) {
            return listaOpcoes.get(posicao);
        } else {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }
    }
}