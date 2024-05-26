/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.Alugar;
import View.MenuCliente;


public class MenuController {
    private final MenuCliente view;
    

    public MenuController(MenuCliente view) {
        this.view = view;
    }
    
    public void navegar(){
        int opcao = view.getOpcao();
        if(opcao == 1){
            view.exibirMensagem("  -= LOGIN =-\n   JogaYJoga\n");
            //TEMOS QUE VOLTA AO INICIO     
        }
        if(opcao == 2){
            Alugar aluguel = new Alugar();
            aluguel.iniciar();
        }
    }
    
    
    
    
}
