/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Controller.MenuLocadorController;
import java.util.Scanner;

public class MenuLocador {
    private int opcao;
    private String nome;
    
    private final MenuLocadorController controller;
    
    public MenuLocador(String nome){
        this.controller = new MenuLocadorController(this);
        this.nome = nome;
        
    }
    
    public void inicia(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bem vindo de volta ");
        System.out.println("[1] Voltar ao inicio \n[2] Meus Locais \n[3] Verificar agenda \n[4] Cadastrar novo Local");
        opcao = teclado.nextInt();
        controller.navegacao();
        //controller.navegarParaAgenda();
    }
    
    public void exibirLocais(){
        
    }
    public void exibirMensagem(String mensagem){
        System.out.println(mensagem);
    }

    
    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
