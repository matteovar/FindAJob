package View;

import Controller.MenuController;
import java.util.Scanner;

public class MenuCliente {
    private  final MenuController controller;
    private int opcao;

    public MenuCliente() {
        this.controller = new MenuController(this);
    }
    
    public void inicia(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bem vindo de volta ");
        System.out.println("[1] Voltar ao inicio \n[2] Alugar uma quadra ");
        this.opcao = teclado.nextInt();
        controller.navegar();
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }
    
    public void exibirMensagem(String mensagem){
        System.out.println(mensagem);
    }
    
    
}
