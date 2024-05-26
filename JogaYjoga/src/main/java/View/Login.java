package View;

import Controller.LoginController;

public class Login {
    private String nome;
    private String senha;
    
    private final LoginController controller;
    
    public Login(){
        controller = new LoginController(this);
        //Banco.inicia() -> Instancia um monte de objeto
        //Iniciar um banco de dados??
    }
   
    public Login(String nome,String senha){
        controller = new LoginController(this);
        this.nome = nome;
        this.senha = senha;
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void entrar(String usuario,String senha){
        this.controller.entrarNoSistema();
        
    }
    
    //Esse metodo eu to usando no login
    public void exibeMensagem(String mensagem) {
        System.out.println(mensagem);
    }



    
    
    
}
