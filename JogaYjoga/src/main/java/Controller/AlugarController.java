/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Aluguel;
import Model.ListaQuadras;
import java.util.Scanner;
import View.Alugar;


public class AlugarController {
    private final Alugar view;
    private int numeroQuadra;
    //private final AgendaHelper helper;

    public AlugarController(Alugar view) {
        this.view = view;
        //this.helper = new AgendaHelper(view);
    }
    
    public void exibirLista(){
        Scanner teclado = new Scanner(System.in);
        //Buscar lista no Banco de dados
        ListaQuadras quadras = new ListaQuadras();
        quadras.iniciar();
        
        //Exibir lista na view
        view.exibirMensagem("Escolha uma Quadra: \n");
        view.exibirMensagem(quadras.exibirNomeQuadras());
        numeroQuadra = teclado.nextInt();
        view.exibirMensagem("Descrição: ");
        view.exibirMensagem(quadras.exibirDescricaoQuadras(numeroQuadra));
        view.exibirMensagem("\nValor: R$");
        view.exibirMensagem(quadras.exibirValor(numeroQuadra));
        view.exibirMensagem("\n[9] Confirmar [1] Voltar\n");
        int resposta = teclado.nextInt();
        
        if(resposta == 9){
            view.exibirMensagem("Dias disponiveis");
            view.exibirMensagem(quadras.exibirDiasDisponiveis(numeroQuadra));
            String diaEscolhido = teclado.next();
            quadras.excluirDia(numeroQuadra, diaEscolhido);
            view.exibirMensagem("\n");
            Aluguel informacoes = new Aluguel(1,quadras.getQuadra(numeroQuadra),quadras.exibirValor(numeroQuadra),diaEscolhido);
            view.exibirMensagem(informacoes.exibirDetalhes());
        }
        
        if(resposta == 1){
            view.exibirMensagem("  -= LOGIN =-\n   JogaYJoga\n");
        }
        //helper.preencherTabela(quadras);
    }
}
