package View;

import Controller.*;
import Model.*;

import java.util.Scanner;

public class MenuCliente {
    private final Cliente cliente;
    private final Locador locador;
    private final OperacoesCliente controller;
    private final QuadraView quadraView;

    public MenuCliente(Cliente cliente,Locador locador) {
        this.cliente = cliente;
        this.controller = new OperacoesCliente(this);
        this.quadraView = new QuadraView();
        this.locador = locador;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void inicia() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("===*** Olá " + cliente.getNome() + " ***===");
        boolean voltarMenuPrincipal = false;
        while (!voltarMenuPrincipal) {
            System.out.println("\nSelecione uma opção: ");
            System.out.println("[1] Voltar ao início \n[2] Ver meus locais \n[3] Alugar Quadras");
            int opcao = teclado.nextInt();
            while (opcao < 1 || opcao > 3) {
                System.out.print("Digite uma opção válida: ");
                opcao = teclado.nextInt();
            }
            Main.clear();
            voltarMenuPrincipal = controller.navegar(opcao, cliente,locador.getObjetolista());
        }
    }

    public void exibirDetalhesQuadra(ListaQuadras listaQuadras) {
        int opcaoQuadra = quadraView.obterOpcaoQuadra(listaQuadras);
        
        quadraView.exibirDescricaoQuadra(listaQuadras, opcaoQuadra);
        quadraView.exibirValor(listaQuadras, opcaoQuadra);
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
    
    
   
