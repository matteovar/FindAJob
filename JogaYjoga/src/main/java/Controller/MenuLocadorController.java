/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Quadra;
import Model.ListaQuadras;
import View.Alugar;
import View.MenuLocador;


//TODAS AS AÇÕES ->CADASTRAR,EXCLUIR,ATUALIZAR SÃO RESPONSÁVIES DO CONTROLLER
public class MenuLocadorController {
    private final MenuLocador view;
    private ListaQuadras listaQuadra;

    public MenuLocadorController(MenuLocador view) {
        this.view = view; 
        listaQuadra = new ListaQuadras();
    }
    
    
    public void navegacao(){
        int opcao = view.getOpcao();
        if(opcao == 1){
            view.exibirMensagem("  -= LOGIN =-\n   JogaYJoga\n");
            //TEMOS QUE VOLTA AO INICIO
        } 
        if(opcao == 2){
            view.exibirMensagem("-->Exibindo Locais");
            if(listaQuadra.tamanho() == 0){
                view.exibirMensagem("Não há quadras cadastradas\n");
            }else{
                view.exibirMensagem(listaQuadra.exibirNomeQuadras());
            }
            view.inicia();
        }
        
        if(opcao == 3){
            if(listaQuadra.tamanho() == 0){
                view.exibirMensagem("Não há quadras cadastradas\n");
            }else{
                System.out.println("\n<IMPLEMENTAR AQUI>\n");
                
                //Deveriamos ir para uma agenda
                Alugar agenda = new Alugar();
                
                //listaQuadra.exibirDescricaoQuadras(1);
            }
            view.inicia();
        }
        if(opcao == 4){
            Quadra novaQuadra = new Quadra("Futset","Quadra muito legal",null,"110");
            Quadra novaQuadra1 = new Quadra("Playball Pompeia","Quadra do playball",null,"120");
            listaQuadra.adicionarQuadras(novaQuadra);
            listaQuadra.adicionarQuadras(novaQuadra1);
            view.exibirMensagem("Quadra: == "+ novaQuadra.getNome() + " == Adicionada com sucesso\n ");
            view.exibirMensagem("Quadra: == "+ novaQuadra1.getNome() + " == Adicionada com sucesso\n ");
            view.inicia();
        }
        
        
    }
}
