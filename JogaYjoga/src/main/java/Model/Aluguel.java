/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;




public class Aluguel {
    private int Id;
    private Cliente cliente;
    private Quadra quadra;
    private String valor;
    private String data;
    
   
    public Aluguel(int Id,Quadra quadra, String valor, String data) {
        this.Id = Id;
        this.quadra = quadra;
        this.valor = valor;
        this.data = data;
    }
    
    public Aluguel(int Id, Cliente cliente, Quadra quadra, String valor, String data) {
        this.Id = Id;
        this.cliente = cliente;
        this.quadra = quadra;
        this.valor = valor;
        this.data = data;
    }

    public int getId() {
        return Id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Quadra getQuadra() {
        return quadra;
    }

    public String getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }

   
    
    public String exibirDetalhes() {
        StringBuilder detalhes = new StringBuilder();
        detalhes.append("Detalhes do Aluguel:");
        //detalhes.append("Cliente: ").append( cliente.getNome());
        detalhes.append(  "\nQuadra: " ).append( quadra.getNome());
        detalhes.append(  "\nData: " ).append( this.data);
        return detalhes.toString();
    }
    
    
    //Reservar Horário
    
    
    
    //Mostar status

}
