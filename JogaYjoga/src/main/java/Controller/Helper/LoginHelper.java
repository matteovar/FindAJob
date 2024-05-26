/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Cliente;
import View.Login;


public class LoginHelper {
    //To usando o Helper pra me ajudar a pegar os dados do usuario
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Cliente obterModelo(){
        String nome = view.getNome(); 
        String senha = view.getSenha();
        Cliente modelo = new Cliente(nome, null, null, senha);
        return modelo;
    }
    
}
