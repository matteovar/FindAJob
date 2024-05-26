
package View;

import Controller.AlugarController;


public class Alugar {
    private final AlugarController controller;
    
    public Alugar(){
        controller = new AlugarController(this);//Quer dizer que eu quero que alguém me controle
        
    }
    
    public void iniciar() {
        System.out.println("-= Aluguel de Quadras =-");
        controller.exibirLista();
    }
    
    public void exibirMensagem(String mensagem){
        System.out.print(mensagem);
        
    }
}
