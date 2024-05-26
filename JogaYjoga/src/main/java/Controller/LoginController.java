
package Controller;

import Controller.Helper.LoginHelper;
import Model.Cliente;
import View.Login;
import View.MenuCliente;
import View.MenuLocador;

public class LoginController {
    
    private final Login view;
    private LoginHelper helper;
    
    public LoginController(Login view){
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void entrarNoSistema(){
        view.exibeMensagem("Validando a entrada... \n");
        Cliente usuario = helper.obterModelo();
        
        
        if(usuario.getNome().equals("Jonatas") && usuario.getSenha().equals("123")){ //Pesquisar no Banco
            MenuCliente menu = new MenuCliente();   
            menu.exibirMensagem( "===*** Olá " + usuario.getNome() + " ***===");
            menu.inicia();     
        }else{
            MenuLocador menu = new MenuLocador(usuario.getNome());
            menu.exibirMensagem( "===*** Olá " + usuario.getNome() + " ***===");
            menu.inicia();
           
  
        } 
        
        //Se o usuario tiver o mesmo ususario e senha do que o usario do banco
        //Eu valido e pessoa vai pro menu se não usúario ou senha invalidos
  
    }
}
