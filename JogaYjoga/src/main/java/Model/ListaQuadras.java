/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    public void iniciar(){
        ArrayList<String> diasExemplo = new ArrayList();
        diasExemplo.add("10");
        diasExemplo.add("15");
        diasExemplo.add("20");
        Quadra quadraExemplo = new Quadra("Quadra Exemplo", "Estou exemplificadno", diasExemplo, "101");
        listaOpcoes.add(quadraExemplo);
    }
    public int tamanho() {
        return listaOpcoes.size();
    }

    public void adicionarQuadras(Quadra quadra) {
        listaOpcoes.add(quadra);
    }

    public String exibirNomeQuadras() {
        StringBuilder nomes = new StringBuilder();
        for (int i = 0; i < listaOpcoes.size(); i++) {
            nomes.append("[").append(i).append("]").append(listaOpcoes.get(i).getNome()).append("\n");
        }
        return nomes.toString();
    }

    public String exibirDescricaoQuadras(int posicao) {
        StringBuilder descricao = new StringBuilder();
        if (posicao >= 0 && posicao < listaOpcoes.size()) {
            descricao.append(listaOpcoes.get(posicao).getDescricao());
        } else {
            descricao.append("Posição inválida.");
        }
        return descricao.toString();
    }

    public String exibirDiasDisponiveis(int posicao){
        StringBuilder dias = new StringBuilder();
        if (posicao >= 0 && posicao < listaOpcoes.size()){
            dias.append(listaOpcoes.get(posicao).getDiasHorarios());
        }
        return dias.toString();
    }
    
    /*
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
       */
    public String exibirValor(int posicao) {
        StringBuilder valor = new StringBuilder();
        if (posicao >= 0 && posicao < listaOpcoes.size()) {
            valor.append(listaOpcoes.get(posicao).getValor());
        } else {
            valor.append("Posição inválida.");
        }
        return valor.toString();
    }

    public void excluirQuadra(int posicao) {
        if (posicao >= 0 && posicao < listaOpcoes.size()) {
            listaOpcoes.remove(posicao);
            System.out.println("Quadra removida com sucesso.");
        } else {
            System.out.println("Posição inválida.");
        }
    }
    
    public void excluirDia(int posicao,String dia){
        if (posicao >= 0 && posicao < listaOpcoes.size()){
            ArrayList<String> aux = listaOpcoes.get(posicao).getDiasHorarios();
            aux.remove(dia);
            listaOpcoes.get(posicao).setDiasHorarios(aux);
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

